package com.qa.helpers
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class DropDownHelper {

	/**************************************************************
	 * Example:-
	 * Ctrl + Shift + O = To remove unused Import and organize
	 * String[] str = ["url1","url2","url3","url4"]
	 * CustomKeywords.'com.qa.helpers.DropDownHelper.verifyDDLItems'(toPath, str)
	 *****************************************************************/

	@Keyword
	def verifyDDLItems(String toPath, String[] arrDDLList ) throws Exception{

		Select select =new Select(WebUI.findWebElement(findTestObject(toPath)))
		List<WebElement> expddlvalues= select.getOptions()

		int expddlSize = expddlvalues.size()
		int actddlSize = arrDDLList.size()
		WebUI.verifyEqual(actddlSize, expddlSize)

		for(int i=0; i < expddlvalues.size(); i++){
			WebUI.verifyMatch(arrDDLList[i], expddlvalues.get(i).getText(), false) //import org.openqa.selenium.WebElement
		}
	}


	/**************************************************************
	 * Example:-
	 * String[] str = ["url1","url2","url3","url4"]
	 * CustomKeywords.'com.qa.helpers.DropDownHelper.addSingleQuoteNComma'(str)
	 *****************************************************************/
	@Keyword
	def addSingleQuoteNComma(String[] str ) throws Exception{
		//String[] str = ["url1","url2","url3","url4"]
		ArrayList<String> strList = new ArrayList<String>();
		for (String k:str)
			strList.add("'" +k+ "'"+",");
		System.out.println("Printing the list");
		for(String k:strList)
			System.out.print(k);

	}
}






