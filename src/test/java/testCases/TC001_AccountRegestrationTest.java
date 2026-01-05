package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegestrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegestrationTest extends BaseClass{
	
	
	
	@Test(groups={"Regression","Master"})
	public void verifyAccountRegestration() 
	{
		try
		{
		logger.info("***** Starting TC001_AccountRegestrationTest *****");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAcount();
		logger.info("Clicked on MyAccount Link ");
		
		
		hp.clickRegester();
		logger.info("Clicked on Regester Link ");
		
		
		AccountRegestrationPage regPage = new AccountRegestrationPage(driver);
		
		logger.info("Providing cutomer details....  ");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelphone(randomNumber());
		
		String password = randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("Validating expected message.... ");
		String confmsg = regPage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed....");
			logger.debug("Debug logs....");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** finished TC001_AccountRegestrationTest *****");
		
	} 
	

	

}


