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
import org.openqa.selenium.remote.DesiredCapabilities

WebUI.openBrowser('')

//1. Browser Name
def currentBrowser = DriverFactory.getExecutedBrowser().getName()
println "Current Running Browser Name = " + currentBrowser

//2. Browser Driver path
println "Chrome Driver path = " + DriverFactory.getChromeDriverPath()

//3. Changing WebUI to driver
WebDriver driver = DriverFactory.getWebDriver()
driver.get("http://demo.automationtesting.in/Register.html")

//4. Changing driver back to WebUI
DriverFactory.changeWebDriver(driver)
WebUI.setText(findTestObject('RegisterPage/txt_FirstName'), 'Michal')

//5. Pause Execution
System.exit(0)