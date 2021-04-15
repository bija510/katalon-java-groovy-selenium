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

/******************************************************************************
 * Available Device: Nexus 5 & Google Pixal =Both Work No update Need for Nexus
 * Bijayaemulator
 * Nexus_5X_API_29_x86
 * Driver location:- C:\Users\Bijaya Chhetri\AppData\Roaming\npm\node_modules\appium\node_modules\appium-chromedriver\chromedriver\win
 ******************************************************************************/


Mobile.startApplication('../katalon-java-groovy-selenium/Data Files All/A-MobileFile/ApiDemos.apk', true)

Mobile.tap(findTestObject('MobileObject/android.widget.TextView - Views'), 30)

Mobile.tap(findTestObject('MobileObject/android.widget.TextView - Gallery'), 30)

Mobile.tap(findTestObject('MobileObject/android.widget.TextView - 1. Photos'), 30)

Mobile.tap(findTestObject('MobileObject/android.widget.ImageView'), 30)

Mobile.pressBack()

Mobile.tap(findTestObject('MobileObject/android.widget.TextView - 2. People'), 30)

Mobile.getText(findTestObject('MobileObject/android.widget.Button - Testing'), 30)

Mobile.closeApplication()

