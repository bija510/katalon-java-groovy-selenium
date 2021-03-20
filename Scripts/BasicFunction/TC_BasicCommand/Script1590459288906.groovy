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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//for selenium
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

def currentBrowser = DriverFactory.getExecutedBrowser().getName()
WebDriver driver = DriverFactory.getWebDriver()
/************************************************************************************************
 * Ctrl + Shift + O = To remove unused Import and organize
 * Mouse hover to functin it will show what it Does?
 * System.exit(0)
 * for password increption help==>Encrypt Text==>input 
 * if any Form We can used 
 * WebUI.submit(findTestObject(''))==>if htere is Submit button then it will click
 * "Ctrl + I" , "Ctrl+a" , "Ctrl+Shift+f" ,"Select all +tab/i" , "Shift+click+anoClick" Ctrl+click..
 *************************************************************************************************/
openBrowserAndGetChromeDriverPath()
setWindowSizeAndZoom()

def openBrowserAndGetChromeDriverPath(){
	WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
	WebUI.maximizeWindow()
	println DriverFactory.getChromeDriverPath()
}

def setWindowSizeAndZoom(){
	WebDriver driver = DriverFactory.getWebDriver()
	Dimension d= new Dimension (642,482); //need import org.openqa.selenium.Dimension;
	driver.manage().window().setSize(d);
	
	WebUI.delay(2)
	WebUI.maximizeWindow()
	WebUI.executeJavaScript("document.body.style.zoom='zoom 80%'", null)
}


