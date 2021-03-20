import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import allUtilites.*
import groovy.json.*
import com.kms.katalon.core.webui.driver.DriverFactory
import utilites.JavaScript


WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
WebUI.maximizeWindow()

println JavaScript.getTextJS(findTestObject('RegisterPage/lbl_Register'), 6)


