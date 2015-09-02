package com.tusaludsv.report.util;

import java.io.ByteArrayOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ExportToReport {
	
	public static void write(HttpServletResponse response, ByteArrayOutputStream baos, String type, String namedReport){
		try{
			if(type.equalsIgnoreCase("PDF")){
				//response.setContentType("PDF");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".pdf");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("XLS")) {
				response.setContentType("XLS");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".xls");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("CSV")) {
				response.setContentType("CSV");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".CSV");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("HTML")) {
				response.setContentType("HTML");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".html");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("XML")) {
				response.setContentType("XML");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".xml");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("TXT")) {
				response.setContentType("TXT");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".txt");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("DOCX")) {
				response.setContentType("DOCX");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".docx");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("PPTX")) {
				response.setContentType("PPTX");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".pptx");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("XLSX")) {
				response.setContentType("XLSX");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".xlsx");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("ODS")) {
				response.setContentType("ODS");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".ods");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}else if (type.equalsIgnoreCase("ODT")) {
				response.setContentType("ODT");
				response.setHeader("Content-Disposition", "attachment;fileName="+namedReport+".odt");
				ServletOutputStream stp = response.getOutputStream();
				baos.writeTo(stp);
				stp.flush();
			}
		}catch(Exception ed){
			
			throw new RuntimeException(ed);
		}
	}
}
