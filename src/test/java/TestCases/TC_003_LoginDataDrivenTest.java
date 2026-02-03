package TestCases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
@Test(dataProvider="LoginData", dataProviderClass= DataProviders.class,groups="DataDriven")//getting data from another vlass
	public void verify_LoginDataDrivenTest(String email, String password, String exp) throws InterruptedException 
   {

	logger.info("***** Strating TC_003 Login test case *****");
	try
	{
	//HomePage	
	HomePage hp= new HomePage(driver);
	hp.ClickMyAccount();
	hp.ClickLogin();
	
	//Loginpage
	LoginPage lp=new LoginPage(driver);
	
	lp.SetEmail(email);
	
	lp.SetPass(password);
	
	lp.ClickLogin();
	
	logger.info("Login succesfully");
	
	//MyAccount
	MyAccountPage mac= new MyAccountPage(driver);
	boolean targetpage=mac.isMyAccountPageExits();
	/*
	 * Data is valid- login success-test pass-logout
	 *  login Failed- test fail
	 * 
	 * 
	 * 
	 * Data is invalid- login success- test fail-logout
	 *                  login failed- test pass
	  */                  
	if(exp.equalsIgnoreCase("Valid")) 
	{ 
		if(targetpage==true) 
	{ 
		mac.ClickLogout(); 
		AssertJUnit.assertTrue(true); 
		} else 
		{ 
			AssertJUnit.assertTrue(false); 
		} logger.info("Logout succesfully"); 
		} 
	if(exp.equalsIgnoreCase("Invalid")) 
		{ 
			if(targetpage==true) {//for invalid data doing negative testing 
				mac.ClickLogout();
				AssertJUnit.assertTrue(false); 
				} 
			else {
				AssertJUnit.assertTrue(true); 
				}
			} 
		} catch(Exception e) 
				{ AssertJUnit.fail(); 
				}
		

	
	Thread.sleep(3000);
	
	logger.info("***** finished TC_003 Login test case *****");
	
	}
}
