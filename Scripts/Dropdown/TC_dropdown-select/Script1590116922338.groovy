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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//for selenium
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By;

String tcID = GlobalVariable.gTestCaseId
print "tcID>>>" +tcID
def currentBrowser = DriverFactory.getExecutedBrowser().getName()
println currentBrowser

try {
	WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
	WebUI.maximizeWindow() 
	
	/************************************************
	 * select DDL Using Katalon Built-in function 
	 *************************************************/
	WebUI.selectOptionByLabel(findTestObject("Object Repository/DemoAutomationTesting/Register/ddl_skills"), 'CSS', false)
	Thread.sleep(2000)
	WebUI.selectOptionByIndex(findTestObject("Object Repository/DemoAutomationTesting/Register/ddl_skills"), 6)
	Thread.sleep(2000)
	WebUI.selectOptionByValue(findTestObject("Object Repository/DemoAutomationTesting/Register/ddl_skills"), 'Android', false)
	Thread.sleep(2000)
	
	/************************************************
	 * Scroll using java script
	 *************************************************/
	 //WebUI.executeJavaScript('window.scrollBy(0,1500)', null)
	 //another way to scroll
	 WebUI.executeJavaScript("window.scrollBy(0, document.body.scrollHeight)", null)

	/************************************************
	 * Using selenium Select class
	 * import org.openqa.selenium.support.ui.Select
	 * import org.openqa.selenium.WebDriver
	 * import org.openqa.selenium.By
	 ****************************************************/
	WebDriver driver = DriverFactory.getWebDriver()
	Select ddlName = new Select(driver.findElement(By.xpath("//*[@id='countries']")))
	
	ddlName.selectByVisibleText("India")
	Thread.sleep(2000)
	
	ddlName.selectByIndex(6) //Andorra is in 6th Number
	Thread.sleep(2000)
	
	ddlName.selectByValue("Afghanistan") //<option value="Afghanistan">Afghanistan</option>

	/************************************************
	 * If else for firefox execution or other 
	 *************************************************/
	if(currentBrowser.toString().equals("FIREFOX_DRIVER")){  //for chromr = CHROME_DRIVER and for MS.edge =EDGE_CHROMIUM_DRIVER
		println('Test for firefox exxecution')
	}else{
		println('G.chrome or Ms.Edge execution')
	}



} catch (WebElementNotFoundException e) {
	WebUI.takeScreenshot((((GlobalVariable.gScreenshotDir + tcID) +'_Failed_') + CustomKeywords.'allUtilites.impUTILS.get5DigitTimeStamp'())+'.png', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('ERROR:' + e.message)
	KeywordUtil.markFailed(tcID + 'failed, Element not found')

} catch (Exception e) {
	WebUI.takeScreenshot((((GlobalVariable.gScreenshotDir + tcID) +'_Failed_') + CustomKeywords.'allUtilites.impUTILS.get5DigitTimeStamp'())+'.png', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo((('ERROR:' + e.message) + '\n Stack trace') + e.stackTrace)
	KeywordUtil.markFailed(tcID + 'failed')

}finally{

WebUI.closeBrowser()

}
