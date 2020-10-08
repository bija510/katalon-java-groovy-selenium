import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


String lastName = "Last Name"

WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
WebUI.maximizeWindow()
WebUI.setText(findTestObject('DemoAutomationTesting/Register/parameterized_TO',[('lastname'):lastName]), "Ram")

