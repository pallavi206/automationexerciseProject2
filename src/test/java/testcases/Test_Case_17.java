package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Cart_Page;
import pages.Homepage;

  public class Test_Case_17 extends BaseClass {
	Homepage home = new Homepage(driver);
	Cart_Page cart = new Cart_Page(driver);
	
	
	@Test(priority=1)
	public void verifyTitle() {
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
		
	}
	@Test(priority=2)
	public void addProducts() {
		home.addOneProducts_cart();
	}
	
	@Test(priority=3)
	
	public void clickCartBtn() {
		String act=home.cart();
		String exp= "Automation Exercise - Checkout";
		Assert.assertEquals(act, exp);
	}
	

	@Test(priority=4)
	public void VerifyRemoveCartItem() {
		String act=cart.removeCartItem();
		String exp= "Cart is empty!";
		Assert.assertEquals(act, exp);
	}


}
