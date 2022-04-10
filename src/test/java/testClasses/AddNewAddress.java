package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseClasses.BaseClass;
import pomclasses.HomePage;
import pomclasses.LogInPage;
import pomclasses.ProfilePage;

public class AddNewAddress {

	WebDriver driver;
	LogInPage lp;
	HomePage hp;
	ProfilePage pp;

	ExtentReports reports;
	ExtentTest test;
	  
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String a)
	{
		reports = new ExtentReports("ExtentReports.html", true);
		test = reports.startTest("AddNewAddress");
		driver = BaseClass.getChromeDriver(a);
	}

	@BeforeMethod
	public void beforemethod()
	{
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}

	@Test
	public void verifyUserCanLogin() throws InterruptedException, IOException
	{
		lp.enterEmailId();
		lp.enterPassword();
		lp.clickOnSubmitButton();
		
		hp.hoverToProfileName();
		String txt = hp.getLogoutTxt();

		Assert.assertEquals(txt, "Logout");
		test.log(LogStatus.PASS, "LogIn Test Passed");
	}

	

	@Test(priority=1)

	public void userCanAddNewAddress() throws EncryptedDocumentException, IOException, InterruptedException
	{
		hp.hoverToProfileName();
		hp.clickOnMyProfileTxt();
		pp.clickOnManageAddress();
		pp.clickOnAddNewAddress();
		
		int oldCount = pp.getAddressCount();
		
		pp.getDataForAddress();
		pp.enterAddressLine();
		pp.clickOnSaveButton();
		
		
		int newCount = pp.getAddressCount();
		
		Assert.assertEquals(newCount, oldCount+1);
		
		test.log(LogStatus.PASS, "Added New Address");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(pp.screenCpature(driver)), "Taken Screenshot");
		}
	}
	@AfterClass
	public void afterClass()
	{
		reports.endTest(test);
		reports.flush();
		//	 driver.quit();
	}




}
