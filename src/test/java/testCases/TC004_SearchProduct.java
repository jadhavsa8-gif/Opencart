
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class TC004_SearchProduct extends BaseClass{
	
	
	
	@Test(groups={"Regression","Master"})
	public void VerifySearchedProduct()
	{
		logger.info("***** Starting TC004_SearchProduct *****");
		try {
			
		HomePage hp = new HomePage(getDriver());
		hp.SearchProduct(p.getProperty("Product"));
		hp.ClickSearch();
		
		SearchPage sp = new SearchPage(getDriver());
		Thread.sleep(3000);
		sp.SearchedProductExist(p.getProperty("Product"));
		Assert.assertEquals(sp.SearchedProductExist(p.getProperty("Product")),true);
		}
		
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("***** Finishing TC004_SearchProduct *****");
		
	}

}
