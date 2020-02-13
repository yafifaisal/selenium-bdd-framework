package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import Methods.SelectElementByType;
import TestRunner.DriverUtil;
import Methods.TestCaseFailed;

public class StepDefinition extends SelectElementByType {

	protected WebDriver driver = DriverUtil.getDefaultDriver();
	private WebElement element = null;
	// Navigation Steps

	// Step to navigate to specified URL
	@Then("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link) {
		driver.get(link);
	}

	// step to check element text
	@Then("^element having (.+) \"([^\"]*)\" should have text as \"(.*?)\"$")
	public void check_element_text(String type, String accessName, String value, boolean testCase) throws TestCaseFailed {
		element = driver.findElement(getelementbytype(type, accessName));
		String elementText = element.getText();

		if (testCase) {
			if (!elementText.equals(value))
				throw new TestCaseFailed("Text Not Matched");
		} else {
			if (elementText.equals(value))
				throw new TestCaseFailed("Text Matched");
		}

	}

	// enter text into input field steps
	@Then("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void enter_text(String text, String type, String accessName) {
		driver.findElement(getelementbytype(type, accessName)).sendKeys(text);
	}

	// click on web element
	@Then("^I click on element having (.+) \"(.*?)\"$")
	public void click(String type, String accessName) {
		driver.findElement(getelementbytype(type, accessName)).click();;
	}

}
