package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import library.BaseClass;

public class Signup_Login_Page extends BaseClass {
	By name = By.xpath("//input[@placeholder='Name']");
	By emailfield = By.xpath("//input[@data-qa='signup-email']");
	By signup = By.xpath("//form[@action='/signup']/child::button");
	By accountinfotext = By.xpath("//b[text()='Enter Account Information']");
	By textboxheader = By.xpath("//h2[text()='Login to your account']");
	By email = By.xpath("//input[@data-qa='login-email']");
	By password = By.xpath("//input[@placeholder='Password']");
	By login = By.xpath("//button[normalize-space()='Login']");
	By invalidtext = By.xpath("//p[text()='Your email or password is incorrect!']");
	By logtext = By.cssSelector("li:nth-child(10) a:nth-child(1)");
	By logout = By.xpath("//a[normalize-space()='Logout']");
	By errortextmsg = By.xpath("//p[text()='Email Address already exist!']");
	By newusertext = By.xpath("//h2[text()='New User Signup!']");

	public Signup_Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	public String enterAccountInfo() {
		driver.findElement(name).sendKeys("pallavi");
		driver.findElement(emailfield).sendKeys("pallavi1234@gmail.com");
		driver.findElement(signup).click();
		String accttext = driver.findElement(accountinfotext).getText();
		System.out.println(accttext);
		return accttext;

	}

	public String loginText() {
		String logtext = driver.findElement(textboxheader).getText();
		return logtext;
	}

	public void loggedinUsernameText() throws InterruptedException {
		driver.findElement(email).sendKeys("pranita@gmail.com");
		driver.findElement(password).sendKeys("12345");
		driver.findElement(login).click();
		Thread.sleep(5000);

	}

	public String inavlidtextMessage() {
		driver.findElement(email).sendKeys("abcde@gmail.com");
		driver.findElement(password).sendKeys("1234567");
		driver.findElement(login).click();
		String txtmsg = driver.findElement(invalidtext).getText();
		return txtmsg;
	}

	public String verifyNewUserSignup() {
		String text1 = driver.findElement(newusertext).getText();
		return text1;

	}

	public String loginValid() {
		driver.findElement(email).sendKeys("pranita@gmail.com");
		driver.findElement(password).sendKeys("12345");
		driver.findElement(login).click();
		String loguser = driver.findElement(logtext).getText();
		return loguser;

	}

	public String navigateto_logout() {
		driver.findElement(logout).click();
		String navigationtitle = driver.getTitle();
		return navigationtitle;
	}

	public String enterExistingAccountInfo() {
		driver.findElement(name).sendKeys("pranita");
		driver.findElement(emailfield).sendKeys("pranita@gmail.com");
		driver.findElement(signup).click();
		String errortext = driver.findElement(errortextmsg).getText();
		System.out.println(errortext);
		return errortext;

	}

	public void loginUser() {
		driver.findElement(email).sendKeys("pallavi@gmail.com");
		driver.findElement(password).sendKeys("12345");
		driver.findElement(login).click();
	}

}
