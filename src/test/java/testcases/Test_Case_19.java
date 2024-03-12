package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;
import pages.Products_Page;

  public class Test_Case_19 extends BaseClass {
	Products_Page pro= new Products_Page(driver);
	Homepage home = new Homepage(driver);
	
	
	@Test(priority=1)
	public void verifyTitle() {
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}

	@Test(priority = 2)
	public void clickPro() {
		home.productClick();
	}
	
	@Test(priority=3)
	public void VerifybrandTitle() {
		String act=pro.brandTitle();
		String exp= "BRANDS";
		Assert.assertEquals(act, exp);
	}
	
	
	@Test(priority=4)
	public void VerifyproTitle() {
		String act=pro.proTitle();
		String exp= "BRAND - MADAME PRODUCTS";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=5)
	public void VerifypoloTitle() {
		String act=pro.poloTitle();
		String exp= "BRAND - POLO PRODUCTS";
		Assert.assertEquals(act, exp);
	}

	

}
