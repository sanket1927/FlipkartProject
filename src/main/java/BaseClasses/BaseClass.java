package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver getChromeDriver(String a)
	{
		if(a.equals("chrome"))

		{
			// WebDriverManager.chromedriver();  if this line is used then there is no need of line no 18 to use

			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");

			WebDriver driver = new ChromeDriver(); 	
			
			driver.manage().deleteAllCookies();

			driver.get("https://www.flipkart.com");		

			driver.manage().window().maximize();

			return driver;}
		else
		{
			//	WebDriverManager.firefoxdriver();
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\firefox.exe");

			WebDriver driver = new FirefoxDriver(); 	

			driver.get("https://www.flipkart.com");		

			driver.manage().window().maximize();

			return driver;
		}
	}


}
