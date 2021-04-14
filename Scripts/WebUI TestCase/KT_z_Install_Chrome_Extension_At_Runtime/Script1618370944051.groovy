import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
ChromeOptions options = new ChromeOptions()

String extensionPath = RunConfiguration.getProjectDir()+ "/Include/SelectorsHub.crx"
options.addExtensions(new File(extensionPath))
options.setCapability(ChromeOptions.CAPABILITY, options)

WebDriver driver = new ChromeDriver(options)
DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl('https://www.w3schools.com/html/html_tables.asp')















