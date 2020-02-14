package StepDefinition;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import TestRunner.DriverUtil;
import Methods.TestCaseFailed;
import Methods.BaseTest;

public class PreDefinedStepDefinition implements BaseTest {

	protected WebDriver driver = DriverUtil.getDefaultDriver();
	// Navigation Steps

	// Step to navigate to specified URL
	@Given("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link) {
		stepDef.navigateTo(link);
	}

	// step to check element text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
	public void check_element_text(String type, String accessName, String present, String value) throws TestCaseFailed {
		stepDef.checkElementText(type, accessName, value, present.isEmpty());

	}

	// enter text into input field steps
	@When("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void enter_text(String text, String type, String accessName) {
		stepDef.enterText(type, text, accessName);
	}

	// click on web element
	@And("^I click on element having (.+) \"(.*?)\"$")
	public void click(String type, String accessName) {
		stepDef.click(type, accessName);
	}

}
