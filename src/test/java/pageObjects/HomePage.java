package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage  {
	
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyAccount;
	
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegester;
	
	@FindBy(xpath="//li[@class='dropdown open']//a[text()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement txtSearch;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-search']")
	WebElement btnSearch;
	
	
	
	
	public void clickMyAcount() 
	{
		lnkMyAccount.click();
		
	}
	public void clickRegester()
	{
		
		lnkRegester.click();
	}
    public void clickLogin() 
    {
		
    	lnkLogin.click();
	}
    public void SearchProduct(String ProductName)
    {
    	txtSearch.sendKeys(ProductName);
    }

    public void ClickSearch()
    {
    	btnSearch.click();
    }

}
