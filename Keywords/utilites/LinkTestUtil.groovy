package utilites

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject

public class LinkTestUtils {

	/**
	 * @param pageUrl = pass the current page URL(WebUI.getUrl())
	 * @return  Broken links count
	 */
	static int findBrokenLinks(String pageUrl) {

		/*******************************************
		 Waiting until the page gets stable
		 *******************************************/
		WebUI.waitForPageLoad(6)
		WebUI.delay(5)

		/****************************************************
		 find all <a> elements with non-null href attribute
		 ****************************************************/
		TestObject tObjAnchors = new TestObject("all anchors").addProperty("xpath", ConditionType.EQUALS, "//a")
		List<WebElement> anchors = WebUI.findWebElements(tObjAnchors, 10)
		List<String> hrefs =
				anchors.stream()
				.filter { we -> we.getAttribute('href') != null }
				.map { we -> we.getAttribute('href') }
				.collect()

		/***************************
		 prepare buffer for messages
		 ***************************/
		StringBuilder messageBuffer = new StringBuilder()
		messageBuffer.append("*** All <a> elements in ${pageUrl} ***${System.lineSeparator}")

		/***************************
		 Now we do the job!
		 ***************************/
		int brokenLinksCount = linkTest(hrefs, messageBuffer)

		/***************************
		 print message
		 ***************************/
		print(messageBuffer.toString())

		return brokenLinksCount
	}



	static int linkTest(List<String> urls, Appendable messageBuffer) {
		Objects.requireNonNull(urls)
		Objects.requireNonNull(messageBuffer)
		int statusCode = 200
		int count = 0
		int broken_links = 0
		int valid_links = 0

		for (url in urls) {
			//WS.comment("${url}")
			if ((url == null) || (url.isEmpty())) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue
			}

			/* href = "javascript:void(0)"; */
			if (url.startsWith("javascript")){
				System.out.println("URL href= 'javascript:void(0) [This is not a link] & it means, do nothing:- don't reload, don't navigate, do not run any code.");
				continue
			}

			if (url != null && url.startsWith('http')) {
				RequestObject req = new RequestObject('check if this url is reachable')
				req.setServiceType('REST')
				req.setRestUrl(url)
				req.setRestRequestMethod('GET')
				// Send the request and get the response
				ResponseObject res = WS.sendRequest(req)
				statusCode = res.getStatusCode()  // '200' OK, '302' redirected, '403' etc
			}

			try {
				messageBuffer.append("${statusCode} <a href=${url}>${System.lineSeparator}")

				if (statusCode >= 400) {
					System.err.println(url + " ["+statusCode+"]" +" is a broken link");
					broken_links++;
				} else {
					System.out.println(url + " ["+statusCode+"]"  + " valid link");
					valid_links++;
				}
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}


		}
		KeywordUtil.logInfo("=======Detection of broken links completed with [" + broken_links + "] broken links and ["
				+ valid_links + "] valid links========\n");

		return broken_links
	}


}
