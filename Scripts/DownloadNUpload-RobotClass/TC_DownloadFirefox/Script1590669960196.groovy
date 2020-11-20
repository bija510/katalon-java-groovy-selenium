import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory

def currentBrowser = DriverFactory.getExecutedBrowser().getName()

	
	/***************************************************************
	 * Need To run in --------FIREFOX------- to get Download pop up
	 * by using it we will not see the pop up in firefox
	 * In chrome no pop up Occur
	 **************************************************************/
	
	if(currentBrowser.toString().equals("FIREFOX_DRIVER")){  //for chromr = CHROME_DRIVER ** for MS.edge =EDGE_CHROMIUM_DRIVER **for edge= EDGE_DRIVER

		FirefoxProfile profile = new FirefoxProfile()
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf")//mime type
		profile.setPreference("browser.download.manager.showWhenStarting", false)
		profile.setPreference("pdfjs.disabled", true)
	
		FirefoxOptions option =new FirefoxOptions()
		option.setProfile(profile)
	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bijaya Chhetri\\Documents\\Katalon_Studio_Windows_64-7.2.1\\configuration\\resources\\drivers\\firefox_win64\\geckodriver.exe")
		WebDriver driver = new FirefoxDriver(option)
		driver.get("http://demo.automationtesting.in/FileDownload.html")
	
		driver.manage().window().maximize()
		driver.findElement(By.xpath("//*[@id='textbox']")).sendKeys('TestData For .txt')
		driver.findElement(By.xpath("//*[@id='createTxt']")).click()
		Thread.sleep(2000)
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click()
	
	}else{
		println('Other Browser is used than Firefox')
	}
	
		
		
