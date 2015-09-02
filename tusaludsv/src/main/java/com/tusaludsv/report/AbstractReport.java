package com.tusaludsv.report;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import net.sf.jasperreports.engine.JRBand;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRExpressionChunk;
import net.sf.jasperreports.engine.JRGroup;
import net.sf.jasperreports.engine.JRSection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseSubreport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public abstract class AbstractReport {
	
	private static final String REPORT_PACKAGE_BASE = "reports";
    private static final String REPORT_EXTENSION = ".jrxml";
    private static final String COMPILED_EXTENSION = ".jasper";
    private static final String REPORT_LOGO_PARAM_NAME = "p_logo";
    private static final String REPORT_LOGO_PATH = "/reports/logo.png";
    private JasperPrint jasperPrint = null;
    
    protected Map<String, Object> params = new HashMap<String, Object>();
                   
    protected abstract JRDataSource getDataSource();
    public abstract String getReportFileName();
        
    public void addParam(Parameter param) {
        params.put(param.getKey(), param.getValue());
    }

    public ByteArrayOutputStream printReport(ExportFormat format) {
    	try {
    		JRDataSource dataSource = getDataSource();
	        System.out.println(getReportFileName());
	        String compiledReportFilePath = compileReport();
	        JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(compiledReportFilePath);
	        compileAndAddSubreports(report);
	        //addLogoToParameters();
	        jasperPrint = JasperFillManager.fillReport(report, params, (((JRBeanCollectionDataSource)dataSource).getData()!=null)?
	        		dataSource : new JREmptyDataSource());
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        ExportManager.exportToOutputStream(jasperPrint, outputStream, format);
	        return outputStream;
    	}
    	catch (JRException e) {
    		throw new RuntimeException(e.getMessage());
    	}
    }
    public JasperPrint jasperprint() {
    	try {
    		JRDataSource dataSource = getDataSource();
	        String compiledReportFilePath = compileReport();
	        JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(compiledReportFilePath);
	        compileAndAddSubreports(report);
	        //addLogoToParameters();
	        jasperPrint = JasperFillManager.fillReport(report, params, (((JRBeanCollectionDataSource)dataSource).getData()!=null)?
	        		dataSource : new JREmptyDataSource());
	        return jasperPrint;
    	}
    	catch (JRException e) {
    		throw new RuntimeException(e.getMessage());
    	}
    }
    
    private String compileReport() throws JRException {
    	String fileName = REPORT_PACKAGE_BASE + "/" + getReportFileName() + REPORT_EXTENSION;
        String reportFileName = ResourceUtils.getRealFilePathForResource(fileName);
        if (reportFileName == null) {
        	throw new RuntimeException("Report not exist: " + fileName);
        }
        String compiledReportFileName = reportFileName.replaceAll(REPORT_EXTENSION, COMPILED_EXTENSION);
        if (!reportCompiled(reportFileName, compiledReportFileName)) {
        	JasperCompileManager.compileReportToFile(reportFileName, compiledReportFileName);
        }
        return compiledReportFileName;
    }
    
    private boolean reportCompiled(String reportFileName, String compiledReportFileName) {
    	File reportFile = new File(reportFileName);
		File compiledReportFile = new File(compiledReportFileName);
		if (compiledReportFile.exists() && compiledReportFile.lastModified() >= reportFile.lastModified()) {
	        System.out.println("compiled report " + compiledReportFile + " seems to be up to date");
	        return true;
		} else {
			if (compiledReportFile.exists()) {
				System.out.println("compiled report " + compiledReportFile + " not up to date, compiling...");
				compiledReportFile.delete();
			} 
			else {
				System.out.println("compiled report " + compiledReportFile + " not found, compiling...");
			}
			return false;
		}
	}
    
    private void compileAndAddSubreports(JasperReport report) throws JRException {
    	List<JRBaseSubreport> subreports = findSubreports(report);
        for (JRBaseSubreport subreport : subreports) {
            JRExpression expression = subreport.getExpression();
            JRExpressionChunk[] chunks = expression.getChunks();
            if (chunks.length == 1 && chunks[0].getType() == JRExpressionChunk.TYPE_PARAMETER) {
                String subreportParamName = expression.getChunks()[0].getText();
                String subreportFileName = REPORT_PACKAGE_BASE + "/" + subreportParamName;
                if (!subreportParamName.startsWith("default_")) {
                    subreportFileName = REPORT_PACKAGE_BASE + "/sub/" + subreportParamName;	                    
                }            
                String subReportFilePath = ResourceUtils.getRealFilePathForResource(subreportFileName + REPORT_EXTENSION);
                String compiledSubReportPath = subReportFilePath.replaceAll(REPORT_EXTENSION, COMPILED_EXTENSION);
                JasperCompileManager.compileReportToFile(subReportFilePath, compiledSubReportPath);           
                addParam(new Parameter(subreportParamName,compiledSubReportPath));
            }
        }
    }
   
    private List<JRBaseSubreport> findSubreports(JasperReport report) {
    	List<JRBaseSubreport> result = new ArrayList<JRBaseSubreport>();
        JRGroup[] groups = report.getGroups();
        if (groups != null) {
                for (JRGroup group : groups) {
                    JRSection groupHeaderSection = group.getGroupHeaderSection();
                    JRSection groupFooterSection = group.getGroupFooterSection();
                    if (groupHeaderSection != null && groupHeaderSection.getBands() != null) {
                            for (JRBand band : groupHeaderSection.getBands()) {
                                findSubreportsInBand(band, result);
                            }
                    }
                    if (groupFooterSection != null && groupFooterSection.getBands() != null) {
                            for (JRBand band : groupFooterSection.getBands()) {
                                findSubreportsInBand(band, result);
                            }
                    }
                }
        }
		// now in all bands
        findSubreportsInBand(report.getBackground(), result);
        findSubreportsInBand(report.getTitle(), result);
        findSubreportsInBand(report.getPageHeader(), result);
        findSubreportsInBand(report.getColumnHeader(), result);
        
        if (report.getDetailSection() != null && report.getDetailSection().getBands() != null) {
            for (JRBand band : report.getDetailSection().getBands()) {
                findSubreportsInBand(band, result);
            }
        }
        findSubreportsInBand(report.getColumnFooter(), result);
        findSubreportsInBand(report.getPageFooter(), result);
        findSubreportsInBand(report.getLastPageFooter(), result);
        findSubreportsInBand(report.getSummary(), result);        
        return result;        
    }

    private void findSubreportsInBand(JRBand band, List<JRBaseSubreport> list) {
        if (band == null) return;
        JRElement[] elements = band.getElements();
        for (JRElement element : elements) {
            if (element instanceof JRBaseSubreport) list.add((JRBaseSubreport) element);
        }
    }
    
    private void addLogoToParameters() {
    	try {
        	params.put(REPORT_LOGO_PARAM_NAME, null);
            BufferedImage image = ImageIO.read(getClass().getResource(REPORT_LOGO_PATH));
            if (image != null) {
                params.put(REPORT_LOGO_PARAM_NAME, image);
            }
        } 
        catch (Exception e) {
        	throw new RuntimeException("couldn't load logo");
        }
    }
    	
    public JasperPrint getJasperPrint() {
		return jasperPrint;
	}
	    
}
