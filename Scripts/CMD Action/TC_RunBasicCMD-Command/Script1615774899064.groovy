

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
// Process runtime = Runtime.getRuntime().exec("cmd /c start notepad++.exe");


/********************************************
* This will open the CHROME BROWSER in Window
* and open any URL
*********************************************/
//Process runtime = Runtime.getRuntime().exec("cmd /c start chrome");
//Process runtime = Runtime.getRuntime().exec("cmd /c start chrome https://www.facebook.com");











