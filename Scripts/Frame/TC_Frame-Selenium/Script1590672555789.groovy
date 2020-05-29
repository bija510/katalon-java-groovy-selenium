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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException

String tcID = GlobalVariable.gTestCaseId
print "tcID>>>" +tcID
def currentBrowser = DriverFactory.getExecutedBrowser().getName()
println currentBrowser

try {

    WebUI.openBrowser('https://seleniumhq.github.io/selenium/docs/api/java/index.html')
	
    WebDriver driver =DriverFactory.getWebDriver()
	driver.switchTo().frame("packageListFrame");
	driver.findElement(By.linkText("org.openqa.selenium")).click();
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame("packageFrame");
	Thread.sleep(3000);
	driver.findElement(By.linkText("WebDriver")).click();
	
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame("classFrame");
	driver.findElement(By.xpath("/html/body/div[1]/ul/li[5]")).click();
	
	

} catch (WebElementNotFoundException e) {
	WebUI.takeScreenshot((GlobalVariable.gScreenshotDir)+ tcID + '.png', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('ERROR:' + e.message)
	KeywordUtil.markFailed(tcID + 'failed, Element not found')

} catch (Exception e) {
	WebUI.takeScreenshot((GlobalVariable.gScreenshotDir)+ tcID + '.png', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo((('ERROR:' + e.message) + '\n Stack trace') + e.stackTrace)
	KeywordUtil.markFailed(tcID + 'failed')

}finally{

WebUI.closeBrowser()
	
}
	
	