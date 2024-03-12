package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Cart_Page;
import pages.Checkout_Page;
import pages.Enter_Accounts_Info_Page;
import pages.Homepage;
import pages.Signup_Login_Page;

  public class Test_Case_14 extends BaseClass {
	Homepage home = new Homepage(driver);
	Cart_Page cart = new Cart_Page(driver);
	Signup_Login_Page sig= new Signup_Login_Page(driver);
	Enter_Accounts_Info_Page details= new Enter_Accounts_Info_Page(driver);
	Checkout_Page chekout= new Checkout_Page(driver);
	
	@Test(priority=1)
	public void verifyUrl() {
		String acturl=home.verifyHomepage();
		String expurl="https://automationexercise.com/";
		Assert.assertEquals(acturl, expurl);
		
	}
	
	@Test(priority=2)
	public void VerifyAddtoCart() {
		home.addProducts_cart();
	}
	
	@Test(priority=3)
	public void cart() {
		String act=home.cart();
		String exp="Automation Exercise - Checkout";
		Assert.assertEquals(act, exp);
	}

	@Test(priority=4)
	public void verifyReg_login() throws InterruptedException, IOException{
		cart.checkout();
		cart.reg_login();
	}
	@Test(priority=5)
	public void enterInfo() throws InterruptedException, IOException{
		sig.enterAccountInfo();
		details.AccountCreated();
	}
	
	@Test(priority=6)
	public void VerifyLogginTect() {
		String act=details.loggedin();
		String exp="Logged in as ami";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=7)

	public void proccedtoCheckout() throws InterruptedException, IOException{
		home.cart();
		cart.checkout();
	}
	@Test(priority=8)
	public void verifyAddress() {
		chekout.addressDetails();
		chekout.verifyProDetails();
	}
	@Test(priority=9)
	public void verifySuccessMessage() throws InterruptedException{
		String act=chekout.successMessage();
		String exp="Order Placed!";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=10)
	public void deleteAccount() {
		details.deleteAccunt();
	}


}
