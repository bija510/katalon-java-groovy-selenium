import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import pages.HomePage
import pages.LoginPage
import utilites.Utils



/**
 * TO REPRODUCE THIS EXCEPTION :-
 * org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
WebUI.openBrowser("https://opensource-demo.orangehrmlive.com/")

WebDriver driver = DriverFactory.getWebDriver()
driver.getTitle()

WebUI.closeBrowser()

driver.getWindowHandle()
*/


//
//println Utils.decryptText("+mmvG/CrT7k=")
//println Utils.encryptText("apple")




def loginPage = new LoginPage()
loginPage.openUrl(GlobalVariable.Url)
loginPage.enterUserName(GlobalVariable.userName)
loginPage.enterPassword(GlobalVariable.password)
loginPage.clickLoginBtn()


HomePage.using().selectAdminTab("Time")
				.clickMenuBtn()
				.clickLogoutBtn()









