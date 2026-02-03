package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
 @Test(groups={"Sanity","Master"})
	public void verify_Login() {
		logger.info("***** Strating TC_002 Login test case *****");
		//Homepage
		try {
		HomePage hp= new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//Loginpage
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(p.getProperty("email"));
		lp.SetPass(p.getProperty("password"));
		lp.ClickLogin();
		logger.info("Login succesfully");
		//MyAccount
		MyAccountPage mac= new MyAccountPage(driver);
		boolean targetpage=mac.isMyAccountPageExits();
		
		//Assert.assertEquals(targetpage, true);
		AssertJUnit.assertTrue(targetpage);
		}
		catch(Exception e) {
			AssertJUnit.fail();
		}
		logger.info("***** finished TC_002 Login test case *****");
	}
	
	
	
	
}
