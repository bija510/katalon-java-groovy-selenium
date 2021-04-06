import org.openqa.selenium.*
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



WebUI.openBrowser("https://learn.letskodeit.com/p/practice")
WebUI.maximizeWindow()
WebUI.executeJavaScript("window.scrollBy(0,400)", null)

WebDriver driver = DriverFactory.getWebDriver()
driver.findElements(By.cssSelector("table tbody tr td")).each{
   el->
   el.getText()
}

