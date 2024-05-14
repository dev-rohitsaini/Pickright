package in.pickright.testcases;

import org.testng.annotations.Test;

import in.pickright.modules.investor.CommanPage;
import in.pickright.modules.investor.LoginPage;

public class LoginTest extends CommanPage{

	CommanPage commanPageObj = new CommanPage();
	@Test
	public static void loginWithNullValues() {
		try {
			commanPageObj.loginpage().loginWithNullValues();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
