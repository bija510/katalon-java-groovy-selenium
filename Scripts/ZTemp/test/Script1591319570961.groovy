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
// 01. Run the bat file
/*****************************************************************************************
 This work for running the bat file
 https://stackoverflow.com/questions/10685893/run-exe-file-in-java-from-file-location
 
String batFilePath = RunConfiguration.getProjectDir()+"/Start WinAppDriver.bat"
println batFilePath
runtimeProcess = Runtime.getRuntime().exec("cmd /c start /min cmd.exe /C\""+ batFilePath +"\"");

// runtimeProcess = Runtime.getRuntime().exec("cmd /c start cmd.exe /C\""+"C:\\Users\\bchhetri\\Git\\DemTech_Automation\\Start WinAppDriver.bat"+"\"");
 int processComplete = runtimeProcess.waitFor();
 
*****************************************************************************************/

// 02. find the cmd.exe or window command line is open or not
/*****************************************************************************************
 * For the window locator 
 * https://developer.microsoft.com/en-us/windows/downloads/windows-10-sdk/

import java.io.BufferedReader as BufferedReader
import java.io.IOException as IOException
import java.io.InputStreamReader as InputStreamReader


boolean anyCmdProgramOpened = isAnyCmdProgramOpened()
System.out.println('isOpened = ' + anyCmdProgramOpened)
WebUI.callTestCase(findTestCase('aSetup/Setup_01_StartWinAppDriver'), [:], FailureHandling.STOP_ON_FAILURE)
static boolean isAnyCmdProgramOpened() {
    Process p
    
    try {
        p = Runtime.getRuntime().exec((System.getenv('windir') + '\\system32\\') + 'tasklist.exe')
        String line
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))
        while ((line = input.readLine()) != null) {
            System.out.println(line)
            if (line.startsWith('cmd.exe')) {
                return true            
                break
            }
        }
    }
    catch (IOException e) {
        e.printStackTrace()
    }     
    return false
}
***************************************************************************************************/


// 03. Lunching the center point application and click on the hamburger menu and click the ballots 1st plus btn
/**************************************************************************************************
 * Click hamburger menu and ballots 1st plus btn
 
	WebUI.callTestCase(findTestCase('CenterPoint_Inhouse/TC_01_Login_CenterPoint'), [:], FailureHandling.STOP_ON_FAILURE)	
	Windows.clickElementOffset(findWindowsObject('CenterPoint/MainPage/100Perc_text_leftTo_burger_menu'), 142, 0) // click Hamburger menu
	Windows.clickElementOffset(findWindowsObject('CenterPoint/ElectionInformationPage/btn_CopyIdentifiers'), 759, -68) // first ballots 1st plus btn
 **************************************************************************************************/

// 04. Take screenshot on failure
/***********************************************************************************
 	
	Windows.startApplicationWithTitle(GlobalVariable.centerPoint_url, 'CenterPoint')
	String actHeader = Windows.getText(findWindowsObject('CenterPoint/Login/lbl_welcomeToDemTech'))
	Windows.verifyMatch(actHeader, 'Welcome to DemTech CenterPoint', false)


	String screenshotLocation = RunConfiguration.getProjectDir()+ "/test.png"
	WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(screenshotLocation)
	
	//Windows.clickElementOffset(findWindowsObject('CenterPoint/MainPage/100Perc_text_leftTo_burger_menu'), 142, 0) // first plus btn

 ***********************************************************************************/
 

// 05. Upload file
/****************************************************************
	Windows.click(findWindowsObject('EpollTab/MainDashboard/btn_loadFromFile'))
	
	Windows.delay(3)
	String fileUploadPath =  RunConfiguration.getProjectDir() + '/Data/FilesForUpload/Default Clone Clone_2022_07.pollbook'
	fileUploadPath = fileUploadPath.replace('/', '\\')
	
	StringSelection ss = new StringSelection(fileUploadPath);
	//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContents(ss, null);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_DELETE);
	robot.keyRelease(KeyEvent.VK_DELETE);
	Windows.delay(3)
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	Windows.delay(3)
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Windows.delay(3)

*********************************************************************/






