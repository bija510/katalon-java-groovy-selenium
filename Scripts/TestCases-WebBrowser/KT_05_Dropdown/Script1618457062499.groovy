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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.*


static_dropdown()
def static_dropdown(){
	WebUI.selectOptionByLabel(findTestObject("RegisterPage/ddl_skills"), 'CSS', false)
	Thread.sleep(2000)
	WebUI.selectOptionByIndex(findTestObject("RegisterPage/ddl_skills"), GlobalVariable.largeWaitTime)
	Thread.sleep(2000)
	WebUI.selectOptionByValue(findTestObject("RegisterPage/ddl_skills"), 'Android', false)
	Thread.sleep(2000)
}

def dynamic_dropdown(){
	
'========Refer to the selenium_maven_java_github project========='
	
}

//verify_dropdown_list()
def verify_dropdown_list(){
	WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
	WebUI.maximizeWindow()
	WebUI.executeJavaScript("window.scrollBy(0, document.body.scrollHeight)", null)
	
	/************************************************
	 * Verify dropdown list label
	 *************************************************/
	WebDriver driver = DriverFactory.getWebDriver()
	String[] allMonth = ['Month', 'January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
	Select select =new Select(driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select")))
	List<WebElement> expddlvalues= select.getOptions()
	
	int totalOptions = expddlvalues.size() // 1nd Example
	for(int i=0; i < expddlvalues.size(); i++){
		WebUI.verifyMatch(allMonth[i], expddlvalues.get(i).getText(), false) //import org.openqa.selenium.WebElement
	}
	
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

}