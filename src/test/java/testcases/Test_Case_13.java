package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;
import pages.Products_Details_page;

  public class Test_Case_13 extends BaseClass {
	Products_Details_page proqty= new Products_Details_page(driver);
	Homepage home = new Homepage(driver);
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException{
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	@Test(priority=2)
	public void ClickViewProduct() {
		home.viewproductClick();
	}
	@Test(priority=2)
	public void verifyProductQuantity() {
		String act=proqty.productQuantity();
		String exp="4";
		Assert.assertEquals(act, exp);
		
	}


}
