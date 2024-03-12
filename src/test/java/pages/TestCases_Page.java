package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import library.BaseClass;

public class TestCases_Page extends BaseClass {
	By testcase= By.xpath("//a[normalize-space()='Test Cases']");
	By frame1= By.xpath("//div[@id='card']/child::div/child::div");
	
	public TestCases_Page(WebDriver driver){
	
		this.driver= driver;
	}
	
	
	public String testCasePageTitle(){
		driver.findElement(testcase).click();
		driver.switchTo().frame("aswift_6"); 
		//driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
		driver.findElement(frame1).click(); //Close Ad
		driver.switchTo().defaultContent(); // Return to main window
		String test= driver.getTitle();
		return test;
		
	}


}
