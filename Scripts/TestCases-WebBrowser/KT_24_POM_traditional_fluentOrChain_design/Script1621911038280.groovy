import internal.GlobalVariable
import pages.HomePage
import pages.LoginPage


/*####################################################################
 * Each and every design/approach has its own PROS and CONS.
 * In some Project 1 can fit & in some other project other can fix
 ####################################################################*/

/********************************************
 [POM] Page Objects Design with traditional approach.
*********************************************/
	def loginPage = new LoginPage()
	loginPage.openUrl(GlobalVariable.Url)
	loginPage.enterUserName(GlobalVariable.userName)
	loginPage.enterPassword(GlobalVariable.password)
	loginPage.clickLoginBtn()


	
/*************************************************************
 [POM] Page Objects Design In Fluent Style
 I could call the entry points ‘using’ and chain the methods 
 To create a fluent style code in my tests to test my pages.
 *************************************************************/
	HomePage.using().selectAdminTab("Time")
				.clickMenuBtn()
				.clickLogoutBtn()

