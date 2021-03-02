import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def currentBrowser = DriverFactory.getExecutedBrowser().getName()

WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
WebUI.maximizeWindow()
katalon_staticDropdown()
//selenium_staticDropdown()
	


def katalon_staticDropdown(){
	WebUI.selectOptionByLabel(findTestObject("DemoAutomationTesting/Register/ddl_skills"), 'CSS', false)
	Thread.sleep(2000)
	WebUI.selectOptionByIndex(findTestObject("DemoAutomationTesting/Register/ddl_skills"), 6)
	Thread.sleep(2000)
	WebUI.selectOptionByValue(findTestObject("DemoAutomationTesting/Register/ddl_skills"), 'Android', false)
	Thread.sleep(2000)
}

def selenium_staticDropdown(){
	WebUI.executeJavaScript("window.scrollBy(0, document.body.scrollHeight)", null)
	WebDriver driver = DriverFactory.getWebDriver()
	Select ddlName = new Select(driver.findElement(By.xpath("//*[@id='countries']")))
	
	ddlName.selectByVisibleText("India")
	Thread.sleep(1000)
	
	ddlName.selectByIndex(6) //Andorra is in 6th Number
	Thread.sleep(1000)
	
	ddlName.selectByValue("Afghanistan") //<option value="Afghanistan">Afghanistan</option>
}

	
