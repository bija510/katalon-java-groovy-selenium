import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import org.openqa.selenium.*;
//import com.paulhammant.ngwebdriver.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;


/**********************************************************
ByAngular.repeater(""), || exactRepeater("") 
ByAngular.binding(""),  || exactBinding("")
ByAngular.model(''),    || options("")
ByAngular.buttonText("")|| partialButtonText("")
					    || ByAngular.cssContainingText("")
***********************************************************/	
    WebUI.openBrowser('http://juliemr.github.io/protractor-demo/')
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) driver);
	
	ngDriver.waitForAngularRequestsToFinish();
	driver.findElement(ByAngular.model("first")).sendKeys("2");
	driver.findElement(ByAngular.model("second")).sendKeys("2");
	driver.findElement(ByAngular.buttonText("Go!")).click();
