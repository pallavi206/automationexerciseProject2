package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;
import pages.Products_Page;

  public class Test_case_9  extends BaseClass{
	Homepage home = new Homepage(driver);
	Products_Page proserch = new Products_Page(driver);
	
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException{
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	@Test(priority=2)
	public void verifyProductsTitle() {
		String act= proserch.productPageTitle();
		String exp="Automation Exercise - All Products";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=3)
	public void verifySearchButton() {
		boolean act1= proserch.serachButtonenabled();
		boolean exp1= true;
		Assert.assertEquals(act1, exp1);
	}
	@Test(priority=4)
	public void verifySearchProductText() {
		String act= proserch.searchProductText();
		String exp="SEARCHED PRODUCTS";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=5)
	public void verifyProductVisiblity() {
		proserch.productVisible();
	}


}
