package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Enter_Accounts_Info_Page;
import pages.Homepage;
import pages.Signup_Login_Page;

  public class TestCase_1 extends BaseClass {
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
	public void verifyTitle(){
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	
	@Test(priority=3)
	public void verifyNewUserTitle(){
		String act1= home.verifyNewUserSignup();
		String exp1="New User Signup!";
		Assert.assertEquals(act1, exp1);
	}
	
	@Test(priority=4) 
	public void verifyenterAccountInfo(){
		String acttual= sign.enterAccountInfo();
		String expected= "ENTER ACCOUNT INFORMATION";
		Assert.assertEquals(acttual, expected);
	}
	
	@Test(priority=5)
	public void verifyAccountCreatedText() throws InterruptedException, IOException{
		String act= accinfo.AccountCreated();
		String exp="ACCOUNT CREATED!";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=6)
	public void verifyLoggedinAsUsername(){
		String actul= accinfo.loggedin();
		String exptd="Logged in as pallu";
		Assert.assertEquals(actul, exptd);
	}
	@Test(priority=7)
	public void deleteAcctText(){
		String act=accinfo.deleteAccunt();
		String exp="ACCOUNT DELETED!";
		Assert.assertEquals(act, exp);
	}

	 
	   

}
