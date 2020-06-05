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
//Selenium additional import
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException

String tcID = GlobalVariable.gTestCaseId
print "tcID>>>" +tcID
def currentBrowser = DriverFactory.getExecutedBrowser().getName()
println currentBrowser

try {
    WebUI.openBrowser('http://demo.automationtesting.in/Frames.html')
	WebUI.maximizeWindow()
	WebDriver driver =DriverFactory.getWebDriver() 
	
	driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
	Thread.sleep(2000);
   
	WebElement outerframe=driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
	driver.switchTo().frame(outerframe);
	
	WebElement innerframe=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
	driver.switchTo().frame(innerframe);

	driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Bijaya");

	
	
	//this is not working well
	/*WebUI.click(findTestObject("DemoAutomationTesting/frame/btn_iframeWithInIframe"))
	WebElement outerframe = WebUiCommonHelper.findWebElement(findTestObject('DemoAutomationTesting/frame/bx_Outerframe'),30)
	driver.switchTo().frame(outerframe);
	
	
	WebElement innerframe = WebUiCommonHelper.findWebElement(findTestObject('DemoAutomationTesting/frame/bx_InnerFrame'),30)
	driver.switchTo().frame(innerframe);

	WebUI.setText(findTestObject('DemoAutomationTesting/frame/txt_input'), 'Bijaya chet')
	*/
   

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
	