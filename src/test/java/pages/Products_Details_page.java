package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import library.BaseClass;

public class Products_Details_page extends BaseClass{
	By quantity=By.xpath("//input[@id='quantity']");
	By addtocart=By.xpath("//button[@type='button']");
	By viewcart=By.xpath("//u[normalize-space()='View Cart']");
	By totalquantity=By.xpath("//button[@class='disabled']");
	By writereview= By.xpath("//a[normalize-space()='Write Your Review']");
	By name= By.xpath("//input[@id='name']");
	By email= By.xpath("//input[@id='email']");
	By review= By.xpath("//textarea[@id='review']");
	By submit= By.xpath("//button[@id='button-review']");
	By reviewmsg= By.xpath("//span[normalize-space()='Thank you for your review.']");
	
	public Products_Details_page(WebDriver driver) {
		this.driver= driver;
	}

	
	public String productQuantity() {
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys("4");
		driver.findElement(addtocart).click();
		driver.findElement(viewcart).click();
		String totalqty=driver.findElement(totalquantity).getText();
		return totalqty;
	}
	public String viewProduct() {
		String rev=driver.findElement(writereview).getText();
		driver.findElement(name).sendKeys("pranita");
		driver.findElement(email).sendKeys("pranita@gmail.com");
		driver.findElement(review).sendKeys("Good site for automation practice");
		return rev;
		
	}
	
	public String reviewMessage() {
		driver.findElement(submit).click();
		String msg=driver.findElement(reviewmsg).getText();
		return msg;
		
	}


}
