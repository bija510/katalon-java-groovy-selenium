package utilites

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
import com.kms.katalon.util.CryptoUtil

import internal.GlobalVariable
import java.text.SimpleDateFormat
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

public class Utils {

	@Keyword
	static def currentDate(){
		new Date().format('MM/dd/yyyy') //Result 05/21/2020
	}

	@Keyword
	static def currentTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm a");
		//println(); //11:03:42 PM
		//println(sdf1.format(date)); //11:05 PM
		return sdf.format(date)
	}

	@Keyword
	static def get5DigitTimeStamp(){
		String ts = new Date().format('yyyyMMddHHmmssSSS')
		return ts.substring(ts.length() - 5)
	}

	@Keyword
	def static getAlphaNumericString(int length){
		String alphaNumericStr= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
		StringBuilder sb = new StringBuilder(length-1)
		
		for (int i =0; i< length-1; i++){
			int index = (int) (alphaNumericStr.length()*Math.random())
			sb.append(alphaNumericStr.charAt(index))
		}
		
		String NumericStr= "0123456789"
		StringBuilder sb2 = new StringBuilder(1)
		int index2 = (int) (NumericStr.length()*Math.random())
		sb2.append(NumericStr.charAt(index2))
		
		String finalStr = sb.toString()+sb2.toString()
		return finalStr
	}

	
	@Keyword
	def static getRandomAlphabetString(int length){
		String alphaNumericStr= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
		StringBuilder sb =new StringBuilder(length)
		for (int i =0; i< length; i++){
			int index = (int) (alphaNumericStr.length()*Math.random())
			sb.append(alphaNumericStr.charAt(index))
		}
		return sb.toString()
	}


	@Keyword
	public void catch1(String tcId, WebElementNotFoundException e){
		WebUI.takeScreenshot((((GlobalVariable.gScreenshotDir + tcId) +'_Failed_') + Utils.get5DigitTimeStamp() )+'.png', FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo('ERROR:' + e.message)
		KeywordUtil.markFailed(tcId + 'failed, Element not found')
	}


	@Keyword
	public void catch2(String tcId, Exception e){
		WebUI.takeScreenshot((((GlobalVariable.gScreenshotDir + tcId) +'_Failed_') + Utils.get5DigitTimeStamp() )+'.png', FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo((('ERROR:' + e.message) + '\n Stack trace') + e.stackTrace)
		KeywordUtil.markFailed(tcId + 'failed')
	}

	@Keyword
	def selectVisualButton(String buttonName){
		try{
			int counter
			WebDriver driver = DriverFactory.getWebDriver()
			List<WebElement> buttons = driver.findElements(By.xpath("*[contains(text(),'"+buttonName+"']"))
			for (WebElement button : buttons){
				println counter
				if(button.isDisplayed()){
					button.click()
					println 'button'+counter+'clicked'
					break
				}
				counter++
			}
		}

		catch(WebElementNotFoundException e){
			KeywordUtil.markFailed("Failed to click on"+ buttonName + " Button")
		}catch (Exception e){
			KeywordUtil.markFailed("Failed to click on"+ buttonName + " Button")
		}
	}

	/**
	 * @param text = ex: +mmvG/CrT7k= will give apple
	 * @return
	 */
	static def decryptText(def text){
		return CryptoUtil.decode(CryptoUtil.getDefault(text))
	}

	/**
	 * @param text = ex: apple will give +mmvG/CrT7k=
	 * @return
	 */
	static def encryptText(def text){
		return CryptoUtil.encode(CryptoUtil.getDefault(text))
	}
}
