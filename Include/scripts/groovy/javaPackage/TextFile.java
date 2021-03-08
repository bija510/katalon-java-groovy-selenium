package javaPackage;

//Unused import
//import internal.GlobalVariable;
//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
//import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;
//
//import com.kms.katalon.core.annotation.Keyword;
//import com.kms.katalon.core.checkpoint.Checkpoint;
//import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
//import com.kms.katalon.core.model.FailureHandling;
//import com.kms.katalon.core.testcase.TestCase;
//import com.kms.katalon.core.testdata.TestData;
//import com.kms.katalon.core.testobject.TestObject;
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
//import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;

//Additional Library
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextFile {
	
	public static String filePath;
	
	public static String getFilePath(){
		return filePath;
	}
	
	public static void setFilePath(String filePath){
		TextFile.filePath =filePath;
	
	}
	
	
	public static void main(String a[]){
		LocalDateTime now  = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmmss");
		String FormatDateTime = now.format(format);
		String dataDir = "C:\\Users\\Bijaya Chhetri\\git\\KatalonTest\\Include\\scripts\\groovy\\javaPackage" + FormatDateTime +".txt" ;
		try{
			
			TextFile.setFilePath(dataDir);
			for(int i =0; i<3; i++){
				TextFile.append("L1234" + i);
			}
		}catch(Exception e){
			System.out.println("IOexception:" + e.getMessage());
		}
	}
		
		public static void append(String msg) throws Exception{
			FileWriter fw = new FileWriter(filePath, true);
			fw.write(msg + "\n");
			fw.close();
		}
	
	
	
	
	

}