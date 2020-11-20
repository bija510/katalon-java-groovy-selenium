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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
//additional import
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By;


   /***************************************************
    * DataDriven or Paramaterization using for loop
    ***************************************************/
	WebUI.openBrowser(url)  //or GlobalVariable.url
	WebUI.maximizeWindow()
	
	String userNames ='Adam¤Bija¤Cindey¤David'
	String []userNameList = userNames.split('¤') //can be split with space or = or anything instead of ¤
	
	for (String username : userNameList){
		
		def control = CustomKeywords.'library.GUI.UtilitesAllSelenium.getalphaNumericString'(10)+" "+ username
		WebUI.setText(findTestObject('Page_Facebook/input_concat2'), control)
		WebUI.delay(2)
		
		WebUI.setText(findTestObject('Page_Facebook/input_concat3'), 'abc123')
			
	}
	
