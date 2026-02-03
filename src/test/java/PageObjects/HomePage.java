package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
//Constructor
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
//Locator
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	
	@FindBy(linkText="Login")
	//@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement lnkLogin;
	//action methods
	
	public void ClickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void ClickRegister() {
		lnkRegister.click();
	}
	
	public void ClickLogin() {
		lnkLogin.click();
	}
}
