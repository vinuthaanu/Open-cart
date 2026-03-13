package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loggedinpage extends Basepage{
	
	public Loggedinpage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//ul[@class='nav navbar-nav']//li[10]//a")	
WebElement Loggedinmsg;

@FindBy(xpath="//a[normalize-space()='Logout']")
WebElement lnkLogout;

public boolean loggedinmsgdisplayed()
{
	try 
	{
	return(Loggedinmsg.getText().contains("Logged in as"));
	}
	catch(Exception e)
	{
		return false;
	}
}

public void logout()
{
	lnkLogout.click();}
}
