import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

/***********************************************************************************************
	WebDriver driver = CustomKeywords.'allUtilites.BrowserMobileTestUtil.chromeSetUp'('iPhone X')
	DriverFactory.changeWebDriver(driver)
	WebUI.navigateToUrl('http://demo.automationtesting.in/Register.html')
	>===> After this setUp we can user WebUI keyword...... all same
************************************************************************************************/
	
WebDriver driver = CustomKeywords.'allUtilites.BrowserMobileTestUtil.chromeSetUp'('iPhone X')
	driver.navigate().to("http://demo.automationtesting.in/Register.html");
		
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ram");
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("sharma");
	
	driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys("123 drive");
	driver.findElement(By.xpath("//section[@id='section']/div/div/div[3]")).click();
	
	driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("12345678");
	driver.findElement(By.name("radiooptions")).click();
	
	new Select(driver.findElement(By.id("yearbox"))).selectByVisibleText("1929");
	driver.findElement(By.id("yearbox")).click();
	
	driver.findElement(By.xpath("(//select[@type='text'])[4]")).click();
	new Select(driver.findElement(By.xpath("(//select[@type='text'])[4]"))).selectByVisibleText("September");
	
	driver.findElement(By.xpath("(//select[@type='text'])[4]")).click();
	driver.findElement(By.id("daybox")).click();
	
	new Select(driver.findElement(By.id("daybox"))).selectByVisibleText("14");
	driver.findElement(By.id("daybox")).click();
	
	driver.findElement(By.id("firstpassword")).sendKeys("Admin123");
	driver.findElement(By.id("secondpassword")).sendKeys("Admin123");
	
	driver.findElement(By.id("submitbtn")).click();
	
	
	
	