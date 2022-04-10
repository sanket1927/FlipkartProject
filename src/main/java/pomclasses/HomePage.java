package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Util1;

public class HomePage extends Util1 {

WebDriver driver;
	
	@FindBy (xpath="(//div[@class='_1psGvi _3BvnxG'])[1]")
	private WebElement profileName;
	
	@FindBy (xpath="(//a[@class='_2kxeIr'])[1]")
	private WebElement myProfileTxt;
	
	@FindBy (xpath="(//li[@class='_2NOVgj'])[10]")
	private WebElement logoutTxt;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void hoverToProfileName()
	{
		isElementVisible(driver, profileName);
		moveToElement(driver, profileName);
		
	}
	
	public void clickOnMyProfileTxt()
	{
		isElementVisible(driver, myProfileTxt);	
		myProfileTxt.click();
	}
	
	public String getLogoutTxt()
	{
		return logoutTxt.getText();
	}
	
	public void movePointer() throws InterruptedException
	{
		moveByOffset(driver);
		Thread.sleep(2000);
	}

}
