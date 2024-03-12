package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Homepage;
import pages.TestCases_Page;

  public class Test_Case_7 extends BaseClass {
	Homepage home = new Homepage(driver);
	TestCases_Page test = new TestCases_Page(driver);
	
	@Test(priority=1)
	public void verifyTitle() throws InterruptedException{
		String acttitle= home.verifytitle();
		String exptitle= "Automation Exercise";
		Assert.assertEquals(acttitle, exptitle);
	}
	
	@Test(priority=2)
	public void verifyTestTitle() throws InterruptedException{
		String acttitle= test.testCasePageTitle();
		String exptitle= "Automation Practice Website for UI Testing - Test Cases";
		Assert.assertEquals(acttitle, exptitle);
	}


}
