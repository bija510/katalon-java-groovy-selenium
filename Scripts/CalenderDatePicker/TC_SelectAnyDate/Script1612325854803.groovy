import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By.ByLinkText
import org.openqa.selenium.By.ByTagName
import org.openqa.selenium.By.ByXPath
import org.openqa.selenium.WebElement
import org.openqa.selenium.*
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser("http://demo.automationtesting.in/Datepicker.html")
WebUI.findWebElement(findTestObject('DemoAutomationTesting/dataPicker/datePicker')).click()
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> days = driver.findElements(By.xpath("//div[@class='datepick-month']//table//tr//td"))

for(WebElement day: days){
	if(day.getText()=='15'){
		day.click()
	}
}

/**********Both Works Wells*************
for(int i=0; i<days.size(); i++){
	if(days.get(i).getText()=='15'){
		days.get(i).click()
	}
}
***************************************/
