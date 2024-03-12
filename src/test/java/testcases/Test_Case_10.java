package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;

  public class Test_Case_10 extends BaseClass {
	Homepage home = new Homepage(driver);
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException{
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	@Test(priority=2)
	public void VerifySubscriptiontext() {
		String act=home.subscription();
		String exp="SUBSCRIPTION";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=3)
	public void VerifySuccessMsg() {
		String act=home.successMsg();
		String exp="You have been successfully subscribed!";
		Assert.assertEquals(act, exp);
	}


}
