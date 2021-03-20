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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By as By

def currentBrowser = DriverFactory.getExecutedBrowser().getName()

	WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
	WebUI.maximizeWindow() 
	
	/************************************************
	 * Scroll using java script
	 *************************************************/
	 //WebUI.executeJavaScript('window.scrollBy(0,1500)', null)
	 //another way to scroll
	 WebUI.executeJavaScript("window.scrollBy(0, document.body.scrollHeight)", null)

	/************************************************
	 * Verify dropdown list label
	 * CustomKeywords.'helpers.DropDownHelper.verifyDDLItems'('DemoAutomationTesting/ddl_list', allMonth)
	 *************************************************/
	WebDriver driver = DriverFactory.getWebDriver()
	String[] allMonth = ['Month', 'January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
    Select select =new Select(driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select")))
    List<WebElement> expddlvalues= select.getOptions()
	
	int totalOptions = expddlvalues.size() // 1nd Example
	for(int i=0; i < expddlvalues.size(); i++){
		WebUI.verifyMatch(allMonth[i], expddlvalues.get(i).getText(), false) //import org.openqa.selenium.WebElement
	}
	
	//or We can use this Library
	//CustomKeywords.'helpers.DropDownHelper.verifyDDLItems'('DemoAutomationTesting/ddl_list', allMonth)
	
	
	/************************************************
	*Verifying default label
	*************************************************/
	WebUI.verifyOptionSelectedByLabel(findTestObject("RegisterPage/ddl_skills"), 'Select Skills', false, 2, FailureHandling.STOP_ON_FAILURE)
	
	
	/************************************************
	*getting total num of Optoin
	*Verifying total ddl count
	*************************************************/
	String totalOptions1 = WebUI.getNumberOfTotalOption(findTestObject("RegisterPage/ddl_skills")) // 2nd Example Result:- 78
	println totalOptions
	WebUI.verifyEqual(totalOptions1, 78)
	
	WebUI.verifyEqual(totalOptions, 13)
	
