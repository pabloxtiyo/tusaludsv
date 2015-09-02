package com.tusaludsv.report;

public enum ExportFormat {

	JASPER_VIEWVER("jasper_viewer")
   ,PDF("pdf")
   ,XLS("xls")
   ,CSV("csv")
   ,HTML("html")
   ,XML("xml")
   ,RTF("rtf")
   ,TXT("txt")
   ,DOCX("docx")
   ,PPTX("pptx")
   ,XLSX("xlsx")
   ,ODS("ods")
   ,ODT("odt")
   ;
	
   private String value;

   private ExportFormat(String value) {
       this.value = value;
   }
   
   public static ExportFormat findByValue(String value) {
	   for(ExportFormat f:values())
		   if (f.getValue().equals(value)) return f;
	   return null;
   }

   public String getValue() {
       return this.value;
   }
	
}
