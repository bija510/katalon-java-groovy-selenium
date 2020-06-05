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

//Additional for selenium
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile

String tcID = GlobalVariable.gTestCaseId
print "tcID>>>" +tcID
def currentBrowser = DriverFactory.getExecutedBrowser().getName()
println currentBrowser


try {
	
	/***************************************************************
	 * Need To run in --------FIREFOX------- to get Download pop up
	 * by using it we will not see the pop up in firefox
	 * In chrome no pop up Occur
	 **************************************************************/
	
	if(currentBrowser.toString().equals("FIREFOX_DRIVER")){  //for chromr = CHROME_DRIVER ** for MS.edge =EDGE_CHROMIUM_DRIVER **for edge= EDGE_DRIVER
				
				  FirefoxProfile profile = new FirefoxProfile()
				  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf")//mime type
				  profile.setPreference("browser.download.manager.showWhenStarting", false)
				  profile.setPreference("pdfjs.disabled", true)
				  
				  FirefoxOptions option =new FirefoxOptions()
				  option.setProfile(profile)
				  
				  System.setProperty("WebDriver.gecko.driver", "C:\\Users\\Bijaya Chhetri\\Documents\\Katalon_Studio_Windows_64-7.2.1\\configuration\\resources\\drivers\\firefox_win64\\geckodriver.exe")
				  WebDriver driver = new FirefoxDriver(option)
				  driver.get("http://demo.automationtesting.in/FileDownload.html")
				 
				  driver.manage().window().maximize()
				  driver.findElement(By.xpath("//*[@id='textbox']")).sendKeys('TestData For .txt')
				  driver.findElement(By.xpath("//*[@id='createTxt']")).click()
				  Thread.sleep(2000)
				  driver.findElement(By.xpath("//a[@id='link-to-download']")).click()
				  
			}else{
				  println('Other Browser is used than Firefox')
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

//WebUI.closeBrowser()

}
