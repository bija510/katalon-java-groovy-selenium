import com.kms.katalon.core.configuration.RunConfiguration

/************************************************************************
1. To Run any cmd command from Java just try in cmd and copy same command &
2. Put inside after cdm/c
3. Process runtime = Runtime.getRuntime().exec("cmd /c ");
4. To create a folder=============> C:\Users\BC> cd Desktop & C:\Users\BC\Desktop> mkdir cmdTestFolder
5. To Delete folder===============> rmdir /s cmdTestFolder if name has space then put name inside ""
6. To go to parent folder in cmd==> cd ../
7. To go to grandParent in cmd====> cd ../../
8. To get auto suggest============> cd des + tab ==> will give autoComplete 
9. To Create empty file any type==> type nul > hello.txt or type nul > hello.png ....
10.TO crate file with text in it==> echo enter your text here > filename.txt
11.To crate file of certain bite==> fsutil file createnew AAAename.txt 1000
12.To Shift+Delete any file=======> del AAAename.txt
**************************************************************************
  This will open the NOTEPAD++ in Window
*************************************************************************/

open_anyExeFile_or_browser()
def open_anyExeFile_or_browser(){
	Process runtime = Runtime.getRuntime().exec("cmd /c start notepad++.exe");
	Process runtime = Runtime.getRuntime().exec("cmd /c start chrome");
	Process runtime = Runtime.getRuntime().exec("cmd /c start chrome https://www.facebook.com");
}


/*****************************************************************************
 Process p= Runtime.getRuntime().exec("cmd /c netstat");
 echo %userprofile%\Downloads ==> to print the path of the downloads folder
 Youtube search:- Java Run operating system commands >>-->Channel:-Easy Tech
 Refrence:- https://www.youtube.com/watch?v=moeoyqpS4KI&list=PLfg64f7WCzG4YIIMbNQZtpWX56V_T7xHn&index=15&t=0s
*******************************************************************************/
test_getAnyFileOrFolderPath()
def test_getAnyFileOrFolderPath(){
	Process p= Runtime.getRuntime().exec("cmd /c echo %userprofile%\\Downloads");
	String s;
	   System.out.println(p.getOutputStream());
	   BufferedReader stdInput = new BufferedReader(new
			   InputStreamReader(p.getInputStream()));
	   while((s=stdInput.readLine())!=null){
		System.out.println(s);
		
	   }
}

deleteFile()
def deleteFile(){
	/*******************************************************
	 * To Delete the file Run this first
	 * Test Cases/DataDriverTesting/TC_WriteReadTextFile
	********************************************************/	
	CustomKeywords.'com.qa.utils.CommandLine.executeCmdCommand'("del /Q \"" + RunConfiguration.getProjectDir() + "/Data Files/TextDataFolder" + "\"")
	
}








