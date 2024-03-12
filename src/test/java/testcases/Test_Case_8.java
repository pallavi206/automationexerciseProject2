package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;
import pages.Products_Page;

  public class Test_Case_8 extends BaseClass {
	Homepage home = new Homepage(driver);
	Products_Page pro = new Products_Page(driver);
	
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException{
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	@Test(priority=2)
	public void verifyProductsTitle() {
		String act= pro.productPageTitle();
		String exp="Automation Exercise - All Products";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=3)
	public void productsNo() {
		pro.productsOnPage();
		
	}
	@Test(priority=4)
	public void productsDetailsTitle() {
		pro.productDetailsPage();
		String act1= pro.productDetailsPageTitle();
		String exp1="Automation Exercise - Product Details";
		Assert.assertEquals(act1, exp1);
		
	}
	@Test(priority=5)
	public void verifyProductName() {
		boolean act= pro.productName();
		boolean exp= true;
		Assert.assertEquals(act, exp);
	}
	

	@Test(priority=6)
	public void verifyProductCatelog() {
		boolean act1= pro.productCat();
		boolean exp1= true;
		Assert.assertEquals(act1, exp1);
	}
	
	@Test(priority=7)
	public void verifyProductPrice() {
		boolean act1= pro.productPrice();
		boolean exp1= true;
		Assert.assertEquals(act1, exp1);
	}
	
	@Test(priority=8)
	public void verifyProductAvl() {
		boolean act1= pro.productAvl();
		boolean exp1= true;
		Assert.assertEquals(act1, exp1);
	}
	
	@Test(priority=9)
	public void verifyProductCondition() {
		boolean act1= pro.productCondition();
		boolean exp1= true;
		Assert.assertEquals(act1, exp1);
	}
	
	@Test(priority=10)
	public void verifyProductBrand() {
		boolean act1= pro.productBrand();
		boolean exp1= true;
		Assert.assertEquals(act1, exp1);
	}
	

}
