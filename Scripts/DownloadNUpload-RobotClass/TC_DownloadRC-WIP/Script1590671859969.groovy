import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
//for selenium
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By;
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile

def currentBrowser = DriverFactory.getExecutedBrowser().getName()

	/***************************************************************
	 * Download file Using Robot class
	 * Need To run in --------FIREFOX------- to get Download pop up
	 * In chrome no pop up Occur
	 * import com.kms.katalon.core.webui.common.WebUiCommonHelper
	 **************************************************************/


	WebUI.openBrowser('http://demo.automationtesting.in/FileDownload.html')

	//for Text file download
	WebUI.setText(findTestObject('DemoAutomationTesting/FileDownload/txt_EnterDataText'), 'TestData For .txt')
	WebUI.click(findTestObject('DemoAutomationTesting/FileDownload/btn_GenerateFileText'))
	WebUI.delay(2)
	WebUI.click(findTestObject('DemoAutomationTesting/FileDownload/btn_downloadText'))
	WebElement element1 = WebUiCommonHelper.findWebElement(findTestObject('DemoAutomationTesting/FileDownload/btn_downloadText'),30)
	CustomKeywords.'library.GUI.DownloadFileRC.DownloadFileTEXT'(element1)

	WebUI.delay(2)

	//for PDF file download
//	WebUI.setText(findTestObject('DemoAutomationTesting/FileDownload/txt_EnterDataPdf'), 'TestData For .PDF')
//	WebUI.click(findTestObject('DemoAutomationTesting/FileDownload/btn_GenerateFilePdf'))
//	WebUI.delay(2)
//	WebElement element = WebUiCommonHelper.findWebElement(findTestObject('DemoAutomationTesting/FileDownload/btn_DownloadPdf'),30)
//	CustomKeywords.'library.GUI.DownloadFileRC.DownloadFilePDF'(element)


