import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


    def currentBrowser = DriverFactory.getExecutedBrowser().getName()

	if(currentBrowser.toString().equals("FIREFOX_DRIVER")){  //for chromr = CHROME_DRIVER ** for MS.edge =EDGE_CHROMIUM_DRIVER **for edge= EDGE_DRIVER

		FirefoxProfile profile = new FirefoxProfile()
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf")//mime type
		profile.setPreference("browser.download.manager.showWhenStarting", false)
		profile.setPreference("pdfjs.disabled", true)
	
		FirefoxOptions option =new FirefoxOptions()
		option.setProfile(profile)
	
		System.setProperty("webdriver.gecko.driver", DriverFactory.getGeckoDriverPath())
		WebDriver driver = new FirefoxDriver(option)
		DriverFactory.changeWebDriver(driver)
	
	}else{
		WebUI.openBrowser("")
	}
	WebUI.maximizeWindow()
	WebUI.navigateToUrl("http://demo.automationtesting.in/FileDownload.html")
	WebUI.setText(findTestObject('DemoAutomationTesting/FileDownload/obj1'), "TestData For .txt")
	WebUI.click(findTestObject('DemoAutomationTesting/FileDownload/obj2'))
	WebUI.delay(2)
	WebUI.click(findTestObject('DemoAutomationTesting/FileDownload/obj3'))

	
	
	