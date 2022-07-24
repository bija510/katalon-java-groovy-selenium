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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/**********************************************************************
 * NOTE:- Need to start the driver first
 1. Open katalon studio-->Tools--> Window--> Install WinAppDrivers follow the screen & finished.
 2. Type developer settings on window Search & turn on the Developer mode.
 3. Go to C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe & CMD there and Write WinAppDriver.exe & hit ENTER to Run The Driver.
 4. C:\Windows\System32\notepad.exe
 ***********************************************************************/

Windows.startApplicationWithTitle('C:\\Windows\\System32\\notepad.exe', 'Untitled - Notepad')

Windows.click(findWindowsObject('WindowDesktopApps/Notepad/btn_maxmize'))

Windows.setText(findWindowsObject('WindowDesktopApps/Notepad/Edit(1)'), 'Testing the notepad writing feature')
Windows.delay(2)

Windows.clearText(findWindowsObject('WindowDesktopApps/Notepad/Edit(1)'))
Windows.delay(2)

Windows.setText(findWindowsObject('WindowDesktopApps/Notepad/Edit(1)'), 'Hello i m testing notepad using the katalon studio winappDriver')
Windows.delay(2)

Windows.doubleClick(findWindowsObject('WindowDesktopApps/Notepad/Edit(1)')) // Work it highlight on the winappDriver text

KeywordUtil.logInfo("==> " + Windows.getText(findWindowsObject('WindowDesktopApps/Notepad/Edit(1)')) )

Windows.rightClick(findWindowsObject('WindowDesktopApps/Notepad/Edit(1)'))

KeywordUtil.logInfo("==> " + Windows.getElementPosition(findWindowsObject('WindowDesktopApps/Notepad/Edit(1)')) )


//Windows.closeApplication()






