import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import utilites.Utils

WebUI.openBrowser("http://demo.automationtesting.in/Register.html")
WebUI.takeScreenshot(((GlobalVariable.gScreenshotDir + GlobalVariable.gTestCaseId) +'_Failed_') + Utils.get5DigitTimeStamp()+ '.png', FailureHandling.STOP_ON_FAILURE)