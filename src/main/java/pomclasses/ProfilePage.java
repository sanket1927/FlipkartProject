package pomclasses;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Util1;

public class ProfilePage extends Util1 {

	WebDriver driver;

	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddress;

	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement addNewAddressTxt;
	
	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement addressLine1;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveAddressButton;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> addressCount;

	public ProfilePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void clickOnManageAddress()
	{
		isElementVisible(driver, manageAddress);
		moveToElement(driver, manageAddress);
		manageAddress.click();
	}

	public void clickOnAddNewAddress()
	{
		isElementVisible(driver, addNewAddressTxt);
		moveToElement(driver, addNewAddressTxt);
		addNewAddressTxt.click();
	}
	
	public void getDataForAddress() throws EncryptedDocumentException, IOException
	{
		List <String> list = getMultipleDataFromXcel(0,3);
		
		for (int i=1; i<=4;i++)
		{
			WebElement element = driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
			element.sendKeys(list.get(i-1));
		}
	}
	
	public int getAddressCount()
	{
		return addressCount.size();
	}
	
	public void enterAddressLine()
	{
		addressLine1.sendKeys("Shivaji Chowk");
	}
	
	public void clickOnSaveButton() throws InterruptedException
	{
		saveAddressButton.click();
		Thread.sleep(2000);
	}

}
