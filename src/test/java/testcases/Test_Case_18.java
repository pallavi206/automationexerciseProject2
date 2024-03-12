package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;

  public class Test_Case_18 extends BaseClass {
    Homepage home = new Homepage(driver);
	
	@Test(priority=1)
	public void verifyCategoryText() {
		String act=home.categoryText();
		String exp= "CATEGORY";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority = 2)
	public void verifyWomenCatPageTitle() {
		String act = home.womenCatPageTitle();
		String exp = "WOMEN - DRESS PRODUCTS";
		Assert.assertEquals(act, exp);
	}
	

	@Test(priority=3)
	public void verifymenCatPageTitle() {
		String act=home.menCatPageTitle();
		String exp= "MEN - TSHIRTS PRODUCTS";
		Assert.assertEquals(act, exp);
	}


}
