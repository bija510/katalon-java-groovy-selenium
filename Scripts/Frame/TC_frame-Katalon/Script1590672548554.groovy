import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/****************************************************************************************
 * If we record the Object then frame will be taken care bydefault in Object Repository
 ****************************************************************************************/

    WebUI.openBrowser('http://demo.automationtesting.in/Frames.html')
	WebUI.maximizeWindow()
	WebDriver driver =DriverFactory.getWebDriver() 
	
	driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
	Thread.sleep(2000);
   
	WebElement outerframe=driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
	driver.switchTo().frame(outerframe);
	
	WebElement innerframe=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
	driver.switchTo().frame(innerframe);

	driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Bijaya");

	
