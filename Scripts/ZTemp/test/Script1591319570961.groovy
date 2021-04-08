import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import allUtilites.*
import groovy.json.*
import helpers.WebTableHelper

import com.kms.katalon.core.webui.driver.DriverFactory
import utilites.JavaScript
import utilites.Utils
import org.openqa.selenium.*
 


WebUI.openBrowser('https://www.w3schools.com/html/html_tables.asp')
WebUI.maximizeWindow()
WebUI.executeJavaScript("window.scrollBy(0, 300)", null)
WebUI.delay(2)

println CustomKeywords.'helpers.WebTableHelper.GetValueFromGrid'(findTestObject('WebORHtmlTable/tbl_w3 - Copy'), 2, 2)


