package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import library.BaseClass;

public class Cart_Page extends BaseClass {
	By sub= By.xpath("//h2[text()='Subscription']");
	By subemail=By.xpath("//input[@id='susbscribe_email']");
	By arrowbtn=By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
	By successmsg=By.xpath("//div[@class='alert-success alert']");
	By proceedtocheckout= By.xpath("//a[@class='btn btn-default check_out']");
	By reglogin= By.xpath("//u[normalize-space()='Register / Login']");
	//By cartempty=By.xpath("//span[@id='empty_cart']//p");
	//By cartempty=By.xpath("//b[text()='Cart is empty!']");
	By cartempty= By.cssSelector("p[class='text-center'] b");
	By crossbtn=By.cssSelector(".fa.fa-times.fa.fa-times");
	By proname=By.xpath("//table[@id='cart_info_table']/child::thead/following-sibling::tbody/child::tr/child::td[2]/child::h4/a");
	
	public Cart_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String subscription(){
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,8000)", "");
		String subs=driver.findElement(sub).getText();
		return subs;
	}
	public String successMsg() {
		driver.findElement(subemail).sendKeys("pranita@gmail.com");
		driver.findElement(arrowbtn).click();
		String msg=driver.findElement(successmsg).getText();
		return msg;
		
	}
	public void checkout()  throws InterruptedException, IOException{
		driver.findElement(proceedtocheckout).click();
	
				
	}
	public void reg_login(){ 
		driver.findElement(reglogin).click();
	}
	
	public String removeCartItem() {
		driver.findElement(crossbtn).click();
		String msg1=driver.findElement(cartempty).getText();
		return msg1;
	}
	
	public String verifycartAgain() throws InterruptedException{
		String productname=driver.findElement(proname).getText();
		return productname;
	}


}
