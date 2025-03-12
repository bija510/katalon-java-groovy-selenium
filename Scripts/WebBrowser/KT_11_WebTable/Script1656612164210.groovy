import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


	/************************************************
	 * select DDL Using Katalon Built-in function 
	 * https://total-qa.com/selenium/demo-sites/
	 * this Work but need to wait it takes time 
	 *************************************************/

	def demo1(){
		WebUI.openBrowser('https://www.w3schools.com/html/html_tables.asp')
		WebUI.maximizeWindow() 
		WebUI.executeJavaScript("window.scrollBy(0, 300)", null)
		WebUI.delay(2)
		String actName = 'UK'
		String expName = CustomKeywords.'com.qa.utils.WebTable.getRowColumnValue'(findTestObject('WebORHtmlTable/tbl_w3'), 'UK', 'Country')
	    WebUI.verifyMatch(actName, expName, false)
	}
	
	def demo2(){	
		WebUI.openBrowser('https://www.w3schools.com/html/html_tables.asp')
		WebUI.maximizeWindow()
		WebUI.executeJavaScript("window.scrollBy(0, 300)", null)
		WebUI.delay(2)
		
		println CustomKeywords.'com.qa.helpers.WebTableHelper.GetValueFromGrid'(findTestObject('WebORHtmlTable/tbl_w3 - Copy'), 2, 2)	
	}
	
	