package in.pickright.modules.investor;

import org.openqa.selenium.By;
import in.pickright.webactions.WebAction;

public class LoginPage {
		
	private static By loginButton = By.xpath("//button[contains(text(),'Login')]");
	
	public void InvestorLogin() {
		try {
			WebAction.clickonelement(loginButton);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
