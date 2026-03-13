package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EnterAccountInformation;
import pageObjects.Homepage;
import testBase.BaseClass;

public class Tc_001 extends BaseClass{
	
	
	
	@Test(groups= {"regression","Master"})
	public void accountregister() throws InterruptedException
	{
		logger.info("****execution started***");
		try
		{
		 Homepage hp=new Homepage(driver);
		  
		 hp.SignUplogin();
		 hp.name(randomstring());
		 hp.emailAddress(randomstring()+"@gmail.com");
		 hp.clickSignUp();
		 
		 
		 EnterAccountInformation ai=new EnterAccountInformation(driver);
		 
		 
		 ai.setPassword(randomalphanumeric());
		 ai.setFirstName(randomstring().toUpperCase());
		 ai.setLastName(randomstring().toUpperCase());
		 ai.setAddress1(randomstring());
		 Thread.sleep(5000);
		 ai.setcountry(1);
		 ai.setstate(randomstring());
		 ai.setCity(randomstring());
		 ai.setZipcode(randomnumber());
		 ai.setMobileno(randomnumber());
		 Thread.sleep(5000);
		 ai.Createaccount();
		 
		String confmsg=ai.getmessage();
		 
		Assert.assertEquals(confmsg, "ACCOUNT CREATED!"); 
		}
		catch(Exception e)
		{
			logger.error("test fail");
			logger.debug("debug logs");
			Assert.fail();
			 e.printStackTrace();
		}
		
		 
	}
	
	
	
}
