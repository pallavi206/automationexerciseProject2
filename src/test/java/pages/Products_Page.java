package pages;




import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.BaseClass;

public class Products_Page extends BaseClass {
	By pro= By.xpath("//a[@href='/products']");
	By products= By.xpath("//div[@class='features_items']/div");
	By viewpro=By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
	By proname= By.xpath("//h2[text()='Blue Top']");
	By procat= By.xpath("//p[text()='Category: Women > Tops']");
	By price= By.xpath("//span[text()='Rs. 500']");
	By availability=By.xpath("//div[@class='product-details']//p[1]");
	By condition=By.xpath("//div[@class='product-details']//p[2]");
	By brand= By.xpath("//body//section//p[3]");
	By frame= By.xpath("//div[@id='dismiss-button']");
	By serchtab=By.xpath("//input[@id='search_product']");
	By searchheader=By.xpath("//h2[@class='title text-center']");
	By searchicon= By.xpath("//button[@id='submit_search']");
	By topname=By.xpath("//p[text()='Frozen Tops For Kids']");
	By product= By.xpath("//div[contains(@class,'productinfo')]//p");
	By continueshop= By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	By product2= By.xpath("//a[@data-product-id='2']");
	By viewcart= By.xpath("//u[normalize-space()='View Cart']");
	By pro1= By.id("product-1");
	By pro2= By.id("product-2");
	By product1= By.xpath("//a[@data-product-id='1']");
	By brandtext= By.xpath("//h2[text()='Brands']");
	By Madame=By.xpath("//a[contains(@href,'Madame')]");
	By madamepagetilte= By.xpath("//h2[text()='Brand - Madame Products']");
	By polo= By.xpath("//a[contains(@href,'Polo')]");
	By polopagetilte= By.xpath("//h2[text()='Brand - Polo Products']");
	By productpageheader= By.xpath("//h2[@class='title text-center']");
	By addproduct= By.xpath("//a[@data-product-id='13']");
	
	public Products_Page(WebDriver driver) {
		this.driver= driver;
	}
	
	public String productPageTitle() {
		driver.findElement(pro).click();
		driver.switchTo().frame(driver.findElement(By.id("aswift_6")));       
		driver.findElement(frame).click(); //Close Ad
		driver.switchTo().defaultContent(); // Return to main window
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		String title=driver.getTitle();
		return title;
	}
	
	public List<WebElement> productsOnPage(){
		List<WebElement> productslist= driver.findElements(products);
		System.out.println(productslist.size());
		if (productslist.size() == 35) {
			assertTrue(true);
        }
        else{
        	assertFalse(false);
        }
		
		return productslist;
	}
	
	public void productDetailsPage(){
		driver.findElement(viewpro).click();
//		String protitle=driver.getTitle();
//		return protitle;
		
	}
	
	public String productDetailsPageTitle(){
		String protitle=driver.getTitle();
		return protitle;
	}
	
	public boolean productName(){
		boolean productn= driver.findElement(proname).isDisplayed();
		return productn;
	}
	
	public boolean productCat(){
		boolean productcat= driver.findElement(procat).isDisplayed();
		return productcat;
	}
	
	public boolean productPrice() {
		boolean productprice= driver.findElement(price).isDisplayed();
		return productprice;
	}
	
	public boolean productAvl(){
		boolean productavl= driver.findElement(availability).isDisplayed();
		return productavl;
	}
	public boolean productCondition() {
		boolean productcon= driver.findElement(condition).isDisplayed();
		return productcon;
	}
	public boolean productBrand() {
		boolean productbrand= driver.findElement(brand).isDisplayed();
		return productbrand;
	}
	public boolean serachButtonenabled() {
		boolean enabled=driver.findElement(searchicon).isEnabled();
		return enabled;
	}
	public String searchProductText() {
		driver.findElement(serchtab).sendKeys("Kids");
		driver.findElement(searchicon).click();
		String Search=driver.findElement(searchheader).getText();
		return Search;
	}
	public void productVisible() {
		List<WebElement> item=driver.findElements(product);
		for(int i=0; i<item.size();i++) {
			assertTrue(item.get(i).getText().contains("Kids"));
		}
	}
	public void addTocart(){
		WebElement mouse= driver.findElement(product1);
		mouse.click();
		driver.findElement(continueshop).click();
		driver.findElement(product2).click();
		driver.findElement(viewcart).click();
	}
	
	public void verifyDetails() {
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
		for(int i=0;i<Firstprodetails.size();i++) {
			assertTrue(Firstprodetails.get(i).getText().contains(map.get(1)));
			assertTrue(Secondprodetails.get(i).getText().contains(map.get(2)));
		}
	}
	public String brandTitle() {
		driver.switchTo().frame(driver.findElement(By.id("aswift_6")));       
		driver.findElement(frame).click(); //Close Ad
		driver.switchTo().defaultContent(); // Return to main window
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		String brandtxt=driver.findElement(brandtext).getText();
		return brandtxt;
	}
	public String proTitle() {
		driver.findElement(Madame).click();
		String brandt=driver.findElement(madamepagetilte).getText();
		return brandt;
	}
	public String poloTitle() {
	    driver.findElement(polo).click();
		String brandtitle=driver.findElement(polopagetilte).getText();
		return brandtitle;
	}
	public String productPageHeader() {
		String  header=driver.findElement(productpageheader).getText();
		return header;
	}
	public void addSearchedProducts() {
		driver.findElement(addproduct).click();
		driver.findElement(continueshop).click();
	}
}
