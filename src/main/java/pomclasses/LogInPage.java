package pomclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Util1;

public class LogInPage extends Util1 {

	WebDriver driver;

	@FindBy (xpath="(//input[@type='text'])[2]")
	private WebElement emailId;

	@FindBy (xpath="//input[@type='password']")
	private WebElement password;

	@FindBy (xpath="(//button[@type='submit'])[2]")
	private WebElement submitButton;

	

	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void enterEmailId() throws IOException
	{
		//emailId.sendKeys("jejurkar44@gmail.com");
		
		emailId.sendKeys(getConfigData("email"));
	}


	public void enterPassword() throws IOException
	{
		//password.sendKeys("aaibaba1927");
		
		password.sendKeys(getConfigData("password"));
	}

	public void clickOnSubmitButton() throws InterruptedException
	{
		submitButton.click();
		Thread.sleep(2000);
	}



}
