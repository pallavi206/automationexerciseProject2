package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Enter_Accounts_Info_Page;
import pages.Homepage;
import pages.Signup_Login_Page;

  public class Test_Case_5 extends BaseClass{
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
	public void verifyNewUserTitle() {
		home.verifyNewUserSignup();
		String act1=sign.verifyNewUserSignup();
		String exp1="New User Signup!";
		Assert.assertEquals(act1, exp1);
	}
	@Test(priority=3)
	public void verifyErrormsg() {
		String act1=sign.enterExistingAccountInfo();
		String exp1="Email Address already exist!";
		Assert.assertEquals(act1, exp1);
	}

	

}
