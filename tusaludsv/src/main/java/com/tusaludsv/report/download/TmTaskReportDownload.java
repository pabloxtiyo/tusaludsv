package com.tusaludsv.report.download;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.tusaludsv.report.AbstractReport;

public class TmTaskReportDownload<T> extends AbstractReport {

	private List<T> retrive = null;
	private String reportName;
	
	@Override
	protected JRDataSource getDataSource() {
		// TODO Auto-generated method stub
		return new JRBeanCollectionDataSource(getTaskReportData());
	}

	@Override
	public String getReportFileName() {
		// TODO Auto-generated method stub
		return getReportName();
	}
	
	private List<T> getTaskReportData(){
		return getRetrive();
	}
	
	
	public List<T> getRetrive() {
		return retrive;
	}

	public void setRetrive(List<T> retrive) {
		this.retrive = retrive;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

}
