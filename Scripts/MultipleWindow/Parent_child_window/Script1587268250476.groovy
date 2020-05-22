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
import java.util.Iterator as Iterator
import java.util.Set as Set
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


		WebUI.openBrowser('http://demo.automationtesting.in/Windows.html')
		
		WebDriver driver = DriverFactory.getWebDriver()
		
		driver.findElement(By.xpath('//*[@id="Tabbed"]/a/button')).click()
		
		/*driver.get("https://accounts.google.com/signup"); //this is 2nd exapmle
				driver.findElement(By.xpath("//a[contains(text(),'Privacy')]")).click();*/
		println(driver.getTitle())
		
		Set<String> ids = driver.getWindowHandles()
		
		Iterator<String> it = ids.iterator()
		
		String parentid = it.next()
		
		String childid = it.next()
		
		driver.switchTo().window(childid) // travel to child and work there
		
		println(driver.getTitle())
		
		driver.findElement(By.xpath('//*[@id="container"]/header/div/div/div[2]/ul/li[4]/a')).click()
		
		driver.switchTo().window(parentid) // travel back to parent
		
		println(driver.getTitle())
		


