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

/**************************************************
  public class Demo {
	public static void main(String args[]) {
		for (int x = 0; x <= 5; x++) {
			System.out.println(x);
		}
	}
}
Output ==> 0 1 2 3 4 i Diff Line
************************************************************/
					0.upto(4) {println "$it"}

//You get the same output as above. $it is a closure that gives the value of the current loop.
//Consider the following code

					2.upto(4) {println "$it"}

/***************************
 output==>2 3 4 in diff line
*****************************/
					5.times{println "$it"}
					
					
					

//Consider, you want to print 0,2,4,6 with for loop in Java
/******************************************
 public class Demo {
	public static void main(String args[]) {
		for (int x = 0; x <= 5; x=x+2) {
			System.out.println(x);
		}
	}
}
Output: ===>0 2 4 6 in diff line
You can use the step method for the same
******************************************/

						0.step(7,2){println "$it"}
						
/******************************************
If Else, Nested if ,Switch Same as Java
*******************************************/			
					
						
						
						
						
						