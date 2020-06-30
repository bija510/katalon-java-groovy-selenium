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

//Added import
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By as By





public class HTMLTable {

	/*****************************************************************************************
	 * HTML Table-1:- For getText()
	 * This function is good to click() on any rowColumn or getText() from any rowColumn
	 * In 1 & 2 only difference is this line:- return Cols.get(colIndex).getText()
	 *****************************************************************************************/

	@Keyword
	def getRowColumnValue(TestObject to, String KeyVal, String colToGet){

		WebUI.delay(2)
		int colIndex = -1
		boolean found =false
		String retVal =''

		WebElement Table =  WebUiBuiltInKeywords.findWebElement(to)
		List<WebElement> Rows =Table.findElements(By.tagName('tr'))
		List<WebElement> ColHeaders = Rows.get(0).findElements(By.tagName('th'))
		for(int i=0; i < ColHeaders.size(); i++){
			if (ColHeaders.get(i).getText().toLowerCase().contains(colToGet.toLowerCase())){
				//println ColHeaders.get(i).getText()
				colIndex =i
				break;
			}
		}
		outerLoop:
		for(int i=0; i < Rows.size(); i++){
			List<WebElement> Cols =Rows.get(i).findElements(By.tagName('td'))
			int colSize = Cols.size()
			for(int j = 0; j < Cols.size(); j++){

				if (Cols.get(j).getText().toLowerCase().contains(KeyVal.toLowerCase())){
					//return Cols.get(colIndex).click()
					return Cols.get(colIndex).getText()
					found = true
					break outerLoop;

				}

			}
		}
		if(found){
			return retVal
		}else{
			throw new Exception(KeyVal +'Was NOt Found')

		}
		WebUI.delay(1)
	}

	/*****************************************************************************************
	 * HTML Table-2:- For click() or Select
	 * This function is good to click() on any rowColumn
	 * In 1 & 2 Funct difference is return Cols.get(colIndex).click()
	 *****************************************************************************************/

	@Keyword
	def selectRowFromTable(TestObject to, String KeyVal, String colToGet){

		WebUI.delay(2)
		int colIndex = -1
		boolean found =false

		WebElement Table =  WebUiBuiltInKeywords.findWebElement(to)
		List<WebElement> Rows =Table.findElements(By.tagName('tr'))
		List<WebElement> ColHeaders = Rows.get(0).findElements(By.tagName('th'))
		for(int i=0; i < ColHeaders.size(); i++){
			if (ColHeaders.get(i).getText().toLowerCase().contains(colToGet.toLowerCase())){
				//println ColHeaders.get(i).getText()
				colIndex =i
				break;
			}
		}
		outerLoop:
		for(int i=0; i < Rows.size(); i++){
			List<WebElement> Cols =Rows.get(i).findElements(By.tagName('td'))
			int colSize = Cols.size()
			for(int j = 0; j < Cols.size(); j++){

				if (Cols.get(j).getText().toLowerCase().contains(KeyVal.toLowerCase())){
					//return Cols.get(colIndex).click()
					return Cols.get(colIndex).click()
					found = true
					break outerLoop;

				}

			}
		}
		if(!found){
			throw new Exception(KeyVal + 'Was not found')
		}
		WebUI.delay(1)
	}
}







