package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;
import pages.Products_Page;

  public class Test_Case_12 extends BaseClass {
	Products_Page addpro= new Products_Page(driver);
	Homepage home = new Homepage(driver);
	
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException{
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	
	@Test(priority=2)
	public void verifyProductAdded() throws InterruptedException{
		addpro.productPageTitle();
		addpro.addTocart();
		addpro.verifyDetails();
	}

	

}
