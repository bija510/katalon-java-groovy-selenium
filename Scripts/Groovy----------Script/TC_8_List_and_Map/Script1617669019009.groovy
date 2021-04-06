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




//map_demo()

def map_demo(){
	def maps = [:]
	maps << [a : 'apple']
	maps << [b : 'ball']
	maps.put('c', 'cat')
	
	for(def map : maps){
		println "==>" +  map.value
	}
	
	for (def map: maps){
		println "==>" + map.key
	}
	
	def vehs = [veh1 : 'car', veh2:'truck', veh3: 'suv']
	println vehs.keySet() //Result- [veh1, veh2, veh3]

/***********************
 * each demo in groovey	
 **********************/
	vehs.each{
		veh -> 
		println "each demo=>"+veh.key
	}
	
}


list_demo()


def list_demo(){
	def list = [1, 2,3,4,5]
	list.add("apple")
	list.add(1)
	list.add(2.0)
	
	for (def li : list){
		println li
	  }
	
	
	list.forEach{
		println it
		}
	}
	
	








