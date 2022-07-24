import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

/****************************
 * Lunch Notepad application
 * All Work tested 07/23/2022
 ****************************/
	Windows.startApplicationWithTitle('C:\\Windows\\System32\\mspaint.exe', '')
	Windows.click(findWindowsObject('WindowDesktopApps/Notepad/btn_maxmize'))
	Windows.click(findWindowsObject('WindowDesktopApps/Paint/mnu_file'))
	Windows.click(findWindowsObject('WindowDesktopApps/Paint/file_sub_mnu_open'))
	
/****************************
 * Upload File
 ****************************/
	Windows.delay(1)
	String fileUploadPath =  RunConfiguration.getProjectDir() + '/Include/UploadFile/Sample.png'
	fileUploadPath = fileUploadPath.replace('/', '\\')
	
	StringSelection ss = new StringSelection(fileUploadPath);
	//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContents(ss, null);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_DELETE);
	robot.keyRelease(KeyEvent.VK_DELETE);
	Windows.delay(3)
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	Windows.delay(3)
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Windows.delay(3)






