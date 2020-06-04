package library.GUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.reflect.Array

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

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.apache.commons.lang.text.StrBuilder
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.openqa.selenium.JavascriptExecutor

class JScript {
	
	
	/******************
	 * scrollToElement()
	 ******************/
	@Keyword
	def scrollToElement(String toPath) throws Exception{
		WebElement ele = WebUiCommonHelper.findWebElement(findTestObject(toPath), 10)
		WebUI.executeJavaScript("arguments[0].scrollIntoView(true)", Arrays.asList(ele))
		}

		
	/******************
	 * vScrollToBottom()
	 ******************/
	@Keyword
	def vScrollToBottom()throws Exception{

		WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)", null)

	}
	/******************
	 * hScrollToRight()
	 ******************/
	@Keyword
	def hScrollToRight()throws Exception{

		WebUI.executeJavaScript("document.documentElement.clientWidth,0)", null)

	}
	/******************
	 * sendKeyJS()
	 ******************/
	@Keyword
	def sendKeyJS(String toPath, String val)throws Exception{
		WebElement ele = WebUiCommonHelper.findWebElement(findTestObject(toPath), 10)
		WebUI.executeJavaScript("arguments[0].value='"+ val +"'", Arrays.asList(ele))

	}





}