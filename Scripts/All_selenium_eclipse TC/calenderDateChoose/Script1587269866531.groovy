import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver as WebDriver
import org.testng.Assert;

     sc ='apple'

	WebUI.openBrowser('https://www.path2usa.com/travel-companions')
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	driver.findElement(By.xpath(".//*[@id='travel_date']")).click()
	
	while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
	.contains("May")) {
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
	}
	
	List<WebElement> dates = driver.findElements(By.className("day"));
	// Grab common attribute//Put into list and iterate
	int count = driver.findElements(By.className("day")).size();
	
	for (int i = 0; i < count; i++) {
		String text = driver.findElements(By.className("day")).get(i).getText();
		if (text.equalsIgnoreCase("21")) {
			driver.findElements(By.className("day")).get(i).click();
			break;
			
	}
		
	}


