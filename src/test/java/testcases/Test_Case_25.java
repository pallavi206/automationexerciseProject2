package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;

  public class Test_Case_25 extends BaseClass {
	Homepage home = new Homepage(driver);

	@Test(priority = 1)
	public void verifyUrl() {
		String acturl = home.verifyHomepage();
		String expurl = "https://automationexercise.com/";
		Assert.assertEquals(acturl, expurl);

	}

	@Test(priority = 2)
	public void verifySub() throws InterruptedException {
		String acttitle = home.subscription();
		String exptitle = "SUBSCRIPTION";
		Assert.assertEquals(acttitle, exptitle);

	}

	@Test(priority = 3)
	public void verifyScroll() throws InterruptedException {
		String acttitle = home.scrollUp();
		String exptitle = "Full-Fledged practice website for Automation Engineers";
		Assert.assertEquals(acttitle, exptitle);

	}

}
