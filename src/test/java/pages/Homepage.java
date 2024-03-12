package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import library.BaseClass;

public class Homepage extends BaseClass {

	By signin = By.xpath("//div[@class='shop-menu pull-right']/child::ul/child::li[4]");
	By newusertext= By.xpath("//h2[text()='New User Signup!']");
	By sub= By.xpath("//h2[text()='Subscription']");
	By subemail=By.xpath("//input[@id='susbscribe_email']");
	By arrowbtn=By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
	By successmsg=By.xpath("//div[@class='alert-success alert']");
	By cart= By.xpath("//a[normalize-space()='Cart']");
	By viewpro=By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
	By frame= By.xpath("//div[@id='dismiss-button']");
	By pro1= By.xpath("//a[@data-product-id='1']");
	By product2= By.xpath("//a[@data-product-id='2']");
	By continueshop= By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	By category= By.xpath("//h2[text()='Category']");
	By womem=By.xpath("//a[contains(@href,'Women')]");
	By womendress=By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
	By womencatpagetilte= By.xpath("//h2[text()='Women - Dress Products']");
	By men=By.xpath("//a[contains(@href,'Men')]");
	By mensubcat= By.xpath("//a[normalize-space()='Tshirts']");
	By mencatpagetilte= By.xpath("//h2[text()='Men - Tshirts Products']");
	By pro= By.xpath("//a[@href='/products']");
	By recom= By.xpath("//h2[normalize-space()='recommended items']");
	By addcart= By.xpath("//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]");
	By viewcart= By.xpath("//u[normalize-space()='View Cart']");
	By dressname=By.xpath("//a[normalize-space()='Stylish Dress']");
	By scroll=By.xpath("//a[@id='scrollUp']");
	By headertext1= By.xpath("//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]");
	
	public Homepage(WebDriver driver) {
		this.driver= driver;
	}
	
	public String verifyHomepage() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public String verifytitle() {
		String title = driver.getTitle();
		return title;

	}
	public String cart() {
		driver.findElement(cart).click();
		String carttitle=driver.getTitle();
		return carttitle;
	}
	
	public void productClick() {
		driver.findElement(pro).click();
		driver.switchTo().frame(driver.findElement(By.id("aswift_6")));       
		driver.findElement(frame).click(); //Close Ad
		driver.switchTo().defaultContent(); // Return to main window
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
	}
	public String verifyNewUserSignup() {
		driver.findElement(signin).click();
		String text1=driver.findElement(newusertext).getText();
		return text1;
		
	}
	public String subscription() {
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
	public void viewproductClick() {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		driver.findElement(viewpro).click();
		driver.switchTo().frame(driver.findElement(By.id("aswift_6")));       
		driver.findElement(frame).click(); //Close Ad
		driver.switchTo().defaultContent(); // Return to main window
	}

	public void addProducts_cart() {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		
		driver.findElement(pro1).click();
		driver.findElement(continueshop).click();
		driver.findElement(product2).click();
		driver.findElement(continueshop).click();
	}
	
	public void addOneProducts_cart() {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		
		driver.findElement(pro1).click();
		driver.findElement(continueshop).click();
		
	}
	
	public String categoryText() {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		String cattext=driver.findElement(category).getText();
		return cattext;
	}
	
			
	public String womenCatPageTitle() {
		driver.findElement(womem).click();
		driver.findElement(womendress).click();
		driver.switchTo().frame(driver.findElement(By.id("aswift_6")));       
		driver.findElement(frame).click(); //Close Ad
		driver.switchTo().defaultContent(); // Return to main window
		String woenpagetitle=driver.findElement(womencatpagetilte).getText();
		return woenpagetitle;
	}
	
	public String menCatPageTitle() {
		driver.findElement(men).click();
		driver.findElement(mensubcat).click();
		String menpagetitle=driver.findElement(mencatpagetilte).getText();
		return menpagetitle;
	}
	
	public String recommendedText() {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,7200)", "");
		String recotext=driver.findElement(recom).getText();
		return recotext;
	}
	
	
	public String cartItem() {
		driver.findElement(addcart).click();
		driver.findElement(viewcart).click();
		String dresname=driver.findElement(dressname).getText();
		return dresname;
		
	}
	public String scrollUp() {
		driver.findElement(scroll).click();
		String txt=driver.findElement(headertext1).getText();
		return txt;
	}
	
	public void scrollUpWithoutArrow() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-8800)", "");
		//js.executeScript("window.scrollBy(0,7200)");
	
//		Actions a = new Actions(driver);
////		//scroll up a page
//		a.sendKeys(Keys.PAGE_UP).build().perform();
//		a.sendKeys(Keys.PAGE_UP).build().perform();

		Thread.sleep(2000);
		
	}
	
	public String scrollupText() {
		String txt=driver.findElement(headertext1).getText();
		return txt;
	}



}
