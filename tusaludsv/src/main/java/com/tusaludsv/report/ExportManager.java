package com.tusaludsv.report;

import java.io.OutputStream;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

public class ExportManager {

	@SuppressWarnings("deprecation")
	public static void exportToOutputStream(JasperPrint printedReport, OutputStream stream, ExportFormat exportFormat) throws JRException {
    	if (exportFormat == ExportFormat.JASPER_VIEWVER) {
    		JasperExportManager.exportReportToXmlStream(printedReport, stream);
    	} 
    	else if (exportFormat == ExportFormat.PDF) {    		
			JasperExportManager.exportReportToPdfStream(printedReport, stream);
		} 
    	else if (exportFormat == ExportFormat.XLS) {
			JRAbstractExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.CSV) {
			JRAbstractExporter exporter = new JRCsvExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.HTML) {
			JRAbstractExporter exporter = new JRHtmlExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, false);
            exporter.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, true);
            exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.XML) {
			JRAbstractExporter exporter = new JRXmlExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.RTF) {
			JRAbstractExporter exporter = new JRRtfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.TXT) {
			JRAbstractExporter exporter = new JRTextExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
			exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float(6));
			exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Float(6));
			exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.DOCX) {
			JRAbstractExporter exporter = new JRDocxExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
			exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.PPTX) {
			JRAbstractExporter exporter = new JRPptxExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
			exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.XLSX) {
			JRAbstractExporter exporter = new JRXlsxExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
			exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.ODS) {
			JRAbstractExporter exporter = new JROdsExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
			exporter.exportReport();
		} 
    	else if (exportFormat == ExportFormat.ODT) {
			JRAbstractExporter exporter = new JROdtExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, printedReport);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
			exporter.exportReport();
		}
    }
	
}
