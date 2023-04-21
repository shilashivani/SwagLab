package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLoginPage {
	WebDriver driver;
	
	@FindBy (xpath="//input[@id='user-name']")private WebElement usenaName;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//input[@id='login-button']")private WebElement login;
	public SwagLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   public void enterUserName(String emailId) {
	   usenaName.sendKeys(emailId);
   }
   public void enterPassword(String pass) {
	   password.sendKeys(pass);
   }
   public void clickToLogin() {
	   login.click();
//	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5)) ;
//	 wait.until(ExpectedConditions.visibilityOf(login));
   }
 

}
