package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import TestBase.BaseClass;


public class TC_001_AccountResgistraionTestCase extends BaseClass {


@Test(groups={"Regression","Master"})
public void verify_AccountRegistration() {
	logger.info("****** Starting TC_001_AccountRegistrationpage *****");
	
	try {
	HomePage hp = new HomePage(driver);
	hp.ClickMyAccount();
	logger.info("****** Clicked on MyAccount *****");
	
	hp.ClickRegister();
	logger.info("****** Clicked on Register *****");
	
	RegistrationPage regPage= new RegistrationPage(driver);
	regPage.SetFirstName(randomeString().toUpperCase());
	regPage.SetLastName(randomeString().toUpperCase());
	regPage.SetEmail(randomeString()+"@gmail.com");
	regPage.SetNumber(randomenumber());
	
	String password=randomealphnum();
	regPage.SetPassword(password);
	regPage.SetConfPassword(password);
	
	regPage.clickcheckbox();
	regPage.clickbutton();
	
	logger.info("****** Validating expected message*****");
	String confmsg =regPage.Confirmmsg();
	if(confmsg.equals("Your Account Has Been Created!")) {
		AssertJUnit.assertTrue(true);
	}
	else {
		logger.error("Test failded...");
		logger.debug("debug logs..");
		AssertJUnit.assertTrue(false);
	}
	//Assert.assertEquals(confmsg, "Your Account Has Been Created!*!");
	}
	catch(Exception e) {
		
		AssertJUnit.fail();
	}
	logger.info("******* Finished TC_001_AccountRegistrationpage   ********");
	
}


	

}

