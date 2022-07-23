import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.windows.driver.WindowsDriverFactory
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.windows.keyword.helper.WindowsActionHelper

import internal.GlobalVariable
import utilites.Utils


Windows.startApplicationWithTitle('C:\\Windows\\System32\\notepad.exe', '')

String screenshotLocation = ((GlobalVariable.gScreenshotDir + GlobalVariable.gTestCaseId) +'_Failed_') + Utils.get5DigitTimeStamp()+ '.png'
WindowsActionHelper.create(WindowsDriverFactory.getWindowsSession()).takeScreenshot(screenshotLocation)


