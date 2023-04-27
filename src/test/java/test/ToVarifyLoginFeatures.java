package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.SwagLoginPage;
import utility.Parameterization;
import utility.Reports;
@Listeners(test.Listeners.class)

public class ToVarifyLoginFeatures extends BaseTest{
	 ExtentReports reports;
	 ExtentTest test;
	 @BeforeTest
	 public void configureReports() {
		 reports=Reports.createReport();
	 }
	//WebDriver driver;
	@BeforeMethod
	@Parameters("Browser")
	public void launchBrowser() throws InterruptedException
	{
		 driver=Browser.launchBrowser("Chrome");
		
	}
	@Test
	public void varifyWorkingOfLoginButtonWithValiedUsernamePassword() throws EncryptedDocumentException, IOException {
		test=reports.createTest("varifyWorkingOfLoginButtonWithValiedUsernamePassword");
		SwagLoginPage swagLoginPage=new SwagLoginPage(driver);
		swagLoginPage.enterUserName("standard_user");//(Parameterization.getExcelData("Credentials", 0, 0));
		//System.out.println()(Parameterization.getExcelData("Credentials", 0, 0));
		swagLoginPage.enterPassword("secret_sauce");//(Parameterization.getExcelData("Credentials", 1, 0));
		swagLoginPage.clickToLogin();
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
	}

}
