import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

/********************************************************
 * NOTE:- Never mix the implicit wait and explicit wait
 * BETTER approach:- just use Explicit wait only
 *******************************************************/

seleniumWait()
//katalonWait()

def seleniumWait(){
	WebUI.openBrowser('http://demo.automationtesting.in/Loader.html')
	WebDriver driver = DriverFactory.getWebDriver()
	//soft wait Implicity wait
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //import java.util.concurrent.TimeUnit;
	
	Thread.sleep(4000)
	driver.findElement(By.xpath("//button[normalize-space()='Run']")).click()
	//Explicit Wait
	WebDriverWait mywait = new WebDriverWait(driver, 30);
	WebElement btn_alertClost = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Close']")));
	//WebElement btn_alertClost = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Close']")));
	btn_alertClost.click()
}

def katalonWait(){
	WebUI.openBrowser('http://demo.automationtesting.in/Loader.html')
	WebUI.waitForPageLoad(2)
	WebUI.delay(2)
	WebUI.click(findTestObject("DemoAutomationTesting/loader/btn_run"))
	WebUI.waitForElementClickable(findTestObject("DemoAutomationTesting/loader/btn_alertClose"), 15) // work good or
	//WebUI.waitForElementVisible(findTestObject("DemoAutomationTesting/loader/btn_alertClose"), 15) // work good
	WebUI.click(findTestObject("DemoAutomationTesting/loader/btn_alertClose"))	
}