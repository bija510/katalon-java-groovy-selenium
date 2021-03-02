import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import allUtilites.*
import groovy.json.*
import com.kms.katalon.core.webui.driver.DriverFactory


WebUI.openBrowser("http://demo.automationtesting.in/Register.html")

//ChromeOptions option =new ChromeOptions()
//option.setExperimentalOption("debuggerAddress", "localhost:62631")
//WebDriver driver = new ChromeDriver(option)
//DriverFactory.changeWebDriver(driver)

WebUI.setText(findTestObject('Object Repository/DemoAutomationTesting/Register/txt_FirstName'), "aab")
//WebUI.setText(findTestObject('Object Repository/DemoAutomationTesting/Register/txt_LastName'), "Johnson")

