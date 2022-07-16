import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
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



//
//def loginPage = new LoginPage()
//loginPage.openUrl(GlobalVariable.Url)
//loginPage.enterUserName(GlobalVariable.userName)
//loginPage.enterPassword(GlobalVariable.password)
//loginPage.clickLoginBtn()
//
//
//HomePage.using().selectAdminTab("Time")
//				.clickMenuBtn()
//				.clickLogoutBtn()

50.times{
KeywordUtil.logInfo(getAlphaNumericString(2))

}

def static getAlphaNumericString(int length){
	String alphaNumericStr= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
	StringBuilder sb = new StringBuilder(length-1)
	for (int i =0; i< length-1; i++){
		int index = (int) (alphaNumericStr.length()*Math.random())
		sb.append(alphaNumericStr.charAt(index))
	}
	String NumericStr= "0123456789"
	StringBuilder sb2 = new StringBuilder(1)
	int index2 = (int) (NumericStr.length()*Math.random())
	sb2.append(NumericStr.charAt(index2))
	
	String finalStr = sb.toString()+sb2.toString()

	return finalStr
}



