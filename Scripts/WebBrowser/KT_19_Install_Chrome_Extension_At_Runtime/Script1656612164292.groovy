import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


/**************************************************************************************************************************
 <<<<---Steps to create Custom Capabilites Chrome Runner from Setting--->>>>
1. project --> setting -->custom-->add-->name-->Custom-chrome
2. value-->Driver Name--->Chrome
3. Name-->args
4. Type-->List
5. Value-->Type-->
6. String-->start-maximized
7. String-->load-extension=C:\Users\Bijaya Chhetri\git\katalon-java-groovy-selenium\Include\SelectorHub\3.0.7_0
8. String-->disable-extensions-except=C:\Users\Bijaya Chhetri\git\katalon-java-groovy-selenium\Include\SelectorHub\3.0.7_0
 ***************************************************************************************************************************/


System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
ChromeOptions options = new ChromeOptions()

String extensionPath = RunConfiguration.getProjectDir()+ "/Include/SelectorsHub.crx"
options.addExtensions(new File(extensionPath))
options.setCapability(ChromeOptions.CAPABILITY, options)

WebDriver driver = new ChromeDriver(options)
DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl('https://www.w3schools.com/html/html_tables.asp')















