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


/****************************************************************************************************************
 * What is a Groovy Script?
 * 2003: Developed by Bob McWhirter & James Strachan
 *APACHE GROOVY is an object oriented and Java syntax compatible programming language built for the Java platform.
 *****************************************************************************************************************/

/**************************************************************************************************
Groovy Hello World Example
Consider we want to print a simple string "Hello World" in Java. The code to achieve this would be

public class Demo {
	public static void main(String args[]) {
		System.out.println("Hello World");
	}
}
****************************************************************************************************/
		
		//In groovy no need of this just one line is sufficent
        //NO neeed to declare class and Method 
		println "Hello World."

		
/*****************************************************************
 * While Declaring Variable in Groovy
 * SomeWhat similar to the Python
 * No need to Write int , string or anything 
 *******************************************************************/
		
	def b = 'No need to Write int , string or anything to declare Variable'	
	println b
	
	x = 10
		println x //or println('x')
		
	y = 2.50
		println y
		
	x = 'apple'
		println x
		
	x= ['appple','ball','cat']
		println x
		
	x= ['appple','ball','cat']as String[]
		println x[1]
// or We can do this
		String[] z =['car','bike','plane']
		println z[2]

/*********************************************************
	In Groovy, you can create multiline strings. Using """
*********************************************************/
		def x = """a
                   for
                   Apple"""
		println x
		
	
		
		
		
		
		
 