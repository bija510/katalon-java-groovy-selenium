import org.apache.pdfbox.cos.COSDocument
import org.apache.pdfbox.pdfparser.PDFParser
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.testng.Assert
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
/**************************************************************************************
	1. We need two jar file// First put in build.gradle without opening katalon studio
	2. Then CMD in the Location and Run:- gradle katalonCopyDependencies
	3. Apache FontBox » 1.8.1 https://mvnrepository.com/artifact/org.apache.pdfbox/fontbox
	4. Apache PDFBox  » 1.8.1 https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox
**************************************************************************************/

String filePath = RunConfiguration.getProjectDir() + "/Data Files All/PdfReader/test for link.pdf"

KeywordUtil.logInfo( "Page Count  = ${get_pageCount(filePath)}" )
KeywordUtil.logInfo( get_all_text(filePath) )

Assert.assertTrue( get_all_text(filePath).contains("Katalon Studio"))

Assert.assertTrue( get_all_text(filePath).contains("dsdsfdsf") )


public String get_all_text(String filePath){
	File file = new File(filePath)

	PDDocument document = PDDocument.load(file)
	
	PDFTextStripper strip = new PDFTextStripper()
	String data = strip.getText(document)
	
	//println data.trim() // this will remove the white space
	document.close();
	return data
	
}

public String get_pageCount(String filePath){
	File file = new File(filePath)
	PDDocument document = PDDocument.load(file)
	int pageCount = document.getNumberOfPages()
	
	String pc = pageCount.toString()
	document.close();
	return pc
	
}









