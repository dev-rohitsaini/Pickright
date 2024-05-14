package in.pickright.modules.investor;

public class CommanPage {

	private LoginPage loginpage;
	
	public LoginPage getLoginPage() {
		if(loginpage == null) {
			return new LoginPage();
		}
		return loginpage;
	}
}
