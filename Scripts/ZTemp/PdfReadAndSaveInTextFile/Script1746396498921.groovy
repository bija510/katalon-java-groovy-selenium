import com.kms.katalon.core.configuration.RunConfiguration





savePDFFileHeaderAndTitle()



def savePDFFileHeaderAndTitle() {
	//Files name
	String[] fileNames = ["2006-ALS-MS-Annual-Meeting-Summary-Report.pdf","2016_als_prevalence.pdf" , "2020-als-annual-meeting-summary-report.pdf"]
	
	for (String fileName : fileNames){
		String filePath = RunConfiguration.getProjectDir() +"/Data Files All/PDFReader/" +fileName
		
		// Removes multi lines and bring back in 1 line
		String pdfHeader = new com.qa.utils.PDFReader().getFirstPageHeader(filePath).replaceAll('[\\r\\n]+', '')
		String pdfShortTitle = new com.qa.utils.PDFReader().getPdfTitle(filePath).replaceAll('[\\r\\n]+', '')
		
		// Write in the Text File in format key = value  , seperated by =
		new com.qa.utils.TextFile(RunConfiguration.getProjectDir()+"/Data Files All/OutputData/pdfFilesHeader"+new Date().format('yyyy-MM-dd')+".txt").append(fileName+' = '+pdfHeader +' = '+pdfShortTitle)
	
	}

}


