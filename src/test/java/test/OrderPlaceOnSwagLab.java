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
import pom.CartCheckOutPage;
import pom.SwagLabCartPage;
import pom.SwagLoginPage;
import utility.Parameterization;
import utility.Reports;
@Listeners(test.Listeners.class)
public class OrderPlaceOnSwagLab extends BaseTest {
	 ExtentReports reports;
	 ExtentTest test;
	 @BeforeTest
	 public void configureReports() {
		 reports=Reports.createReport();
	 }
	//WebDriver driver;
	@BeforeMethod
	@Parameters("Browser")
	public void LonchBrowser() {
		driver=Browser.launchBrowser("Chrome");
	}
	@Test
	public void verifyIfACustomerAbletoPlace() throws EncryptedDocumentException, IOException, InterruptedException {
        test=reports.createTest("verifyIfACustomerAbletoPlace");
		SwagLoginPage swagLoginPage=new SwagLoginPage(driver);
		swagLoginPage.enterUserName("standard_user");
		swagLoginPage.enterPassword("secret_sauce");
		swagLoginPage.clickToLogin();
		Thread.sleep(2000);
		SwagLabCartPage swagLabCartPage=new SwagLabCartPage(driver);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.directClickOnAddCartProductButton(0);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		swagLabCartPage.ClickOnCartItemIcon();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.clickOnChekOutButton();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		
		CartCheckOutPage cartCheckOutPage=new CartCheckOutPage(driver);
		Thread.sleep(2000);
		cartCheckOutPage.enterFirstName("shila");//(Parameterization.getExcelData("Credentials", 0, 0));
		cartCheckOutPage.enterLastName("deokar");//(Parameterization.getExcelData("Credentials", 0, 0));
		cartCheckOutPage.enterPostalCode("423213");//(Parameterization.getExcelData("Credentials", 0, 0));
		cartCheckOutPage.clickOnContinueButton();
		Thread.sleep(2000);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		cartCheckOutPage.clickOnFinishButton();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		cartCheckOutPage.ClickOnBackToHome();
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
		//Assert.assertTrue();
		
	}

}
