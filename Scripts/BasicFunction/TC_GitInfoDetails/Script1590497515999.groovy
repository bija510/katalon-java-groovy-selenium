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

/*******************************************************************************************************
 * Git need to download Locally
 * 
 * Need to create the git Account in GitHUb
 * 
 * Clone Project==>it copy from github and paste in the katalon
 * 
 * Show History==>it will show the history of commit that you made with "Proper COMMENT"
 * 
 * Commit==> it will show the file which is new and which are modified so that we can push 
 * 
 * Push==>it will push final to Remote github desiredBranch
 * 
 * Pull==>it will pull if there are new update in the gitProject final
 * 
 * Fetch==>it will show the update in git so that we can decide or can see what change we are Pulling final
 * 
 * Preference==>Team==>Git==>Ignore Resources and other setting
 * 
 * Preference==>Team==>Git==>Confugration for project locally and Remotely and other setting
 * 
 * Git merge===> it will merge the side branch(david) with master usually team lead do code review and merge 
 * 
 * Git request pull request ==>
 ************************************************************************************************************/


