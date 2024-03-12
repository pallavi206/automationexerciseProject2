package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Cart_Page;
import pages.Homepage;

  public class Test_Case_11 extends BaseClass {
	Homepage home = new Homepage(driver);
	Cart_Page cart = new Cart_Page(driver);
	
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException{
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	@Test(priority=2)
	public void VerifySubscriptiontext() {
		home.cart();
		String act=cart.subscription();
		String exp="SUBSCRIPTION";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=3)
	public void VerifySuccessMsg() {
		String act=cart.successMsg();
		String exp="You have been successfully subscribed!";
		Assert.assertEquals(act, exp);
	}
	

	

	

}
