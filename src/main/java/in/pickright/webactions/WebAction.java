package in.pickright.webactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import in.pickright.driver.DriverManager;
import in.pickright.utils.LogUtils;
import io.qameta.allure.Step;
import in.pickright.constants.Constants;

public class WebAction {

	@Step("click on element")
	public static void clickonelement(By by) {
		waitForElementVisible(by).click();

		 LogUtils.info("Clicked on the element " + by.toString());

//		if (ExtentTestManager.getExtentTest() != null) {
//			ExtentReportManager.pass("Clicked on the element " + by.toString());
//		}
//		AllureManager.saveTextLog("Clicked on the element " + by.toString());

	}

	public static void smartWait() {
		if (Constants.ACTIVE_PAGE_LOADED.trim().toLowerCase().equals("true")) {
			waitForPageLoaded();
		}
		sleep(Constants.WAIT_SLEEP_STEP);
	}

	public static void waitForPageLoaded() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
				Duration.ofSeconds(Constants.WAIT_PAGE_LOADED), Duration.ofMillis(500));
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// wait for JavaScript to loaded
		// ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor)
		// DriverManager.getDriver()).executeScript("return
		// document.readyState").toString().equals("complete");

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		// Get JS is Ready
		boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

		// Wait JavaScript until it is Ready!
		if (!jsReady) {

			 LogUtils.info("JavaScript in NOT Ready!");
			// Wait for JavaScript to load
			try {
				wait.until(jsLoad);
			} catch (Throwable error) {
				error.printStackTrace();
				Assert.fail("Timeout waiting for page load. (" + Constants.WAIT_PAGE_LOADED + "s)");
			}
		}
	}

	public static WebElement waitForElementVisible(By by) {
		smartWait();
		waitForElementPresent(by);

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(Constants.WAIT_EXPLICIT), Duration.ofMillis(500));
			boolean check = isElementVisible(by, 1);
			if (check == true) {
				return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			} else {
				scrollToElementAtBottom(by);
				return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}
		} catch (Throwable error) {
			 LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
			Assert.fail("Timeout waiting for the element Visible. " + by.toString());
		}
		return null;
	}

	@Step("Verify element visible {0}")
	public static boolean isElementVisible(By by, int timeout) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			// LogUtils.info("Verify element visible " + by);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static WebElement waitForElementPresent(By by) {
		smartWait();

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(Constants.WAIT_EXPLICIT), Duration.ofMillis(500));
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Throwable error) {
			 LogUtils.error("Element not exist. " + by.toString());
			Assert.fail("Element not exist. " + by.toString());
		}
		return null;
	}

	@Step("Scroll to element {0}")
	public static void scrollToElementAtBottom(By by) {
		smartWait();

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
		LogUtils.info("Scroll to element " + by);
	}

	   public static WebElement getWebElement(By by) {
	        return DriverManager.getDriver().findElement(by);
	    }
	
	public static void sleep(double second) {
		try {
			Thread.sleep((long) (second * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
