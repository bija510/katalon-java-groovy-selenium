import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import utilites.Utils



/**
 * TO REPRODUCE THIS EXCEPTION :-
 * org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
WebUI.openBrowser("https://opensource-demo.orangehrmlive.com/")

WebDriver driver = DriverFactory.getWebDriver()
driver.getTitle()

WebUI.closeBrowser()

driver.getWindowHandle()
*/



println Utils.decryptText("+mmvG/CrT7k=")
println Utils.encryptText("apple")













