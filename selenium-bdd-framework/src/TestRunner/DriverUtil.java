package TestRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by tom on 24/02/17.
 */
public class DriverUtil {
    public static long DEFAULT_WAIT = 20;
    protected static WebDriver driver;

    public static WebDriver getDefaultDriver() {
		if (driver != null) {
			return driver;
		}
        //System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "./geckodriver");
        DesiredCapabilities capabilities = null;
		capabilities = DesiredCapabilities.chrome();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        driver = chooseDriver(capabilities);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * By default to web driver will be PhantomJS
     *
     * Override it by passing -DWebDriver=Chrome to the command line arguments
     * @param capabilities
     * @return
     */
    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
		String preferredDriver = System.getProperty("browser", "Chrome");
		boolean headless = System.getProperty("Headless", "true").equals("true");
		
		switch (preferredDriver.toLowerCase()) {
			case "firefox":
				final FirefoxOptions options = new FirefoxOptions();
				if (headless) {
					options.addArguments("--headless");
				}
				capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
				System.out.println("********************* before driver created");
				FirefoxDriver firefox = new FirefoxDriver();
				System.out.println("********************* after driver created");
				ErrorHandler handler = new ErrorHandler();
				handler.setIncludeServerErrors(false);
				firefox.setErrorHandler(handler);
				return firefox;
			default:
				//return new PhantomJSDriver(capabilities);
				ChromeOptions chromeOptions = new ChromeOptions();
				//capabilities.s
				if (headless) {
					chromeOptions.addArguments("-headless", "-safe-mode");
				}
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				final ChromeDriver driver = new ChromeDriver();
				return driver;
		}
    }

    public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector,
                                                            int seconds) {
        By selection = By.cssSelector(selector);
        return (new WebDriverWait(driver, seconds)).until( // ensure element is visible!
                ExpectedConditions.visibilityOfElementLocated(selection));
    }

	public static void closeDriver() {
		if (driver != null) {
			try {
				driver.close();
				driver.quit(); // fails in current geckodriver! TODO: Fixme
			} catch (NoSuchMethodError nsme) { // in case quit fails
			} catch (NoSuchSessionException nsse) { // in case close fails
			} catch (SessionNotCreatedException snce) {} // in case close fails
			driver = null;
		}
	}
}
