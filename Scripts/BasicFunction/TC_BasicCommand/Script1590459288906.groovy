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

String tcID = GlobalVariable.gTestCaseId
print "tcID>>>" +tcID
def currentBrowser = DriverFactory.getExecutedBrowser().getName()
println currentBrowser
String actValue = ''
String expValue = ''

try {
	
	/************************************************************************************************
	 * All Basic Command
	 * Mouse hover to the functin like openbrowser it will show what it Does?
	 * System.exit(0)
	 * for password increption help==>Encrypt Text==>input 
	 * if any Form We can used 
	 * WebUI.submit(findTestObject(''))==>if htere is Submit button then it will click
	 * "Ctrl + I" , "Ctrl+a" , "Ctrl+Shift+f" ,"Select all +tab/i" , "Shift+click+anoClick" Ctrl+click..
	 *************************************************************************************************/
	//WebUI.openBrowser('')
	//WebUI.navigateToUrl('http://demo.automationtesting.in/Register.html') //or line 45 instead of this 2 line
	
	WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
	WebUI.maximizeWindow()
	
	/**********************************************************************************
	 * actValue is like Local variable can be used multiple time in test case
	 **********************************************************************************/
	actValue =  'Register'
	expValue = WebUI.getWindowTitle()
	
	println expValue // or System.out.println("") or println("")
	WebUI.verifyMatch(actValue, expValue, false)
	
	
	actValue = 'http://demo.automationtesting.in/Register.html'
	expValue = WebUI.getUrl() // Get url of the current window
	WebUI.verifyMatch(actValue, expValue, false)
	
	/*********************************
	 * window size maximize and set 
	 * zoom
	 *********************************/
	WebDriver driver = DriverFactory.getWebDriver()
	Dimension d= new Dimension (642,482); //need import org.openqa.selenium.Dimension;
	driver.manage().window().setSize(d);
	
	WebUI.delay(2)
	WebUI.maximizeWindow()
	WebUI.executeJavaScript("document.body.style.zoom='zoom 80%'", null)
	WebUI.delay(2)
	WebUI.deleteAllCookies()
	
	/*********************************
	 * all referesh function
	 *********************************/
	WebUI.refresh()
	driver.navigate().refresh()
	driver.getCurrentUrl()
	
	
	WebUI.click(findTestObject('DemoAutomationTesting/tab_WebTable'),FailureHandling.STOP_ON_FAILURE) //will stop
	//WebUI.click(findTestObject('DemoAutomationTesting/tab_WebTable'),FailureHandling.CONTINUE_ON_FAILURE) //continue and show fail
	//WebUI.click(findTestObject('DemoAutomationTesting/tab_WebTable'),FailureHandling.OPTIONAL) //fail on continue and make TC pass
	
	WebUI.back()
	WebUI.delay(2)
	WebUI.forward()
	WebUI.back()
	
	WebUI.getText(findTestObject('DemoAutomationTesting/lbl_Register')) //Register
	
	WebUI.sendKeys(findTestObject('DemoAutomationTesting/txt_FirstName'), 'DemoName1') //this only send text
	WebUI.delay(2)
	WebUI.setText(findTestObject('DemoAutomationTesting/txt_FirstName'), 'DemoName2') //this clear first and set text
	WebUI.delay(2)
	
	actValue = 'DemoName2'
	expValue = WebUI.getAttribute(findTestObject('DemoAutomationTesting/txt_FirstName'), 'value') //Result = DemoName2
	WebUI.verifyMatch(actValue, expValue, false, FailureHandling.STOP_ON_FAILURE)

	KeywordUtil.markPassed('*************All Step Executed Succesfully****************')
	//KeywordUtil.markFailed('*************All Step Executed Succesfully****************') //it will fail the test case
	
	

} catch (WebElementNotFoundException e) {
	WebUI.takeScreenshot((GlobalVariable.gScreenshotDir)+ tcID + '.png', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('ERROR:' + e.message)
	KeywordUtil.markFailed(tcID + 'failed, Element not found')

} catch (Exception e) {
	WebUI.takeScreenshot((GlobalVariable.gScreenshotDir)+ tcID + '.png', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo((('ERROR:' + e.message) + '\n Stack trace') + e.stackTrace)
	KeywordUtil.markFailed(tcID + 'failed')

}finally{

//WebUI.closeBrowser()

}

	






