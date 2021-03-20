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

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By;


WebUI.openBrowser('https://www.capitalone.com/about/corporate-information/corporate-offices/')
WebUI.maximizeWindow()
clickTab('Business')


def clickTab(String buttonName){
	switch(buttonName){
		case 'Credit Cards':
			WebUI.click(findTestObject("CapitalOne/span_CreditCards"))
			break;

		case 'Checking & Savings':
			WebUI.click(findTestObject("CapitalOne/span_CheckingSavings"))
			break;

		case 'Auto Loans':
			WebUI.click(findTestObject("CapitalOne/span_AutoLoans"))
			break;

		case 'Business':
			WebUI.click(findTestObject("CapitalOne/span_Business"))
			break;

		case 'Commercial':
			WebUI.click(findTestObject("CapitalOne/span_Commercial"))
			break;

		case 'Learn & Grow':
			WebUI.click(findTestObject("CapitalOne/_LearnAndGrow"))
			break;
	}
}