package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loggedinpage;
import pageObjects.Loginpage;
import testBase.BaseClass;

public class TC_002 extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("88 test start");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Homepage hp=new Homepage(driver);
		
		hp.SignUplogin();
		
		Loginpage lp=new Loginpage(driver);
		lp.setLoginEmail(p.getProperty("email"));
		lp.setLoginPassword(p.getProperty("password"));
		lp.loginbutton();
		
		Loggedinpage lip=new Loggedinpage(driver);
		
		
		try
		{
		    boolean targetpage = lip.loggedinmsgdisplayed();

		    Assert.assertTrue(targetpage);

		    logger.info("Login validation passed");
		}
		catch(Throwable e)
		{
		    logger.error("Login validation failed", e);
		    throw e;
		}
		
	}

}
