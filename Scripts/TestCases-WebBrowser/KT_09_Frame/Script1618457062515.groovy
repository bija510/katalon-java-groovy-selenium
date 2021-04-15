import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.media.rtp.GlobalReceptionStats

/****************************************************************************************
 * If we record the Object then frame will be taken care bydefault in Object Repository
 ****************************************************************************************/
//one_way_single_frame()
def one_way_single_frame(){
    WebUI.openBrowser('http://demo.automationtesting.in/Frames.html')
	WebUI.maximizeWindow()
	WebUI.click(findTestObject('DemoAutomationTesting/frame/btn_singleFrame'))
	WebUI.delay(2)
	WebUI.switchToFrame(findTestObject('DemoAutomationTesting/frame/frame_singleBox'), GlobalVariable.largeWaitTime)
	WebUI.setText(findTestObject('DemoAutomationTesting/frame/txt_input'), 'David')
}

second_way_single_frame()
def second_way_single_frame(){
	WebUI.openBrowser('http://demo.automationtesting.in/Frames.html')
	WebUI.maximizeWindow()
	WebUI.setText(findTestObject('DemoAutomationTesting/frame/txt_inside_singleIframe'), 'David')
}
	