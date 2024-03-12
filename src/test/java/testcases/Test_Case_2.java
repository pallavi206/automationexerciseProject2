package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Enter_Accounts_Info_Page;
import pages.Homepage;
import pages.Signup_Login_Page;

  public class Test_Case_2 extends BaseClass{
	Homepage home = new Homepage(driver);
	Signup_Login_Page sign= new Signup_Login_Page(driver);
	Enter_Accounts_Info_Page accinfo= new Enter_Accounts_Info_Page(driver);
	
	@Test(priority=1)
	public void verifyUrl() {
		String acturl=home.verifyHomepage(); 
		String expurl="https://automationexercise.com/";
		Assert.assertEquals(acturl, expurl);
		
	}

	@Test(priority=2)
	public void verifyTitle() {
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	
	@Test(priority=3)
	public void verifyLoggedInText() {
		home.verifyNewUserSignup();
		String act= sign.loginText();
		String exp="Login to your account";
		Assert.assertEquals(act, exp);
	}

	@Test(priority=4)
	public void login() throws InterruptedException {
		 sign.loggedinUsernameText();
		
	}
	@Test(priority=5)
	public void verifyLoggedinUsernameText() throws InterruptedException{
		String act1= accinfo.loggedin();
		String exp1= "Logged in as pallavi";
		Assert.assertEquals(act1, exp1);
	}
	@Test(priority=6)
	public void verifyDeleteText() throws InterruptedException{
		String act= accinfo.deleteAccunt();
		String exp="ACCOUNT DELETED!";
		Assert.assertEquals(act,exp);
	}



}
