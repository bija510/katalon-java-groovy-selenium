package javaPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java_Selenium_Demo {

	public static void main(String[] args)  throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bijaya Chhetri\\Documents\\Katalon_Studio_Windows_64-7.2.1\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("david");
		Thread.sleep(3000);
		driver.quit();
	}
	
}
//Run as Java Application