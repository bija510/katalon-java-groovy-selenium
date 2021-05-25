package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions
import com.kms.katalon.core.testobject.*
import internal.GlobalVariable

public class HomePage {

	public static HomePage using() {
		return new HomePage()
	}

	public HomePage clickMenuBtn(){
		WebUI.click(findTestObject('Object Repository/OrangeHRM/homePage/btn_welcomeMenu'))
		return this
	}

	public HomePage clickLogoutBtn(){
		WebUI.click(findTestObject('Object Repository/OrangeHRM/homePage/btn_logout'))
		return this
	}

	public HomePage selectAdminTab(String tabName){
		String commonXpath = findTestObject("OrangeHRM/homePage/tab_Cl_homePage").getSelectorCollection().get(SelectorMethod.XPATH)
		selectAnyOptionByLabel(commonXpath, tabName).click()
		return this
	}

	public WebElement selectAnyOptionByLabel(String commonXpath, String ddlLabel){
		WebDriver driver =DriverFactory.getWebDriver()
		List<WebElement> eleLists = driver.findElements(By.xpath(commonXpath))
		for(WebElement eleList: eleLists){
			if(eleList.getText().equalsIgnoreCase(ddlLabel)){
				return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(eleList))
				break
			}
		}
	}
}
