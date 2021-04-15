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
import pages.*
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import groovy.json.*

String filePath = RunConfiguration.getProjectDir() + "/Data Files All/JsonPOM.json"
def slurper = new JsonSlurper()
Map data = slurper.parse(new File(filePath))


LoginPage loginPage = new LoginPage()
	loginPage.openUrl(GlobalVariable.Url)
	loginPage.enterUserName(GlobalVariable.userName)
	loginPage.enterPassword(GlobalVariable.password)
	loginPage.clickLoginBtn()
	WebUI.verifyTextPresent(data.welcomeMsg, false)
	
HomePage homePage = new HomePage()
	homePage.selectAdminTab(data.adminTab)
	homePage.clickMenuBtn()
	homePage.clickLogoutBtn()
	WebUI.verifyTextPresent(data.logoutValidationMsg, false)
	
