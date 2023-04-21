package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartCheckOutPage {
	@FindBy(xpath="")private WebElement CheckoutButton;
	@FindBy(xpath="//input[@id='first-name']")private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement postalCode;
	@FindBy(xpath="//input[@id='continue']")private WebElement contine;
	@FindBy(xpath="//button[@id='cancel']")private WebElement cansel;
	@FindBy(xpath="//button[@id='finish']")private WebElement finish;
	@FindBy(xpath="//button[@id='back-to-products']")private WebElement backHome;
	@FindBy(xpath="//h2[@class='complete-header']")private WebElement Thanku;
	public CartCheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	public void enterLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	public void enterPostalCode(String code)
	{
		postalCode.sendKeys(code);
	}
	public void clickOnContinueButton() {
		contine.click();
	}
	public void clickOnCanselbutton()
	{
		cansel.click();
	}
	public void clickOnFinishButton() {
		finish.click();
	}
	public void ClickOnBackToHome() {
		backHome.click();
	}
	
	
}
