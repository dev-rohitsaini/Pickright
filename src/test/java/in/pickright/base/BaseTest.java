package in.pickright.base;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import in.pickright.driver.DriverManager;

public class BaseTest {

	@Parameters("BROWSER")
	@BeforeTest
	public static void browserSetUp(@Optional("chrome") String browser) {

		// call driver manager
		try {
			DriverManager.setUp(browser);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//@AfterTest
	public static void browserQuit() {
		DriverManager.tearDown();
	}

}
