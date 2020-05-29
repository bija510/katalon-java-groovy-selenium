package library.GUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI


import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

//Added import
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.awt.Robot
import java.awt.Toolkit
import org.openqa.selenium.WebElement



class DownloadFileRC {

	@Keyword
	def DownloadFileTEXT(WebElement we ){

		we.click()

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		//robot.keyRelease(KeyEvent.VK_DOWN);
		//WebUI.delay()
//
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB)
//		//WebUI.delay(2)
//
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB)
//		//WebUI.delay(2)
//
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB)
		//		robot.keyPress(KeyEvent.VK_TAB);
		//		robot.keyRelease(KeyEvent.VK_TAB)
		WebUI.delay(2)

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER)
		//WebUI.delay(2)


	}

	@Keyword
	def DownloadFilePDF(WebElement web ){

		web.click()

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		WebUI.delay(2)

		//		robot.keyPress(KeyEvent.VK_TAB);
		//		WebUI.delay(2)

		robot.keyPress(KeyEvent.VK_ENTER);
		WebUI.delay(2)


	}

}







