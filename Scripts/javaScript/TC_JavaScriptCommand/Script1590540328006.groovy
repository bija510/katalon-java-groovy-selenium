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
//additional import
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor;


String tcID = GlobalVariable.gTestCaseId
print "tcID>>>" +tcID
def currentBrowser = DriverFactory.getExecutedBrowser().getName()

try {
	
	WebUI.openBrowser(GlobalVariable.url)
	WebDriver driver = DriverFactory.getWebDriver()
	/*****************************************************
	 * for more in eclipse test case == D31JscriptAllCode
	 * javascript click
	 *****************************************************/
	//one way
	//WebUI.executeJavaScript("document.getElementById('u_0_a').click()", null)
	
	//another way
	WebElement element2 =driver.findElement(By.id('u_0_a'))
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].click();", element2);
	
	System.exit(0)
	/**********************************************************************
	 * javascript SetText need to Import
	 * import com.kms.katalon.core.webui.common.WebUiCommonHelper
     * import org.openqa.selenium.WebElement
	 **********************************************************************/
	WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Page_Facebook/txt_firstName'),30) 
    WebUI.executeJavaScript("arguments[0].value='Bijaya'", Arrays.asList(element))
    
	WebUI.closeBrowser()
	
	/***************************
	 * javascript scrollBy
	 ***************************/
	WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
	WebUI.maximizeWindow()
	WebUI.delay(2)
	//1.Scroll to height and by number
	WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)", null) //scrollTo =scrollBy
	//2.other way
	WebUI.executeJavaScript("window.scrollBy(0, document.body.scrollHeight)", null)
	//3. other way
    WebUI.executeJavaScript('window.scrollBy(0,1500)', null)
	
	//4.Scroll to certain element
	WebElement Element = WebUiCommonHelper.findWebElement(findTestObject('DemoAutomationTesting/Register/btn_Submit'),30) 
	JavascriptExecutor js1 = ((JavascriptExecutor) driver);
    js1.executeScript("arguments[0].scrollIntoView(true);", Element);
	
	/*******************************
	 * javascript setZoom in or out
	 * not working
	 *******************************/
//	WebUI.openBrowser('https://www.walmart.com/')
//	WebUI.maximizeWindow()
//	WebUI.executeJavaScript("document.body.style.zoom='80%'", null)
	
	//go to the chrome settings
//	driver.get("chrome://settings/")
//	//set the zoom to 70%
//	((JavascriptExecutor)driver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.7);");
	

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





