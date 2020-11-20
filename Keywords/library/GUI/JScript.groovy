package library.GUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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