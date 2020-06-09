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


/*Methods
1. add() = Allows you to append the new value to the end of this List.
2. contains() = Returns true if this List contains a certain value.
3. get() = Returns the element at the definite position
4. isEmpty() = Returns true value if List contains no elements
5. minus() = This command allows you to create a new List composed of the elements of the original excluding those which are specified in the collection.
6.plus() = Allows you to create a new List composed of the elements of the original together along with mentioned in the collection.
7. pop() = Removes the last item from the List
8. remove() = Removes the element at the specific position
9. reverse() = Create a new List which reverses the elements of the original List
10. size() = Allow finding some elements
11. sort() = Returns a sorted copy
*/
//Consider the following example

def y = ["Guru99", "is", "Best", "for", "Groovy"]
println y
y.add("Learning")
println(y.contains("is"))
println(y.get(2))
println(y.pop())
/**************************************************
Output
[Guru99, is, Best, for, Groovy]
true
Best
Learning
Groovy Maps
A Map Groovy is a collection of Key Value Pairs
***************************************************/

//This command returns a collection view of the values.
//Groovy Example:

def z = [fName:'Jen', lName:'Cruise', sex:'F']
print z.get("fName")

//Output==>Jen
