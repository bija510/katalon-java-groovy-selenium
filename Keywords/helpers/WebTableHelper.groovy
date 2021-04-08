package helpers

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class WebTableHelper {

        /**
		 * 1. Get the base xpath from the test object
		 * 2. Append the additional xpath
		 * 3. Create a new Test Object
		 * 4. return the updated test object
		 * 
		 **/
	private TestObject getTestObject(TestObject baseTestObject,String xpath){
		String baseXpath = baseTestObject.getProperties().get(0).getValue();
		String updatedXpath = baseXpath + xpath;
		TestObject updatedTestObject = new TestObject("Grid")
		updatedTestObject.addProperty("xpath", ConditionType.EQUALS, updatedXpath)
		return updatedTestObject
	}
	

	/**
	 * @param Test Object for the web table
	 * @param Row Index
	 * @param Column Index
	 *
	 */
	@Keyword
	public String GetValueFromGrid(TestObject baseTestObject,int rowIndex,int colIndex){
		TestObject updatedTestObject = getTestObject(baseTestObject,"/tr[" + rowIndex+  "]/td[" + colIndex + "]")
		println "==>"+ updatedTestObject
		return WebUI.getText(updatedTestObject)
	}

	/**
	 * Type = CheckBox //table[@role='grid']/tbody - base xpath --- /tr[index]/td[index]/input
	 * Type = Button //table[@role='grid']/tbody - base xpath --- /tr[index]/td[index]/a
	 * Type = Value //table[@role='grid']/tbody/tr[3]/td[3]
	 **/
	@Keyword
	public String getValueOrClickOnColumn(TestObject baseTestObject, int rowIndex, int colIndex, String type){
		

		TestObject updatedTestObject = null

		if("CheckBox".equalsIgnoreCase(type)){
			updatedTestObject = getTestObject(baseTestObject,"/tr[" + rowIndex+  "]/td[" + colIndex + "]/input")
			WebUI.click(updatedTestObject)
			return ""
		}else if("Button".equalsIgnoreCase(type)){
			updatedTestObject = getTestObject(baseTestObject,"/tr[" + rowIndex+  "]/td[" + colIndex + "]/a")
			WebUI.click(updatedTestObject)
			return ""
		}else {
			updatedTestObject = getTestObject(baseTestObject,"/tr[" + rowIndex+  "]/td[" + colIndex + "]")
			return WebUI.getText(updatedTestObject)
		}
	}
}
