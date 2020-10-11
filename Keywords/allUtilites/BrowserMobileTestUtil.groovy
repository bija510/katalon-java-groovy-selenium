package allUtilites

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.annotation.Keyword

public class BrowserMobileTestUtil {
	@Keyword
	public WebDriver chromeSetUp(String deviceName) {
		// deviceName = ['iPhone X', 'Nexus 5', 'Galaxy S5']
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", deviceName);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize()
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); // navigator.appVersion
		System.out.println("Executed Device Name:- " + uAgent.substring(13, 37));
		return driver


	}
}
