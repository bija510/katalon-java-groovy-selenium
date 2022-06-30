import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


javascript_alert()
def javascript_alert(){
	WebUI.openBrowser("https://learn.letskodeit.com/p/practice");
	WebUI.maximizeWindow()
	WebUI.click(findTestObject('Object Repository/letsKodeItPage/btn_alert'))
	WebUI.delay(2)
	WebUI.acceptAlert()
}