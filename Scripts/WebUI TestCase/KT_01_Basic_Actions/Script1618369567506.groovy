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


'1. Open Browser'
WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
//WebUI.navigateToUrl('http://demo.automationtesting.in/Register.html')

'2. Maximize'
WebUI.maximizeWindow()

'3. Text Box'
WebUI.setText(findTestObject('RegisterPage/txt_FirstName'), 'Michal')
WebUI.sendKeys(findTestObject('RegisterPage/txt_LastName'), 'Jackson')

'4.clear Text'
WebUI.clearText(findTestObject('RegisterPage/txt_LastName'))

'5. getText'
println "Page Header = " + WebUI.getText(findTestObject('Object Repository/RegisterPage/lbl_Register'))

'6. GetAttribute of value'
println "firstName TextBox attribute value = " + WebUI.getAttribute(findTestObject('RegisterPage/txt_FirstName'), 'value')

'7. Radio Button'
WebUI.click(findTestObject('RegisterPage/rad_Male'))

'8. CheckBox'
WebUI.check(findTestObject('RegisterPage/chk_Movie'))
WebUI.delay(2)
WebUI.uncheck(findTestObject('RegisterPage/chk_Movie'))

'9. DropDown'
WebUI.selectOptionByLabel(findTestObject('RegisterPage/ddl_skills'), 'C', false)
WebUI.selectOptionByIndex(findTestObject('RegisterPage/ddl_skills'), '2', false)
WebUI.selectOptionByValue(findTestObject('RegisterPage/ddl_skills'), 'Android', false)

'10. Close Browser'
WebUI.closeBrowser()

