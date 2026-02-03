package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmailAdress;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@value='Login']")
WebElement btnLogin;
	

//Action Methods

public void SetEmail(String email) {
	txtEmailAdress.sendKeys(email);
}

public void SetPass(String pass) {
	txtPassword.sendKeys(pass);
}

public void ClickLogin() {
	btnLogin.click();
}
}
