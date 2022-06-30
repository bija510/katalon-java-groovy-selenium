import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

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

/******************************************************************************************************
  Sometime if the tabName is inside <a .....<span HtmlTable />span ../a>  
  then we have to use like this ===> if(eleList.getAttribute("innerHTML").contains(ddlLabel))
  NOTE:- Work Tested
 *******************************************************************************************************/


WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
WebUI.maximizeWindow()
selectDropDownOptionByLabel("//*[@id='header']/nav/div/div[2]/ul/li/a", "WebTable").click()


public WebElement selectDropDownOptionByLabel(String elesXpath, String ddlLabel){
	WebDriver driver =DriverFactory.getWebDriver()
	List<WebElement> eleLists = driver.findElements(By.xpath(elesXpath))
	for(WebElement eleList: eleLists){
		if(eleList.getText().equalsIgnoreCase(ddlLabel)){
			return new WebDriverWait(driver, GlobalVariable.largeWaitTime).until(ExpectedConditions.elementToBeClickable(eleList))
			break
		}
	}
}

