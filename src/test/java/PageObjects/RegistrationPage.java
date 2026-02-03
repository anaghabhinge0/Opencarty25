package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
//Constructor
	public RegistrationPage(WebDriver driver) {
		
		super(driver);
	}

	//Locators

@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstName;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastName;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtNumber;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;


@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkdpolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnSubmit;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

//Action Methods
public void SetFirstName(String Fname) {
	txtFirstName.sendKeys(Fname);
}

public void SetLastName(String Lname) {
	txtLastName.sendKeys(Lname);
}

public void SetEmail(String email) {
	txtEmail.sendKeys(email);
}

public void SetNumber(String tel) {
	txtNumber.sendKeys(tel);
}

public void SetPassword(String pass) {
	txtpassword.sendKeys(pass);
}

public void SetConfPassword(String pass) {
	txtConfirmpassword.sendKeys(pass);
}

public void clickcheckbox() {
	chkdpolicy.click();
}

public void clickbutton() {
	btnSubmit.click();
}
public String Confirmmsg() {
	try {
		return(msgConfirmation.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
	}
}


}
