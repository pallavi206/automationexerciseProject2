package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;

  public class Test_Case_26 extends BaseClass {
	Homepage home = new Homepage(driver);

	@Test(priority = 1)
	public void verifyTitle() {
		String acttitle = home.verifytitle();
		String exptitle = "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}

	@Test(priority = 2)
	public void verifySub() throws InterruptedException {
		String acttitle = home.subscription();
		String exptitle = "SUBSCRIPTION";
		Assert.assertEquals(acttitle, exptitle);
	}

	@Test(priority = 3)
	public void verifyScrollup() throws InterruptedException {
		home.scrollUpWithoutArrow();

	}

	@Test(priority = 4)
	public void verifySCrollText() {
		String acttitle = home.scrollupText();
		String exptitle = "Full-Fledged practice website for Automation Engineers";
		Assert.assertEquals(acttitle, exptitle);

	}

}
