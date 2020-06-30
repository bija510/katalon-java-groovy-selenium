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

import org.apache.commons.io.FileUtils
import java.io.FileInputStream
import java.io.IOException
import java.util.Date
import java.lang.String

import java.nio.file.Files
import java.nio.file.Paths
import java.util.List
import java.nio.charset.Charset




class UtilitesTextFile {
	private String txtFile
	public UtilitesTextFile(String txtFile) {
		this.txtFile = txtFile
	}
	@Keyword
	public String readFromTextFile(String key)throws Exception {
		List<List<String>> outerList = new ArrayList<List<String>>()
		List<String> innerList = new ArrayList<String>()

		String[] arrLines = null

		try{
			List<String> allLines = Files.readAllLines(Paths.get(txtFile))
			int index = -1

			for(int i =0; i<allLines.size(); i++){
				if(!(allLines.get(i).toString().contains("#"))){

					if(allLines.get(i).toString().contains(key)){
						arrLines = allLines.get(i).toString().split("=")
						return arrLines[1]
					}
				}
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
		}
	}

	@Keyword
	public writeToTextFile(String key, String val) throws Exception{
		String[] arrLines =null

		try{

			List<String> allLines = Files.readAllLines(Paths.get(txtFile));
			int index = -1

			for(int i =0; i<allLines.size(); i++){
				if(!(allLines.get(i).toString().contains("#"))){

					if(allLines.get(i).toString().contains(key)){
						arrLines = allLines.get(i).toString().split("=")
						arrLines[1] =val
						allLines.set(i, arrLines[0].trim() +'='+arrLines[1].trim())
						break
					}
				}
			}
			Files.write(Paths.get(txtFile), allLines);
		}catch (IOException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
		}
	}

	@Keyword
	def append(String msg) throws Exception{
		FileWriter fw = new FileWriter(txtFile, true);
		fw.write(msg + "\n");
		fw.close()
	}
}








































