import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.pdfbox.cos.COSDocument
import org.apache.pdfbox.pdfparser.PDFParser
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.testng.Assert
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import org.apache.pdfbox.cos.COSDocument
import org.apache.pdfbox.pdfparser.PDFParser
import org.apache.pdfbox.text.PDFTextStripper
import org.testng.Assert
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import org.apache.pdfbox.Loader
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import org.apache.pdfbox.pdmodel.PDDocumentInformation


String fileName = "2006-ALS-MS-Annual-Meeting-Summary-Report.pdf"


String filePath = RunConfiguration.getProjectDir() +"/Data Files All/PDFReader/" +fileName
//String filePath2 = RunConfiguration.getProjectDir() + "/Data Files All/PdfReader/2016_als_prevalence.pdf"
// String filePath = RunConfiguration.getProjectDir() + "/Data Files All/PdfReader/test for link.pdf"
//KeywordUtil.logInfo( getPdfFileText2() )



//println new com.qa.utils.PDFReader().getPdfFileTextUsingPath(filePath)
	

println getPdfFileTextUsingPath2(filePath)

//	String urlPath = "file:///C:/Users/bijas/git/katalon-java-groovy-selenium/Data%20Files%20All/PDfReader/2006-ALS-MS-Annual-Meeting-Summary-Report.pdf"
//	println new com.qa.utils.PDFReader().getPdfFileTextUsingURL(urlPath)
//	
	

public static String getPdfFileTextUsingPath2(String pdfFilePath) throws IOException {
	File file = new File(pdfFilePath);
	FileInputStream inputStream = new FileInputStream(file);

	// Read file into byte array
	byte[] fileBytes = new byte[(int) file.length()];
	inputStream.read(fileBytes);
	inputStream.close();

	PDDocument document = null;
	try {
		// Load the PDF from byte array
		document = Loader.loadPDF(fileBytes);

		PDFTextStripper stripper = new PDFTextStripper();
		stripper.setStartPage(1);  // Explicitly set to start from page 1
		stripper.setEndPage(document.getNumberOfPages());  // Ensure it reads to the last page

		return stripper.getText(document);
	} finally {
		if (document != null) {
			document.close();
		}
	}
}








