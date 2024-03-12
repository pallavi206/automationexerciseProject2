package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import library.BaseClass;

  public class Contact_Us_Page extends BaseClass {
	By contact= By.xpath("//a[normalize-space()='Contact us']");
	By textcontact=By.xpath("//h2[text()='Get In Touch']");
	By namefield= By.xpath("//input[@placeholder='Name']");
	By emailfield= By.xpath("//input[@placeholder='Email']");
	By subject= By.xpath("//input[@placeholder='Subject']"); 
	By message=By.xpath("//textarea[@id='message']");
	By submitbtn= By.xpath("//input[@name='submit']");
	By choosefile= By.xpath("//input[@name='upload_file']");
	By succmessage= By.xpath("//div[text()='Success! Your details have been submitted successfully.']");
	By homebtn= By.xpath("//span[normalize-space()='Home']");
	//By frame= By.xpath("//div[@id='dismiss-button']//div//*[name()='svg']");
	By frame1= By.xpath("//div[@id='card']/child::div/child::div");
	
	public Contact_Us_Page(WebDriver driver) {
		this.driver= driver;
	}

	public String contactPageText() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(contact).click();
		String textmg= driver.findElement(textcontact).getText();
		return textmg;
	}
	
    public void enterInfo(){
		driver.findElement(namefield).sendKeys("Pranita");
		driver.findElement(emailfield).sendKeys("pranita@gmail.com");
		driver.findElement(subject).sendKeys("Automation Testing");
		driver.findElement(message).sendKeys("This is a sample website for automation testing");
		driver.findElement(choosefile).sendKeys("D:\\Eclipse New Codes\\my workspace\\automationexercise_Project2\\src\\test\\resources\\sample.txt");
		driver.findElement(submitbtn).click();
		driver.switchTo().alert().accept();
		
	}

	public String message() {
		String msg = driver.findElement(succmessage).getText();
		driver.findElement(homebtn).click();
		return msg;

	}

   public String titlePage() {
	driver.switchTo().frame("aswift_1"); 
	//driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
	driver.findElement(frame1).click(); //Close Ad
	driver.switchTo().defaultContent(); // Return to main window
	String title=driver.getTitle();
	return title;
}


}
