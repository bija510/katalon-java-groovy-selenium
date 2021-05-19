import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utilites.LinkTestUtils


WebUI.openBrowser("")
WebUI.navigateToUrl("http://google.com/")
LinkTestUtils.findBrokenLinks(WebUI.getUrl())