package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Contact_Us_Page;
import pages.Homepage;

  public class Test_Case_6 extends BaseClass {
	Homepage home = new Homepage(driver);
	Contact_Us_Page cont= new Contact_Us_Page(driver);
	
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException{
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	
	@Test(priority=2)
	public void verifyContactPageText() throws InterruptedException {
		String acturl=cont.contactPageText();
		String expurl="GET IN TOUCH";
		Assert.assertEquals(acturl, expurl);
		
	}
	@Test(priority=3)
	public void verifyMessage() {
		cont.enterInfo();
		String act= cont.message();
		String exp="Success! Your details have been submitted successfully.";
		Assert.assertEquals(act, exp);
	}
	
	
	@Test(priority=4)
	public void verifypgTitle() {
		String actual=cont.titlePage();
		String expected="Automation Exercise";
		Assert.assertEquals(actual, expected);
	}


}
