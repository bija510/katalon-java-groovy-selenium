package library.GUI

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import internal.GlobalVariable

public class ErrorHandler {
	
	@Keyword
	public void catch1(String tcId, WebElementNotFoundException e){
		WebUI.takeScreenshot((((GlobalVariable.gScreenshotDir + tcId) +'_Failed_') + new allUtilites.impUTILS().get5DigitTimeStamp() )+'.png', FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo('ERROR:' + e.message)
		KeywordUtil.markFailed(tcId + 'failed, Element not found')
	}
	
	
	@Keyword
	public void catch2(String tcId, Exception e){
		WebUI.takeScreenshot((((GlobalVariable.gScreenshotDir + tcId) +'_Failed_') + new allUtilites.impUTILS().get5DigitTimeStamp() )+'.png', FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo((('ERROR:' + e.message) + '\n Stack trace') + e.stackTrace)
		KeywordUtil.markFailed(tcId + 'failed')
	}
}
