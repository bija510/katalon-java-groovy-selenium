package utilites

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class JavaScript {

	@Keyword
	static def clickJS(TestObject to, int timeout) throws Exception{
		WebElement ele = WebUiCommonHelper.findWebElement(to, timeout)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(ele))
	}

	@Keyword
	static def sendKeyJS(String toPath, String val)throws Exception{
		WebElement ele = WebUiCommonHelper.findWebElement(findTestObject(toPath), 10)
		WebUI.executeJavaScript("arguments[0].value='"+ val +"'", Arrays.asList(ele))
		if(ele.getAttribute("value").equals(val)){
		}else{
			throw new Exception("Error Unable to set "+val+ "in textBox")
		}
	}

	@Keyword
	static def getTextJS(TestObject to, int timeout) throws Exception{
		WebElement ele = WebUiCommonHelper.findWebElement(to, timeout)
		WebUI.executeJavaScript("return (arguments[0].innerHTML).toString();", Arrays.asList(ele))
	}

	@Keyword
	static def removeAttributeJS(TestObject to, int timeout, String AttributeName) throws Exception{
		//disabled ,readonly
		WebElement ele = WebUiCommonHelper.findWebElement(to, timeout)
		WebUI.executeJavaScript('arguments[0].removeAttribute(' +'"' +AttributeName+ '"'+ ');', Arrays.asList(ele))
	}

	/****************************************************
	 @param Num:- pass range 100 to 2000 for Scroll down
	 @param Num:- pass range -100 to -2000 for Scroll up
	 *****************************************************/
	@Keyword
	static def scroll(int Num){
		WebUI.executeJavaScript('window.scrollBy(0,'+Num+')', null)
	}

	@Keyword
	static def scrollToElement(TestObject to, int timeout) throws Exception{
		WebElement ele = WebUiCommonHelper.findWebElement(to, timeout)
		WebUI.executeJavaScript("arguments[0].scrollIntoView(true)", Arrays.asList(ele))
	}

	@Keyword
	static def vScrollToBottom()throws Exception{
		WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)", null)
	}

	@Keyword
	static def hScrollToRight()throws Exception{
		WebUI.executeJavaScript("document.documentElement.clientWidth,0)", null)
	}

	@Keyword
	static def setBrowserZoomInOut(int NumPercent){
		WebUI.executeJavaScript("document.body.style.zoom="+ "'" + NumPercent + "%'" + ";", null)
	}
}