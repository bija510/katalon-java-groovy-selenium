package cucumber
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class FB_signup_SD {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I want to write a step with (.*)")
	def I_want_to_write_a_step_with_name(String nameFN) {
		WebUI.openBrowser('http://demo.automationtesting.in/Register.html')
		WebUI.setText(findTestObject('DemoAutomationTesting/txt_FirstName'), nameFN)
	}

	@When("I check for the (.*) in step") //(\\d+)
	def I_check_for_the_value_in_step(String nameLN) {
		WebUI.setText(findTestObject('DemoAutomationTesting/txt_LastName'), nameLN)
	}

	@And("I verify the (.*) in step")
	def I_verify_the_status_in_step(String address) {
		WebUI.setText(findTestObject('DemoAutomationTesting/txt_Address'), address)
	}


	@Then("Close browser")
	def Then_Close_browser(){
		WebUI.closeBrowser()

	}
}

