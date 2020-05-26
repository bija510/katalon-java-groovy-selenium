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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//for selenium
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By as By

String tcID = GlobalVariable.gTestCaseId
print "tcID>>>" +tcID
def currentBrowser = DriverFactory.getExecutedBrowser().getName()//for Current Browser name


try {
	
	/***********************************************
	 * 1. mouse Event:- Drag and Drop
	***********************************************/
	WebUI.dragAndDropToObject(findTestObject('MouseEvent/dragNDrop1'), findTestObject('MouseEvent/DragNdrop2'))
	
	/***********************************************
	 * 2. mouse Event:- rightClick
	 * Isn't working but this is the way
	***********************************************/
	WebUI.openBrowser('http://demo.guru99.com/test/simple_context_menu.html')
	WebUI.maximizeWindow()
	WebUI.delay(2)
	WebUI.rightClick('MouseEvent/Rightclick')
	
	/***********************************************
	 * 3. mouse Event:- mouseOver
	***********************************************/
	WebUI.openBrowser('https://www.amazon.com/')
	WebUI.maximizeWindow()
	WebUI.mouseOver(findTestObject('MouseEvent/MouseHover'))
	System.exit(0)
	
	
	/***********************************************
	 * 4. mouse Event:-Double Click
	***********************************************/
	WebUI.openBrowser('https://testautomationpractice.blogspot.com')
	WebUI.maximizeWindow()
	WebUI.doubleClick(findTestObject('MouseEvent/doubleclick'))
	
	
	/****************************************************************************************************
	 * 5. mouse Event:-Click and hold
	 * katalon doesnot have Click and hold function so need to use selenium function with ACTION CLASS
	 * import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
     * import org.openqa.selenium.interactions.Actions as Actions
	 ***************************************************************************************************/
	
	WebUI.openBrowser('https://selenium08.blogspot.com/2020/01/click-and-hold.html')
	WebUI.maximizeWindow()
	WebUI.executeJavaScript('window.scrollBy(0,500)', null)
	WebDriver driver = DriverFactory.getWebDriver()
	Actions builder = new Actions(driver)
	WebElement sourceElement = WebUiCommonHelper.findWebElement(findTestObject('MouseEvent/clickNHold'), 20)
	builder.clickAndHold(sourceElement).build().perform()
	WebUI.delay(2)
	builder.moveToElement(sourceElement).release().build().perform()
	

	
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

	






