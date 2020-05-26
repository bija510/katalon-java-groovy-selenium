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

WebUI.openBrowser('http://demo.automationtesting.in/Alerts.html')
WebUI.maximizeWindow()

WebUI.click(findTestObject('DemoAutomationTesting/btn_OK'))
//WebUI.click(findTestObject('DemoAutomationTesting/btn_OK_click'))

CustomKeywords.'library.GUI.UtilitesAllSelenium.selectVisualButton'('click the button to display an  alert box:')
WebUI.acceptAlert()
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/DemoAutomationTesting/btn_OkandCancel'))
//WebUI.click(findTestObject('Object Repository/DemoAutomationTesting/btn_OKCancel_click'))

CustomKeywords.'library.GUI.UtilitesAllSelenium.selectVisualButton'('click the button to display a confirm box ')
WebUI.delay(2)
WebUI.acceptAlert()


WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/DemoAutomationTesting/btn_OkandCancel'))
WebUI.click(findTestObject('Object Repository/DemoAutomationTesting/btn_alertWTxt_Bx_click'))
WebUI.delay(2)
WebUI.acceptAlert()
