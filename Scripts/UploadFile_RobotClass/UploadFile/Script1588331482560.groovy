import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

WebUI.delay(2)
String FileUploadPath =RunConfiguration.getProjectDir() + '\\Include\\UploadFile\\SamplePDF.pdf'
//FileUploadPath = FileUploadPath.replace('/','\\')

/*******************************************************************************
 * Upload file work for only certain website and DON'T work for alot of browser'
 * by using Upload and sendKey
 ********************************************************************************/

WebUI.openBrowser('https://www.techlistic.com/p/selenium-practice-form.html')
WebUI.maximizeWindow()
//WebUI.sendKeys(findTestObject('Object Repository/UploadFile/btn_upload2'), FileUploadPath)
WebUI.scrollToElement(findTestObject('Object Repository/UploadFile/btn_upload2'), 2)
WebUI.delay(3)
CustomKeywords.'library.GUI.UploadFile.uploadFileNish'(findTestObject('Object Repository/UploadFile/btn_upload2'), FileUploadPath)




System.exit(0)
//Example 1
WebUI.openBrowser('https://www.tutdepot.com/demos/php_file_upload.php')
WebUI.maximizeWindow()
WebUI.sendKeys(findTestObject('Object Repository/DemoAutomationTesting/btn_upload2'), FileUploadPath)


System.exit(0)
//Example 2
WebUI.openBrowser('https://cgi-lib.berkeley.edu/ex/fup.html')
WebUI.maximizeWindow()
WebUI.sendKeys(findTestObject('Object Repository/UploadFile/btn_upload'), FileUploadPath)
//WebUI.uploadFile(findTestObject('Object Repository/UploadFile/btn_upload'), FileUploadPath)



//Example 3
WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
WebUI.maximizeWindow()
//CustomKeywords.'library.GUI.UploadFile.uploadFileNew'(findTestObject('DemoAutomationTesting/btn_fileUpload'), FileUploadPath)
//CustomKeywords.'library.GUI.UploadFile.uploadFileNish'(findTestObject('DemoAutomationTesting/btn_fileUpload'), FileUploadPath)
WebUI.sendKeys(findTestObject('DemoAutomationTesting/btn_fileUpload'), FileUploadPath)