import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.SimpleDateFormat
import org.openqa.selenium.*
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


select_any_date()
def select_any_date(){
	WebUI.openBrowser("http://demo.automationtesting.in/Datepicker.html")
	WebUI.findWebElement(findTestObject('DataPickerPage/datePicker')).click()
	WebDriver driver = DriverFactory.getWebDriver()
	List<WebElement> days = driver.findElements(By.xpath("//div[@class='datepick-month']//table//tr//td"))
	
	for(WebElement day: days){
		if(day.getText()=='15'){
			day.click()
		}
	}
	
	/**********Both Works Wells*************
	for(int i=0; i<days.size(); i++){
		if(days.get(i).getText()=='15'){
			days.get(i).click()
		}
	}
	***************************************/
}

//select_currentDate_and_time()
def select_currentDate_and_time(){
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
	
	
	/***********************************
	 * To enter the current time
	 ***********************************/
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
	SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm a");
	println(sdf.format(date)); //11:03:42 PM
	println(sdf1.format(date)); //11:05 PM


	/************************************************************
	 * TestCase start from here
	 * need To HARDCODE Month like January, february,..full Name
	 *************************************************************/
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
}