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
public class ToVarifyAddToCartProduct extends BaseTest{
	 ExtentReports reports;
	 ExtentTest test;
	 @BeforeTest
	 public void configureReports() {
		 reports=Reports.createReport();
	 }
	//WebDriver driver;
	@BeforeMethod
	@Parameters("Browser")
	public void lonchBrpowser()
	{
		driver=Browser.launchBrowser("Chrome");
	}
	@Test
	public void addSingleProductToCart() throws InterruptedException 
	{
		test=reports.createTest("addSingleProductToCart");
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
		int product=swagLabCartPage.totalNumberOfProductInCart();
		System.out.println(product);
			Assert.assertTrue(product>0);
		
	}
	@Test
	public void removesingleProductFromCart() throws InterruptedException {
		test=reports.createTest("removeSingleProductFromCart");
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
		swagLabCartPage.ClickOnRemoveButton();
		Thread.sleep(2000);
	//	Assert.assertEquals(swagLabCartPage.totalNumberOfProductInCart(), 0);
//		int product=swagLabCartPage.totalNumberOfProductInCart();
//		System.out.println(product);
//		Assert.assertTrue(product==0);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
	}
	@Test
	public void verifyIfCustomerIsAbleToAddMultipleProductToCart() throws InterruptedException {
		test=reports.createTest("verifyIfCustomerIsAbleToAddMultipleProductToCart");
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
		swagLabCartPage.clickOnContinueShopingButton();
		Thread.sleep(2000);
		
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.directClickOnAddCartProductButton(1);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		swagLabCartPage.ClickOnCartItemIcon();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.clickOnContinueShopingButton();
		
		Thread.sleep(2000);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.directClickOnAddCartProductButton(2);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		swagLabCartPage.ClickOnCartItemIcon();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.clickOnContinueShopingButton();
		Assert.assertEquals(swagLabCartPage.totalNumberOfProductInCart(), 2);
		
//		int product=swagLabCartPage.totalNumberOfProductInCart();
//		System.out.println(product);
			//Assert.assertTrue(product!=0);
			//Assert.assertTrue(product>1);
		
		
	}
	@Test
	public void toVarifyProductChekoutFunctionality() throws InterruptedException, EncryptedDocumentException, IOException
	{
		test=reports.createTest("toVarifyProductChekoutFunctionality");
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
		cartCheckOutPage.enterFirstName("shila");//(Parameterization.getExcelData("Credentials", 0, 2));
		cartCheckOutPage.enterLastName("deokar");//(Parameterization.getExcelData("Credentials", 0, 3));
		cartCheckOutPage.enterPostalCode("413113");//(Parameterization.getExcelData("Credentials", 1, 2));
		cartCheckOutPage.clickOnContinueButton();
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		
		
	}
	@Test
	public void toVarifyProductChekoutCanselButtonFunctionality() throws EncryptedDocumentException, IOException, InterruptedException {
		test=reports.createTest("toVarifyProductChekoutCanselButtonFunctionality");
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
		cartCheckOutPage.enterFirstName("shila");//(Parameterization.getExcelData("Credentials", 0, 2));
		cartCheckOutPage.enterLastName("deokar");//(Parameterization.getExcelData("Credentials", 0, 3));
		cartCheckOutPage.enterPostalCode("413223");//(Parameterization.getExcelData("Credentials", 1, 2));
		cartCheckOutPage.clickOnCanselbutton();
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
		
		
	}
	@Test
	public void clickOnImageToAddproductToCart() throws InterruptedException {
		test=reports.createTest("addSingleProductToCart");
		SwagLoginPage swagLoginPage=new SwagLoginPage(driver);
		swagLoginPage.enterUserName("standard_user");
		swagLoginPage.enterPassword("secret_sauce");
		swagLoginPage.clickToLogin();
		Thread.sleep(2000);
		SwagLabCartPage swagLabCartPage=new SwagLabCartPage(driver);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.directClickOnImage(1);
		switchToChildWindow(driver,swagLabCartPage.gettitle(0));
		Thread.sleep(2000);
		swagLabCartPage.directClickOnAddCartProductButton(0);
		int product=swagLabCartPage.totalNumberOfProductInCart();
		System.out.println(product);
			Assert.assertTrue(product>0);
		
	}
	

	

	

}
