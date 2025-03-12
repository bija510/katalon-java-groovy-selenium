import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
//for selenium
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By;

//Additional import for Json
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import groovy.json.*


//Read
String fileName = RunConfiguration.getProjectDir() + "/Data Files All/JsonFile.json"
def slurper = new JsonSlurper()
Map parsedData = slurper.parse(new File(fileName))

//print Parse data
println "firstName = " + parsedData.firstName
println "city = " + parsedData.address.city
println "Is US Citizen = " + parsedData.get("isUSCitizen")

if (parsedData.phoneNumbers[1].type.toString().equalsIgnoreCase("cell")){
	println "cell Phone = " + parsedData.phoneNumbers[1].number
	
}else{
	println "Home Phone = " + parsedData.phoneNumbers[0].number
}

//Write
parsedData.phoneNumbers[1]."type" = "Cell" //To set a Key Value, put the Key name inside Quote
def json_str = JsonOutput.toJson(parsedData)
def json_beauty = JsonOutput.prettyPrint(json_str)
File file = new File(fileName)
file.write(json_beauty)// no need to close the file because groovy takes care for you



