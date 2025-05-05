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


String[] fileNames = ["2006-ALS-MS-Annual-Meeting-Summary-Report.pdf","2016_als_prevalence.pdf"]

for (String fileName : fileNames){
String filePath1 = RunConfiguration.getProjectDir() +"/Data Files All/PDFReader/" +fileName
//String filePath2 = RunConfiguration.getProjectDir() + "/Data Files All/PdfReader/2016_als_prevalence.pdf"
// String filePath = RunConfiguration.getProjectDir() + "/Data Files All/PdfReader/test for link.pdf"
//KeywordUtil.logInfo( getPdfFileText2() )



println new com.qa.utils.PDFReader().getPdfFileTextUsingPath(filePath1)
	
//	
//	String urlPath = "file:///C:/Users/bijas/git/katalon-java-groovy-selenium/Data%20Files%20All/PDfReader/2006-ALS-MS-Annual-Meeting-Summary-Report.pdf"
//	println new com.qa.utils.PDFReader().getPdfFileTextUsingURL(urlPath)
//	
	
//	new com.qa.utils.PDFReader().getHyperlinkUrlFromPDF(filePath, "http")
	

//println new com.qa.utils.PDFReader().getPdfTitle(filePath)

String pdfHeader = new com.qa.utils.PDFReader().getFirstPageHeader(filePath1).replaceAll('[\\r\\n]+', '')

new com.qa.utils.TextFile(RunConfiguration.getProjectDir()+"/Data Files All/OutputData/pdfFilesHeader"+new Date().format('yyyy-MM-dd')+".txt").append(fileName+' = '+pdfHeader)



}








