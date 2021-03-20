package utilites
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI





public class WebTable {

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

		WebElement Table =  WebUI.findWebElement(to)
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

		WebElement Table =  WebUI.findWebElement(to)
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







