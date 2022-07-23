import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil

/****************************************************************************************
 * It will start the driver if it is not already started
https://stackoverflow.com/questions/10685893/run-exe-file-in-java-from-file-location
****************************************************************************************/
boolean anyCmdProgramOpened = isAnyCmdProgramOpened()
System.out.println('isOpened = ' + anyCmdProgramOpened)


if( ! anyCmdProgramOpened) {
	String batFilePath = RunConfiguration.getProjectDir()+"/Start WinAppDriver.bat"
	KeywordUtil.logInfo('.Bat file path = ' +batFilePath)
	runtimeProcess = Runtime.getRuntime().exec("cmd /c start /min cmd.exe /C\""+ batFilePath +"\"");
	
	// Start without minimize
	// runtimeProcess = Runtime.getRuntime().exec("cmd /c start cmd.exe /C\""+"C:\\Users\\bchhetri\\Git\\DemTech_Automation\\Start WinAppDriver.bat"+"\"");
	int processComplete = runtimeProcess.waitFor();

}

/***************************************
 * Check if the CMD.exe is open or not
 ***************************************/

static boolean isAnyCmdProgramOpened() {
	Process p
	
	try {
		p = Runtime.getRuntime().exec((System.getenv('windir') + '\\system32\\') + 'tasklist.exe')
		String line
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))
		while ((line = input.readLine()) != null) {
			System.out.println(line)
			if (line.startsWith('cmd.exe')) {
				return true
				break
			}
		}
	}
	catch (IOException e) {
		e.printStackTrace()
	}
	return false
}