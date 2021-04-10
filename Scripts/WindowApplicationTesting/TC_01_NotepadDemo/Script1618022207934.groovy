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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/**********************************************************************
 * NOTE:- Need to start the driver first
 1. Developer mode should be enabled & start the driver
 2. C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe
 3. C:\Windows\System32\notepad.exe
 ***********************************************************************/

Windows.startApplicationWithTitle('C:\\Windows\\System32\\notepad.exe', '')
Windows.click(findWindowsObject('DesktopTestingNotepadApp/btn_maxmize'))

Windows.setText(findWindowsObject('DesktopTestingNotepadApp/Edit(1)'), 'Testing the notepad writing feature using microsoft winapp which is used by katalon studio.')

Windows.click(findWindowsObject('DesktopTestingNotepadApp/tab_file'))
Windows.delay(2)
Windows.click(findWindowsObject('DesktopTestingNotepadApp/Edit(1)'))

Windows.click(findWindowsObject('DesktopTestingNotepadApp/tab_edit'))
Windows.delay(2)
Windows.click(findWindowsObject('DesktopTestingNotepadApp/Edit(1)'))

Windows.click(findWindowsObject('DesktopTestingNotepadApp/tab_format'))
Windows.delay(2)
Windows.click(findWindowsObject('DesktopTestingNotepadApp/Edit(1)'))

Windows.click(findWindowsObject('DesktopTestingNotepadApp/tab_view'))
Windows.delay(2)
Windows.click(findWindowsObject('DesktopTestingNotepadApp/Edit(1)'))

Windows.click(findWindowsObject('DesktopTestingNotepadApp/tab_help'))
Windows.delay(2)
Windows.click(findWindowsObject('DesktopTestingNotepadApp/Edit(1)'))

Windows.clearText(findWindowsObject('DesktopTestingNotepadApp/Edit(1)'))
Windows.delay(2)
Windows.setText(findWindowsObject('DesktopTestingNotepadApp/Edit(1)'), 'Hello i m testing notepad using the katalon studio winappDriver')

Windows.closeApplication()

