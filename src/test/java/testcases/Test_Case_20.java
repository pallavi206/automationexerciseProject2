package testcases;


import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Cart_Page;
import pages.Homepage;
import pages.Products_Page;
import pages.Signup_Login_Page;

  public class Test_Case_20 extends BaseClass{
	Homepage home = new Homepage(driver);
	Products_Page searchpro= new Products_Page(driver);
	Cart_Page cp= new Cart_Page(driver);
	Signup_Login_Page sig= new Signup_Login_Page(driver);
	@Test(priority=1)
	public void clickProducts() {
		home.productClick();
		String act=searchpro.productPageHeader();
		String exp= "ALL PRODUCTS";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=2)
	public void verifyCategoryText() {
		String act=searchpro.searchProductText();
		String exp= "SEARCHED PRODUCTS";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=3)
	public void verifyProducts() {
		searchpro.productVisible();
	}
	
	@Test(priority=4)
	public void addSearchedPro() {
		searchpro.addSearchedProducts();
	}
	
	@Test(priority=5)
	public void clickCart() {
		home.cart();
	}
	
	
	@Test(priority=6)
	public void verifyCartAgain() throws InterruptedException{
		String act= cp.verifycartAgain();
		assertTrue(act.contains("Kids"));
		
	}
	@Test(priority=7)
	public void signUP() {
		home.verifyNewUserSignup();
		sig.loginValid();
	}
	
	@Test(priority=8)
	public void clickCartAgain() {
		home.cart();
	}

	@Test(priority = 9)
	public void verifyCart() throws InterruptedException {
		String act = cp.verifycartAgain();
		assertTrue(act.contains("Kids"));
	}

	

}
