package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage extends Basepage{
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
@FindBy(xpath="//input[@data-qa='login-email']")
WebElement txtLoginEmail;

@FindBy(xpath="//input[@placeholder='Password']")
WebElement txtLoginPassword;

@FindBy(css="button[data-qa='login-button']")
WebElement btnLogin;

public void setLoginEmail(String email)
{
	txtLoginEmail.sendKeys(email);
}
public void setLoginPassword(String password)
{
	txtLoginPassword.sendKeys(password);
}
public void loginbutton()
{
	System.out.println(btnLogin.isEnabled());
	System.out.println(btnLogin.isDisplayed());

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  
	wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
     
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", btnLogin);
	
	
}
}
