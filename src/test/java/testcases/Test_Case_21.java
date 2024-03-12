package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;
import pages.Products_Details_page;
import pages.Products_Page;

  public class Test_Case_21 extends BaseClass {
	Homepage home = new Homepage(driver);
	Products_Page searchpro= new Products_Page(driver);
	Products_Details_page prodetail= new Products_Details_page(driver);
	
	@Test(priority=1)
	public void verifyCategoryText() {
		home.productClick();
		String act=searchpro.productPageHeader();
		String exp= "ALL PRODUCTS";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=2)
	public void viewProduct() {
		searchpro.productDetailsPage();
	}
	
	@Test(priority=3)
	public void verifyReviewText() {
		String act=prodetail.viewProduct();
		String exp= "WRITE YOUR REVIEW";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=4)
	public void verifyReviewMessage() {
		String act=prodetail.reviewMessage();
		String exp= "Thank you for your review.";
		Assert.assertEquals(act, exp);
	}

	

}
