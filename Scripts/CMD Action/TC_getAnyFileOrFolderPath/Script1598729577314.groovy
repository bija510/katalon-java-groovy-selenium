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
//Additional Imports for this
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

	/*****************************************************************************
	  Process p= Runtime.getRuntime().exec("cmd /c netstat");
	  echo %userprofile%\Downloads ==> to print the path of the downloads folder
	  Youtube search:- Java Run operating system commands >>-->Channel:-Easy Tech
	  Refrence:- https://www.youtube.com/watch?v=moeoyqpS4KI&list=PLfg64f7WCzG4YIIMbNQZtpWX56V_T7xHn&index=15&t=0s
	*******************************************************************************/
	Process p= Runtime.getRuntime().exec("cmd /c echo %userprofile%\\Downloads");
	
	String s;
	   System.out.println(p.getOutputStream());
	   BufferedReader stdInput = new BufferedReader(new
			   InputStreamReader(p.getInputStream()));
	   while((s=stdInput.readLine())!=null){
		System.out.println(s);
		
	   }
