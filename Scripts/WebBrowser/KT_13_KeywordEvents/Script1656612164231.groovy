
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


	WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
	WebUI.maximizeWindow() 

	WebUI.sendKeys(findTestObject('RegisterPage/txt_FirstName'), 'Bija')
	WebUI.sendKeys(findTestObject('RegisterPage/txt_FirstName'), Keys.chord(Keys.CONTROL,'a'))
	WebUI.delay(2)
	WebUI.sendKeys(findTestObject('RegisterPage/txt_FirstName'), Keys.chord(Keys.TAB))
	
	WebUI.sendKeys(findTestObject('RegisterPage/txt_LastName'), Keys.chord(Keys.DIVIDE))
	WebUI.sendKeys(findTestObject('RegisterPage/txt_LastName'), Keys.chord("aaaaa"))
	Thread.sleep(2000)
	WebUI.sendKeys(findTestObject('RegisterPage/txt_LastName'), Keys.chord(Keys.CONTROL,'a', Keys.BACK_SPACE))
	Thread.sleep(2000)
	
	WebDriver driver =DriverFactory.getWebDriver()
	driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[2]/input")).sendKeys(Keys.NUMPAD6)
	
