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

	//def excelFile = 'C:\\Users\\Bijaya Chhetri\\git\\KatalonTest\\Data Files All\\Book1.xlsx'
	def excelFile = System.getProperty("user.dir")+"\\Data Files All\\Book1.xlsx"
	
	def sheetName = 'Sheet1'
	/*******************************************************
	 * READING from excel file outside of katalon
	 *******************************************************/
	
	String[][] arrData = CustomKeywords.'com.qa.utils.ExcelFile.readExcelData'(excelFile, sheetName)
	
	/*******************************************************
	 * WRITING to the excel file outside of katalon
	 * While writing excel should be close
	 * Only read open excel don't matter
	 * if the excel box already "Blank" then it will fail
	 *******************************************************/
	CustomKeywords.'com.qa.utils.ExcelFile.writeExcelData'(excelFile, 'Sheet1', 'test54un', 2, 0)
	CustomKeywords.'com.qa.utils.ExcelFile.writeExcelData'(excelFile, 'Sheet1', 'test54pw', 2, 1)
	     
	
//	//or by another way with 3 line
//	def util = new library.UTILITY.UtilityExcel()
//	util.writeExcelData(excelFile, 'Sheet1', 'Blank', 2, 0)
//	util.writeExcelData(excelFile, 'Sheet1', 'Blank', 2, 1)
	
	
	
	//def profFile = 'C:\\Users\\Bijaya Chhetri\\git\\KatalonTest\\Data Files All\\textFile1.properties'
	def profFile = System.getProperty("user.dir")+"\\Data Files All\\textFile1.properties"
	def testData = new com.qa.utils.TextFile(profFile)
	
	/*******************************************************
	 * READING from Properties file outside of katalon
	 * Example:-
	 * testdata=Apple [NO SPACE afrer =]
	 *******************************************************/
	def var1 =testData.readFromTextFile('afor')
	def var2 =testData.readFromTextFile('b')
	
	println var1
	println var2
	
	
	/*******************************************************
	 * WRITING to Properties file outside of katalon
	 *******************************************************/
	testData.writeToTextFile('NameFN', 'subi')
	testData.writeToTextFile('NameLN', 'Joshi')
	//NameFN = Blank
	//NameLN = Blank
	
	
	
	
	
	
	
	
