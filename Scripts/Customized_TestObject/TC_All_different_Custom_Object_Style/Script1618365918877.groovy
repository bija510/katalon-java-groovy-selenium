import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



//modify_test_object_at_runtime()
def modify_test_object_at_runtime(){
	WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
	
	TestObject lastName = WebUI.modifyObjectProperty(findTestObject('RegisterPage/txt_FirstName'), 'css', 'equals', "input[placeholder='Last Name']", true)
	WebUI.setText( lastName, "David")
}

//test_object_xpath_attribute()
def test_object_xpath_attribute(){
	TestObject myNewObject = new TestObject('ObjectID')
	myNewObject.setSelectorMethod(SelectorMethod.BASIC)
	myNewObject.addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder='First Name']", true)
	
	WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
	WebUI.setText( myNewObject, "David")
}

//test_object_xpath_method()
def test_object_xpath_method(){
	TestObject obj_xpath_method = new TestObject('ObjectID')
	obj_xpath_method.setSelectorValue(SelectorMethod.XPATH,"//input[@placeholder='First Name']")
	obj_xpath_method.setSelectorMethod(SelectorMethod.XPATH)
 
	WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
	WebUI.setText( obj_xpath_method, "David")
}

//test_object_css_method()
def test_object_css_method(){
	TestObject obj_css_method = new TestObject('ObjectID')
	obj_css_method.setSelectorValue(SelectorMethod.CSS, "input[placeholder='First Name']")
	obj_css_method.setSelectorMethod(SelectorMethod.CSS)
 
	WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
	WebUI.setText( obj_css_method, "David")
}

test_object_condational_css()
def test_object_condational_css(){
	TestObject testObject_css = new TestObject('ObjectID')
	testObject_css.addProperty("css", ConditionType.EQUALS, "input[placeholder='First Name']")
	WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
	WebUI.setText( testObject_css, "David")

}
















