import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//drag_and_drop()
def drag_and_drop(){
	WebUI.openBrowser('http://demo.guru99.com/test/simple_context_menu.html')
	WebUI.dragAndDropToObject(findTestObject('MouseEvent/dragNDrop1'), findTestObject('MouseEvent/DragNdrop2'))
}

right_click()
def right_click(){
	WebUI.openBrowser('http://demo.guru99.com/test/simple_context_menu.html')
	WebUI.maximizeWindow()
	WebUI.delay(2)
	WebUI.rightClick(findTestObject('MouseEvent/Rightclick'))
}

def mouse_hover(){
	WebUI.openBrowser('https://www.amazon.com/')
	WebUI.maximizeWindow()
	WebUI.mouseOver(findTestObject('MouseEvent/MouseHover'))
	System.exit(0)
}
	
def double_click(){
	WebUI.openBrowser('https://testautomationpractice.blogspot.com')
	WebUI.maximizeWindow()
	WebUI.doubleClick(findTestObject('MouseEvent/doubleclick'))
}
	
	/****************************************************************************************************
	 * 5. mouse Event:-Click and hold
	 * katalon doesnot have Click and hold function so need to use selenium function with ACTION CLASS
	 * import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
     * import org.openqa.selenium.interactions.Actions as Actions
	 ***************************************************************************************************/
def click_and_hold(){
	WebUI.openBrowser('https://selenium08.blogspot.com/2020/01/click-and-hold.html')
	WebUI.maximizeWindow()
	WebUI.executeJavaScript('window.scrollBy(0,500)', null)
	WebDriver driver = DriverFactory.getWebDriver()
	Actions builder = new Actions(driver)
	WebElement sourceElement = WebUiCommonHelper.findWebElement(findTestObject('MouseEvent/clickNHold'), 20)
	builder.clickAndHold(sourceElement).build().perform()
	WebUI.delay(2)
	builder.moveToElement(sourceElement).release().build().perform()
}