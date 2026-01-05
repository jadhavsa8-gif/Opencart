package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{
	
	
	@Test(groups={"Sanity","Master"})
	public void Verify_Login()
	{
		
		try{
	
		logger.info("***** Starting TC002_LoginTest *****");
	
		
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAcount();
		hp.clickLogin();
		
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage mcc = new MyAccountPage(driver);
		boolean target = mcc.isMyAccountPageExists();
		Assert.assertTrue(target);
        
		  //Assert.assertEquals(target, true,"Login Failed");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC002_LoginTest *****");
		
	}
	
	

}
