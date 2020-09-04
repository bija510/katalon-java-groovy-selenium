import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import groovy.json.*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//String fileName = "../KatalonTest/Data Files All/JsonFile.json"
//def slurper = new JsonSlurper()
//Map parsedData = slurper.parse(new File(fileName))
//
//println parsedData.firstName
//println parsedData.address.city
//println parsedData.get("isUSCitizen")
//
//println parsedData.phoneNumbers[0]
//println parsedData.phoneNumbers[1]
//println parsedData.salary
//
//println parsedData.phoneNumbers[1].number





 
 //Process p= Runtime.getRuntime().exec("cmd /c netstat");
//echo %userprofile%\Downloads ==> to print the path of the downloads folder


Process p= Runtime.getRuntime().exec("cmd /c  taskkill \\f \\im chromedriver.exe");

 String s;
	System.out.println(p.getOutputStream());
	BufferedReader stdInput = new BufferedReader(new
			InputStreamReader(p.getInputStream()));
	while((s=stdInput.readLine())!=null){
	 System.out.println(s);
	 
	}

 