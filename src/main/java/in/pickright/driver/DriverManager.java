package in.pickright.driver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

public class DriverManager {

  

    public static void setUp(@Optional("chrome") String browser) throws IOException {

        // setup driver here
        BrowserFactory.getBrowser(browser);
        // navigate to browser factory - not created yet, will do once one journey will
        // get setup

    }
    
    public static WebDriver getDriver() {
    	return BrowserFactory.getDriver();
    }

    public static void tearDown() {
        BrowserFactory.quitBrowser();
    }
}
