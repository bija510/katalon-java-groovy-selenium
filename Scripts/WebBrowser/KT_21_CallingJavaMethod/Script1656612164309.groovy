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
//Additional import for the java 
import javaPackage.Javaclass;


/**************************************************************************************
 * This is how we use java class in katalon
 * Class name = JavaClass
 * package name = javaPackage
 * and we need this import from Include==>scripts==>groovy==>javaPackage==>Javaclass.java
 * import javaPackage.Javaclass;
 ****************************************************************************************/


Javaclass.method1("apple cost is ", 100);

Javaclass.method2("Ball cost ", 250);

for(int i=0; i<10; i++){
methodfromHere(i + " Nepal is in Asia ", 100 )

}


def methodfromHere(to, a){
	
	println(to + a)
}










