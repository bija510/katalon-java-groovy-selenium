import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utilites.LinkTestUtils


/* 
'Example:-1'

int brokenCount = 0
WebUI.openBrowser("")
WebUI.navigateToUrl("http://google.com/")
brokenCount += LinkTestUtils.findBrokenLinks(WebUI.getUrl())

if(brokenCount>0) {
	KeywordUtil.markFailed("Verify all links in the current page Fail with [${brokenCount}] link")
}
*/

'Example:-2'

WebUI.openBrowser("")
WebUI.navigateToUrl("http://google.com/")
WebUI.verifyAllLinksOnCurrentPageAccessible(false, null)



/*
'Example:-3'

 int brokenCount = 0
 WebUI.openBrowser("")
 WebUI.navigateToUrl("http://google.com/")
 brokenCount += LinkTestUtils.findBrokenLinks2(WebUI.getUrl())
 
 if(brokenCount>0) {
	 KeywordUtil.markFailed("Verify all links in the current page Fail with [${brokenCount}] link")
 }
*/
 