package library.UTILITY
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import org.testng.Assert
import org.testng.asserts.SoftAssert
import org.openqa.selenium.JavascriptExecutor

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.util.Date

import org.apache.commons.io.FileUtils
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import java.lang.String
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import java.text.SimpleDateFormat
import java.util.Calendar
import java.text.ParseException

class UtilityExcel {

	/********************************************************
	 import java.io.FileInputStream
	 import java.io.FileNotFoundException
	 import java.io.IOException
	 import java.util.Date
	 import org.apache.poi.ss.usermodel.Cell
	 import org.apache.poi.ss.usermodel.Row
	 import org.apache.poi.xssf.usermodel.XSSFCell
	 import org.apache.poi.xssf.usermodel.XSSFRow
	 import org.apache.poi.xssf.usermodel.XSSFSheet
	 import org.apache.poi.xssf.usermodel.XSSFWorkbook
	 import org.apache.poi.xssf.usermodel.XSSFCellStyle
	 import java.lang.String
	 **********************************************************/

	
	def String[][] readExcelData(def excelFile, def sheetName){
		FileInputStream file = new FileInputStream (new File(excelFile))
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rowCount =sheet.getLastRowNum()
		int colCount =sheet.getRow(0).getLastCellNum()
		String[][] arrData=new String[rowCount][colCount]

		for(int i=0; i<rowCount; i++){
			for(int j=0; j<colCount; j++){

				arrData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue()
			}
		}

		return arrData
		file.close()
	}


	/**********************************************
	 import java.io.FileInputStream;
	 import java.io.FileNotFoundException;
	 import java.io.IOException;
	 import java.util.Date;
	 import org.apache.poi.xssf.usermodel.XSSFCell;
	 import org.apache.poi.xssf.usermodel.XSSFRow;
	 import org.apache.poi.xssf.usermodel.XSSFSheet;
	 import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	 import java.lang.String
	 *****************************************************/

	def writeExcelData(def excelFile, def sheetName, def val, int row, int col){
		FileInputStream file = new FileInputStream (new File(excelFile))
		XSSFWorkbook workbook = new XSSFWorkbook(file)
		XSSFSheet sheet = workbook.getSheet(sheetName)

		'Write data to excel'
		sheet.getRow(row).createCell(col).setCellValue(val)
		file.close()

		FileOutputStream outFile =new FileOutputStream(new File(excelFile));
		workbook.write(outFile);
		outFile.close();
	}

	/***************************************************************************************************************
	 Read from Text file
	 Dependency
	 import org.apache.commons.io.fileUtils
	 import java.io.FileWriter
	 import java.io.IOException
	 https://forum.katalon.com/t/how-to-create-a-katalon-method-keyword-for-writing-to-a-text-file-with-java/28807
	 *****************************************************************************************************************/	

	def readFromtextFile(def fileName){
		File file = new File(fileName)
		String text = FileUtils.readFileToString(file)
	}


	def appendTextFile(String filePath, boolean append, String text){
		FileWriter fw = new FileWriter(filePath, append);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(text)
		pw.newLine()
		pw.close()
	}





	/*	@Keyword
	 public static void drawBorder(WebElement element, WebDriver driver){
	 JavascriptExecutor js = ((JavascriptExecutor) driver);
	 js.executeScript("arguments[0].style.border='3px solid red'", element);
	 }
	 */
}


