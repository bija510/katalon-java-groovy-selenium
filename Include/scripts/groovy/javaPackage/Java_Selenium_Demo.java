package javaPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.kms.katalon.core.webui.driver.DriverFactory;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;

public class Java_Selenium_Demo {

	public static void main(String[] args)  throws InterruptedException{	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bijaya Chhetri\\Documents\\Katalon_Studio_Windows_64-7.2.1\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("david");
		
		DriverFactory.changeWebDriver(driver);
		WebUiBuiltInKeywords.setText(findTestObject("DemoAutomationTesting/Register/txt_LastName"), "Johnson");
		
		Thread.sleep(3000);
		WebUiBuiltInKeywords.closeBrowser();
	}
	
}
//Run as Java Application