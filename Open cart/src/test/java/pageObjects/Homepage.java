package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage
{
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
@FindBy(xpath="//a[normalize-space()='Signup / Login']")	
WebElement lnkSignUplogin;

@FindBy(xpath="//input[@placeholder='Name']")
WebElement txtName;

@FindBy(xpath="//input[@data-qa='signup-email']")
WebElement txtEmailAddress;

@FindBy(xpath="//button[normalize-space()='Signup']")
WebElement btnSignUp;



public void SignUplogin()
{
	lnkSignUplogin.click();
}
public void name(String Name)
{
	txtName.sendKeys(Name);
}
public void emailAddress(String email)
{
	txtEmailAddress.sendKeys(email);
}
public void clickSignUp()
{
	btnSignUp.click();
}

}
	