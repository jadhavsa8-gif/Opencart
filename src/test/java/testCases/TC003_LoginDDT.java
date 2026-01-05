package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven") //getting data provider from differnt class //no req if it is in same class
	public void verify_LoginDDT(String emial,String pwd, String exp ) throws InterruptedException
	{

		logger.info("***** Starting TC003_LoginDDT *****");
		
		try {
			
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAcount();
		hp.clickLogin();
		
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(emial);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage mcc = new MyAccountPage(driver);
		boolean target = mcc.isMyAccountPageExists();
		
		//Data is Valid - login success - test pass  -logout
		//               login fail    - test fail 
		                
		// Data is Invalid - login success - test fail - logout
		//              login fail     - test pass 
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(target==true) 
			{
				mcc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
		 
		    if(target==true) 
			{
		    	mcc.clickLogout();
				Assert.assertTrue(false);
				
				
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		}catch(Exception e)
		{
			Assert.fail();
			
		}
		Thread.sleep(3000);
		logger.info("***** finished TC003_LoginDDT *****");
		

}
}
