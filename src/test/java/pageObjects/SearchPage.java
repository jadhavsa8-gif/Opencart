package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='product-thumb']//h4//a")
	List<WebElement> ProductList;
	
	public boolean SearchedProductExist(String ProductName)
	{
		for(WebElement product:ProductList) {
			if(product.getText().equalsIgnoreCase(ProductName))
			{
				return true;
			}
		}
		return false;
	
	}		

}
