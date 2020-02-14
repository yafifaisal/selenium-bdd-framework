package Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Methods.SelectElementByType;
import TestRunner.DriverUtil;
import Methods.TestCaseFailed;

public class StepDefinition extends SelectElementByType {

	protected WebDriver driver = DriverUtil.getDefaultDriver();
	private WebElement element = null;

	/**
	 * Method to open link
	 * 
	 * @param url : String : URL for navigation
	 */
	public void navigateTo(String url) {
		driver.get(url);
	}

	/**
	 * Method to check element text
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param actualValue : String : Expected element text
	 * @param accessName  : String : Locator value
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void checkElementText(String accessType, String actualValue, String accessName, boolean testCase)
			throws TestCaseFailed {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		String elementText = element.getText();

		if (testCase) {
			if (!elementText.equals(actualValue))
				throw new TestCaseFailed("Text Not Matched");
		} else {
			if (elementText.equals(actualValue))
				throw new TestCaseFailed("Text Matched");
		}

	}

	/** Method to enter text into text field
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
	 * @param text : String : Text value to enter in field
	   @param accessName : String : Locator value
	 */
	public void enterText(String accessType,String text,String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		element.sendKeys(text);
	}

	/** Method to click on an element
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void click(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		element.click();
	}

}
