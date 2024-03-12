package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	@BeforeTest
	public void initialiazeBrowser() throws IOException
	{
		
		ChromeOptions options= new ChromeOptions();
//		HashMap<String, Integer> contentSettings= new HashMap<String, Integer>();
//		HashMap<String, Object> profile= new HashMap<String, Object>();
//		HashMap<String, Object> prefs= new HashMap<String, Object>();
//
//		profile.put("managed_default_content_setings", 2);
//		prefs.put("profile", profile);
//     	options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("prefs", new HashMap<String,Object>()
		{{ put("autofill.profile_enabled",false);
		//put("profile.managed_default_content_settings.javascript",2);
		}});
		
		options.addArguments("--disable-save-password-bubble");
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://automationexercise.com/");
	}
	private FileInputStream FileInputStream(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
//    @AfterTest
//	public void tearDown()
//	{
//		driver.quit();
//	}


}
