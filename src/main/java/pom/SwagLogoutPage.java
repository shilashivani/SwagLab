package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLogoutPage {
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement openMenu;
	@FindBy(xpath="//a[@id='logout_sidebar_link']")private WebElement logoutButton;
	//@FindBy(xpath="")private WebElement ;
	
	public SwagLogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnopenMenu()
	{
		openMenu.click();;
	}
	public void clickOnlogoutButton()
	{
		logoutButton.click();;
	}


}
