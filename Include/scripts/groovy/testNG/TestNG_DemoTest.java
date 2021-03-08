package testNG;

//UnUsed import
//import internal.GlobalVariable;
//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
//import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;
//
//import com.kms.katalon.core.annotation.Keyword;
//import com.kms.katalon.core.checkpoint.Checkpoint;
//import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
//import com.kms.katalon.core.model.FailureHandling;
//import com.kms.katalon.core.testcase.TestCase;
//import com.kms.katalon.core.testdata.TestData;
//import com.kms.katalon.core.testobject.TestObject;
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
//import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;

import com.kms.katalon.core.webui.driver.DriverFactory;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
public class TestNG_DemoTest {

	private WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		WebUiBuiltInKeywords.openBrowser("https://learn.letskodeit.com/p/practice");
		WebUiBuiltInKeywords.maximizeWindow();
		driver = DriverFactory.getWebDriver();
	}

	@Test
	public void checkBMWChk_Test() {
		driver.findElement(By.xpath("//input[@id='bmwcheck']")).click();
	}

	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		WebUiBuiltInKeywords.closeBrowser();
	}
}