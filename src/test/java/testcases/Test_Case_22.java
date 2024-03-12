package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;

  public class Test_Case_22 extends BaseClass {
    Homepage home = new Homepage(driver);


	@Test(priority=1)
	public void verifyCategoryText() {
		String act=home.recommendedText();
		String exp= "RECOMMENDED ITEMS";
		Assert.assertEquals(act, exp);
	}

	@Test(priority = 2)
	public void verifyCartItem() {
		String act = home.cartItem();
		String exp = "Stylish Dress";
		Assert.assertEquals(act, exp);
	}

	

}
