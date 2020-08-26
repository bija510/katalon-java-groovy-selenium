import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.*
import com.paulhammant.ngwebdriver.*


	WebUI.openBrowser('https://angular.io/')
	WebUI.maximizeWindow()
	WebDriver driver = DriverFactory.getWebDriver()
	NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor)driver)
	ngDriver.waitForAngularRequestsToFinish()
	driver.findElement(ByAngular.cssContainingText(".button.hero-cta", "Get Started")).click()
	
	


