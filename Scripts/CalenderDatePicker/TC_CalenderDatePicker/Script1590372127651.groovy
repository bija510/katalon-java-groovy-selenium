import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException

String tcID = GlobalVariable.gTestCaseId
print "tcID>>>" +tcID
def currentBrowser = DriverFactory.getExecutedBrowser().getName()


try {

	
	/***********************************
	 * To enter the current date
	 * this Website need full name of Month like January...
	 * Need to rework 
	 ***********************************/
	String dateFormat = println new Date().format('MM/dd/yyyy') //Result 05/21/2020
	String dateFormat1 =  (new Date()-5).format('MM/dd/yyyy') //Result 05/16/2020
	
	String dateFormat2 = (new Date()+60).format('MM/dd/yyyy') //Result 07/20/2020
	String currDate = new Date().toGMTString() 
	
	String[] arrDate = currDate.split (' ')// NOTE split(' ') NEED SPACE here
	String year = arrDate[2]
	String month = arrDate[1]// some calender give Jun and some June
	String day = arrDate[0]
	println arrDate +"=====>"+ day+year+month //result [4, Jun, 2020, 12:49:01, GMT, =====>, 4, 2020, Jun]

	/****************************
	 * TestCase start from here
	 ****************************/
	WebUI.openBrowser("https://www.path2usa.com/travel-companions");
	WebUI.maximizeWindow()
	WebDriver driver = DriverFactory.getWebDriver()
	driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
	
	while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
			.contains("June")) {
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
	}
	
	List<WebElement> dates = driver.findElements(By.className("day"));
	int count = driver.findElements(By.className("day")).size();
	
	for (int i = 0; i < count; i++) {
		String text = driver.findElements(By.className("day")).get(i).getText();
		if (text.equalsIgnoreCase(day)) {
			driver.findElements(By.className("day")).get(i).click();
			break;
		
		}
	}
	
	
	
	/***********************************
	 * To enter the current time
	 ***********************************/
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
	SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm a");
	println(sdf.format(date)); //11:03:42 PM
	println(sdf1.format(date)); //11:05 PM

	 

} catch (WebElementNotFoundException e) {
	WebUI.takeScreenshot((GlobalVariable.gScreenshotDir)+ tcID + '.png', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo('ERROR:' + e.message)
	KeywordUtil.markFailed(tcID + 'failed, Element not found')

} catch (Exception e) {
	WebUI.takeScreenshot((GlobalVariable.gScreenshotDir)+ tcID + '.png', FailureHandling.STOP_ON_FAILURE)
	KeywordUtil.logInfo((('ERROR:' + e.message) + '\n Stack trace') + e.stackTrace)
	KeywordUtil.markFailed(tcID + 'failed')

}finally{

//WebUI.closeBrowser()

}
