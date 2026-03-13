package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EnterAccountInformation extends Basepage
{
     public EnterAccountInformation(WebDriver driver)
     {
    	 super(driver);
     }
	
@FindBy(xpath="//input[@id='password']")	
WebElement txtPassword;

@FindBy(xpath="//input[@id='first_name']")	
WebElement txtFirstname;

@FindBy(xpath="//input[@id='last_name']")	
WebElement txtLastname;

@FindBy(xpath="//input[@id='address1']")	
WebElement txtAddress1;


@FindBy(xpath="//select[@id='country']")	
WebElement dropdownCountry;

Select op=new Select(dropdownCountry);


@FindBy(xpath="//input[@id='state']")	
WebElement txtState;

@FindBy(xpath="//input[@id='city']")	
WebElement txtCity;

@FindBy(xpath="//input[@id='zipcode']")	
WebElement txtZipcode;

@FindBy(xpath="//input[@id='mobile_number']")	
WebElement txtMobileno;

@FindBy(xpath="//button[normalize-space()='Create Account']")	
WebElement btnCreatebutton;

@FindBy(xpath="//b[normalize-space()='Account Created!']")
WebElement Confirmationmsg;



public void setPassword(String password)
{
	txtPassword.sendKeys(password);
}

public void setFirstName(String fname)
{
	txtFirstname.sendKeys(fname);
}
public void setLastName(String lname)
{
	txtLastname.sendKeys(lname);
}
public void setAddress1(String address1)
{
	txtAddress1.sendKeys(address1);
}
public void setcountry(int country)
{
	op.selectByIndex(country);
}
public void setstate(String state)
{
	txtState.sendKeys(state);
}
public void setCity(String city)
{
	txtCity.sendKeys(city);
}
public void setZipcode(String zipcode)
{
	txtZipcode.sendKeys(zipcode);
}
public void setMobileno(String mobileno)
{
	txtMobileno.sendKeys(mobileno);
}
public void Createaccount()
{
	btnCreatebutton.click();
}


public String getmessage()

  {
	try {
		return(Confirmationmsg.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}
  }
 
 
}
