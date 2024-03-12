package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Enter_Accounts_Info_Page;
import pages.Homepage;
import pages.Signup_Login_Page;

  public class Test_Case_3 extends BaseClass{
	Homepage home = new Homepage(driver);
	Signup_Login_Page sign= new Signup_Login_Page(driver);
	Enter_Accounts_Info_Page accinfo= new Enter_Accounts_Info_Page(driver);
	
	@Test(priority=1)
	public void verifyTitle() {
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	@Test(priority=2)
	public void verifyLoggedInText() {
		home.verifyNewUserSignup();
		String act= sign.loginText();
		String exp="Login to your account";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=3)
	public void verifyInavlidtextMessage() {
		String act1= sign.inavlidtextMessage();
		String exp1="Your email or password is incorrect!";
		Assert.assertEquals(act1, exp1);
	}


}
