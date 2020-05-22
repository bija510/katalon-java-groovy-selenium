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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.KeywordUtil

	def excelFile = 'C:\\Users\\Bijaya Chhetri\\git\\KatalonTest\\Book1.xlsx'
	def util = new library.UTILITY.UtilityExcel()
	def sheetName = 'Sheet1'
	/*******************************************************
	 * READING from excel file outside of katalon
	 *******************************************************/
	
	String[][] arrData = CustomKeywords.'library.UTILITY.UtilityExcel.readExcelData'(excelFile, sheetName)
	
	/*******************************************************
	 * WRITING to the excel file outside of katalon
	 * if the excel box already "Blank" then it will fail
	 *******************************************************/
	
	util.writeExcelData(excelFile, 'Sheet1', 'Blank', 2, 0)
	util.writeExcelData(excelFile, 'Sheet1', 'Blank', 2, 1)
	
	
	
	def profFile = 'C:\\Users\\Bijaya Chhetri\\git\\KatalonTest\\textFile1.properties'
	def testData = new library.UTILITY.UtilitesTextFile(profFile)
	
	/*******************************************************
	 * READING from Properties file outside of katalon
	 *******************************************************/
	def var1 =testData.readFromTextFile('afor')
	def var2 =testData.readFromTextFile('b')
	
	println var1
	println var2
	
	
	/*******************************************************
	 * WRITING to Properties file outside of katalon
	 *******************************************************/
	testData.writeToTextFile('NameFN', 'Bijaya')
	testData.writeToTextFile('NameLN', 'Chhetri')
	//NameFN = Blank
	//NameLN = Blank
	
	
	
	
	
	
	
	
