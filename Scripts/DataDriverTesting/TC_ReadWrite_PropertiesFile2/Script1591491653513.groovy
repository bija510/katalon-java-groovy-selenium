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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable


/**************************************************************************
 * Value Reading from Properties File and storing in the String
 **************************************************************************/
Properties prop =new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//Data Files All//textFile2.properties");
prop.load(fis);
String myName = prop.getProperty("Name");
println myName

/**************************************************************************
 * Writing String Key and Value to Properties File
 * String Key = aResult  and String Value = TC Successfully Failed000
 **************************************************************************/
prop.setProperty("lastName", "Chhetri1");
FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"//Data Files All//textFile2.properties");

prop.store(fos, "Write data to Properties File TimeStamp");
fis.close();