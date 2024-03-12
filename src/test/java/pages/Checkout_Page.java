package pages;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.BaseClass;

   public class Checkout_Page extends BaseClass{
	By addreessdetails= By.xpath("//ul[@id='address_delivery']/li");
	By pro1= By.xpath("//a[@data-product-id='1']");
	By pro2= By.id("product-2");
	By textarea= By.xpath("//textarea[@class='form-control']");
	By placeorder=By.xpath("//a[text()='Place Order']");
	By nameoncard= By.xpath("//input[@class='form-control']");
	By cardno= By.xpath("//input[@name='card_number']");
	By cvc= By.xpath("//input[@placeholder='ex. 311']");
	By expiration= By.xpath("//input[@placeholder='MM']");
	By year=By.xpath("//input[@placeholder='YYYY']");
	By pay= By.xpath("//button[@id='submit']");
	By msgtext= By.xpath("//b[text()='Order Placed!']");
	By dnwldinvoice= By.xpath("//a[@class='btn btn-default check_out']");
	By con= By.xpath("//a[@class='btn btn-primary']");
	
	public Checkout_Page(WebDriver driver) {
		this.driver= driver;
	}
	
	public void addressDetails() {
	    List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("YOUR DELIVERY ADDRESS");
		expectedResult.add("Mrs. Pallavi Sable");
		expectedResult.add("asdef");
		expectedResult.add("Loni, Ahmednagar,Maharashtra");
		expectedResult.add("Loni,Sangmner Road, Ahmednagar,Maharashtra");
		expectedResult.add("Ahmednagar Maharashtra 413736 ");
		expectedResult.add("India"); 
		expectedResult.add("1234567890"); 
		System.out.println("Expected Delivery Address :");
		 for (int i = 0; i < expectedResult.size(); i++) {
		      System.out.println(expectedResult.get(i));
		  }
		 
		List<String> actualResult = new ArrayList<String>();
		List<WebElement> address=driver.findElements(addreessdetails);
		System.out.println("Actual Delivery Address :");
		
		for(WebElement geteachtext:address){
			String addressdel= geteachtext.getText();
			System.out.println(addressdel);
			
		}
			
		for (int j=0; j<address.size(); j++){
		    actualResult.add(address.get(j).getText());
		}
		
		for(int i=0;i<expectedResult.size();i++) {
		    if(actualResult.get(i).contains(expectedResult.get(i))) {
		        System.out.println("Delivery Address is same as expected");
		    }
		    else {
		        System.out.println("Delivery Address is diffrent from expected"+actualResult.get(i));
		    }
		}

	}
	
	public void addressBillingDetails() {
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("YOUR BILLING ADDRESS");
		expectedResult.add("Mrs. Pallavi Sable");
		expectedResult.add("asdef");
		expectedResult.add("Loni, Ahmednagar,Maharashtra");
		expectedResult.add("Loni,Sangmner Road, Ahmednagr,Maharashtra");
		expectedResult.add("Ahmednagar Maharashtra 413736");
		expectedResult.add("India"); 
		expectedResult.add("1234567890"); 
		System.out.println("Expected Delivery Address :");
		 for (int i = 0; i < expectedResult.size(); i++) {
		      System.out.println(expectedResult.get(i));
		  }
		List<String> actualResult = new ArrayList<String>();
		List<WebElement> address=driver.findElements(addreessdetails);
		System.out.println("Actual Billing Address :");
		
		for(WebElement geteachtext:address) {
			String addressdel= geteachtext.getText();
			System.out.println(addressdel);
		}
			
		for (int j=0; j<address.size(); j++){
		    actualResult.add(address.get(j).getText());
		}
		
		for(int i=0;i<expectedResult.size();i++) {
		    if(actualResult.get(i).contains(expectedResult.get(i))) {
		        System.out.println("Billing Address is same as expected");
		    }else {
		        System.out.println("Billing Address is diffrent from expected"+actualResult.get(i));
		    }
		}

	}
	public void verifyProDetails() {
		List<WebElement> Firstprodetails=driver.findElements(pro1);
		List<WebElement> Secondprodetails=driver.findElements(pro2);
		HashMap<Integer, String> map= new HashMap<Integer, String>();
		map.put(1,"Blue Top");
		map.put(1,"Women > Tops");
		map.put(1,"Rs. 500");
		map.put(1,"1");
		map.put(1,"Rs. 500");
		map.put(2,"Men Tshirt");
		map.put(2,"Men > Tshirts");
		map.put(2,"Rs. 400");
		map.put(2,"1");
		map.put(2,"Rs. 400");
		for(int i=0;i<Firstprodetails.size();i++){
			assertTrue(Firstprodetails.get(i).getText().contains(map.get(1)));
			assertTrue(Secondprodetails.get(i).getText().contains(map.get(2)));
		}
}
	public String successMessage() throws InterruptedException{
		driver.findElement(textarea).sendKeys("This is my first order");
		driver.findElement(placeorder).click();
		driver.findElement(nameoncard).sendKeys("Pranita");
		driver.findElement(cardno).sendKeys("1234");
		driver.findElement(cvc).sendKeys("asdf");
		driver.findElement(expiration).sendKeys("05/2027");
		driver.findElement(year).sendKeys("01/05/2024");
		driver.findElement(pay).click();
		Thread.sleep(5000);
		String msg=driver.findElement(msgtext).getText();
		Thread.sleep(2000);
		return msg;
	}
	
	public void downloadInvoice(){
		driver.findElement(dnwldinvoice).click();
		driver.findElement(con).click();
		
	}
}
