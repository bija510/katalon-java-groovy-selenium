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
//Additional import
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By;


String tcID = GlobalVariable.gTestCaseId
def currentBrowser = DriverFactory.getExecutedBrowser().getName()


	WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
	WebDriver driver =DriverFactory.getWebDriver()
	WebElement ChkBox = WebUI.findWebElement(findTestObject("DemoAutomationTesting/Register/chk_Movie"))
	
	/*************************************************
	 * if the CheckBox is not selected it will Select
	 *************************************************/
	if(!ChkBox.isSelected()){
		ChkBox.click()
		WebUI.delay(2)
		}
	
	/********************************************************
	 * if the CheckBox is already selected it will Uncheck 
	 *******************************************************/
	if(ChkBox.isSelected()){
		ChkBox.click()
		WebUI.delay(2)
		}
	
	
	/*********************************************************************
	 * if the Radio button is not selected
	 * even if you click double on the Radio button it will still selected
	 *********************************************************************/
	WebElement RadButton = driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[1]/input"))
	if(!RadButton.isSelected()){
		RadButton.click()
		WebUI.delay(2)
	}
	
