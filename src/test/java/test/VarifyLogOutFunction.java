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
import pom.SwagLabCartPage;
import pom.SwagLoginPage;
import pom.SwagLogoutPage;
import utility.Reports;
@Listeners(test.Listeners.class)
public class VarifyLogOutFunction extends BaseTest {
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
		SwagLogoutPage swagLogoutPage= new SwagLogoutPage(driver);
		swagLogoutPage.clickOnopenMenu();
		Thread.sleep(2000);
		swagLogoutPage.clickOnlogoutButton();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
		

}
}
