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
import org.openqa.selenium.Keys as Keys

/***********************************************************************************************************************
 1. No need to start the appium
 2. Need to download appium through Terminal ['npm install -g appium' , 'appium --version']
 3. Need to match the browser version inside emulator Chrome & the Chromedriver in this location
 4. C:\Users\Bijaya Chhetri\AppData\Roaming\npm\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win
 5. Place to download chromedriver ===> https://sites.google.com/a/chromium.org/chromedriver/downloads
 6. Chromedriver is same for ["-mobile chrome" and the "-window chrome"]
 7. Terminal how to see List of emulator devices:- adb devices
 ************************************************************************************************************************/

WebUI.openBrowser("https://opensource-demo.orangehrmlive.com/")