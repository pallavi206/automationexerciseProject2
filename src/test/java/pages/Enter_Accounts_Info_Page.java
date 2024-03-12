package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import library.BaseClass;

  public class Enter_Accounts_Info_Page extends BaseClass {
	By title = By.xpath("//input[@id='id_gender2']");
	By password = By.xpath("//input[@id='password']");
	By day = By.xpath("//select[@id='days']");
	By month = By.xpath("//select[@id='months']");
	By year = By.xpath("//select[@id='years']");
	By newsletter = By.xpath("//input[@id='newsletter']");
	By receiveSploffers = By.xpath("//input[@id='optin']");
	By firstname = By.xpath("//input[@id='first_name']");
	By Lastname1 = By.xpath("//input[@id='last_name']");
	By company = By.xpath("//input[@id='company']");
	By address = By.xpath("//input[@id='address1']");
	By address2 = By.xpath("//input[@id='address2']");
	By country = By.xpath("//select[@id='country']");
	By state = By.xpath("//input[@id='state']");
	By city = By.xpath("//input[@id='city']");
	By pincode = By.xpath("//input[@id='zipcode']");
	By mobnumber = By.xpath("//input[@id='mobile_number']");
	By createAccount = By.xpath("//button[normalize-space()='Create Account']");
	By accntcrtdtext = By.xpath("//b[text()='Account Created!']");
	By continuebtn = By.xpath("//a[@class='btn btn-primary']");
	By deleteaccount = By.xpath("//a[@href='/delete_account']");
	By deletecontinue = By.xpath("//a[@class='btn btn-primary']");
	By frame = By.xpath("//div[@id='dismiss-button']");
	By accntdeletetext = By.xpath("//b[text()='Account Deleted!']");
	By loggedintext = By.xpath("//ul[@class='nav navbar-nav']/child::li[10]");

	public Enter_Accounts_Info_Page(WebDriver driver) {
		this.driver = driver;
	}

	public String AccountCreated() throws InterruptedException, IOException {
		driver.findElement(title).click();
		driver.findElement(password).sendKeys("12345");
		Select day1 = new Select(driver.findElement(day));
		day1.selectByVisibleText("17");

		Select month1 = new Select(driver.findElement(month));
		month1.selectByVisibleText("December");

		Select year1 = new Select(driver.findElement(year));
		year1.selectByVisibleText("1998");

		driver.findElement(newsletter).click();
		driver.findElement(receiveSploffers).click();

		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\SigninDetails");
		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		int rows = sheet.getLastRowNum();
		System.out.println("Number of rows " + rows);

		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			XSSFCell Firstname = row.getCell(0);
			XSSFCell Lastname = row.getCell(1);
			XSSFCell Company = row.getCell(2);
			XSSFCell Address = row.getCell(3);
			XSSFCell Address2 = row.getCell(4);
			XSSFCell State = row.getCell(6);
			XSSFCell City = row.getCell(7);
			XSSFCell Zipcode = row.getCell(8);
			XSSFCell MobileNumber = row.getCell(9);

			DataFormatter fmt = new DataFormatter();

			String pin = fmt.formatCellValue(Zipcode);
			String ph = fmt.formatCellValue(MobileNumber);

			driver.findElement(firstname).sendKeys(Firstname.toString());
			driver.findElement(Lastname1).sendKeys(Lastname.toString());
			driver.findElement(company).sendKeys(Company.toString());
			driver.findElement(address).sendKeys(Address.toString());
			driver.findElement(address2).sendKeys(Address2.toString());
			driver.findElement(state).sendKeys(State.toString());
			driver.findElement(city).sendKeys(City.toString());
			driver.findElement(pincode).sendKeys(pin);
			driver.findElement(mobnumber).sendKeys(ph);
			driver.findElement(createAccount).click();
			String accnt = driver.findElement(accntcrtdtext).getText();
			driver.findElement(continuebtn).click();

			System.out.println("Account created message" + accnt);
			return accnt;

		}

		fis.close();
//		driver.findElement(firstname).sendKeys("Pallavi");
//		driver.findElement(Lastname).sendKeys("Sable");
//		driver.findElement(company).sendKeys("asdef");
//		driver.findElement(address).sendKeys("Loni Ahmednagar,Maharashtra");
//		driver.findElement(address2).sendKeys("Sangmner Road, Ahmednagar,Maharashtra");
//		Select county= new Select(driver.findElement(country));
//		county.selectByVisibleText("India");
//		driver.findElement(state).sendKeys("Maharashtra");
//		driver.findElement(city).sendKeys("Ahmednagar");
//		driver.findElement(Zipcode).sendKeys("413736");
//		driver.findElement(mobnumber).sendKeys("1234567890");
		return null;

	}

	public String loggedin() {
//	driver.switchTo().frame(driver.findElement(By.id("aswift_1")));       
//		driver.findElement(frame).click(); //Close Ad
//		driver.switchTo().defaultContent(); // Return to main window
		String logtext = driver.findElement(loggedintext).getText();
		System.out.println(logtext);
		return logtext;
	}

	public String deleteAccunt() {
		driver.findElement(deleteaccount).click();
		String deletetext = driver.findElement(accntdeletetext).getText();
		driver.findElement(deletecontinue).click();
		return deletetext;
	}

}
