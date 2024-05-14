package in.pickright.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;

import in.pickright.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	// Browser
	public static WebDriver driver;
	private static String browser = Constants.BROWSER;
	private static final String isRemote = Constants.IS_REMOTE;
	private static final String url = Constants.URL;

	// function1
	public static void getBrowser(@Optional("chrome") String cmdBrowser) {
		browser = (cmdBrowser != null && !cmdBrowser.isEmpty()) ? cmdBrowser : browser;

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(getChromeOptions());
			driver.get(url);

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(getEdgeOptions());
			driver.get(url);

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(getFireFoxOptions());
			driver.get(url);
		}
	}

	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		if (Boolean.parseBoolean(isRemote))
			options.addArguments("--headless=new");

		return options;
	}

	public static EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		if (Boolean.parseBoolean(isRemote))
			options.addArguments("--headless=new");

		return options;
	}

	public static FirefoxOptions getFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		if (Boolean.parseBoolean(isRemote))
			options.addArguments("--headless=new");

		return options;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	// quit browser
	public static void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

}
