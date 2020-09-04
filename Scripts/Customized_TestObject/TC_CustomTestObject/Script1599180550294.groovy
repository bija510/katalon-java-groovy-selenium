import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://www.facebook.com/')

/***********************************************
 This is without object in Object Repositatory
 ************************************************/

def userNameTextBox = new TestObject() //you can arite inside in () or empty no problem
userNameTextBox.addProperty('xpath', ConditionType.EQUALS, "//input[@id='email']")

WebUI.setText(userNameTextBox, 'TestUserName')

/***********************************************
 This is with object in Object Repositatory
 & Choose Attributes btn inside
************************************************/

def passwordTextBox = findTestObject('Page_Facebook/Empty_pwd').addProperty('xpath', ConditionType.EQUALS,"//input[@id='pass']")
WebUI.setText(passwordTextBox, 'Test123')



