package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loggedinpage;
import pageObjects.Loginpage;
import testBase.BaseClass;
import utilities.Dataproviders;

public class Tc_003 extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=Dataproviders.class,groups= {"datadriven","Master"})
 public void verify_login(String email,String password,String exp)
 {    
	 
	 Homepage hp=new Homepage(driver);
	 hp.SignUplogin();
	 
	 Loginpage lp=new Loginpage(driver);
	 lp.setLoginEmail(email);
	 lp.setLoginPassword(password);
	 lp.loginbutton();
	 
	 Loggedinpage lip=new Loggedinpage(driver);
	 boolean targetpage = lip.loggedinmsgdisplayed();
	 
	 if(exp.equalsIgnoreCase("valid"))
	 {
		 if(targetpage==true)
		 {
			 lip.logout();
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.assertTrue(false);
		 }
	 }
	 if(exp.equalsIgnoreCase("invalid"))
	 {
		 if(targetpage==true)
		 {
			 lip.logout();
			 Assert.assertTrue(false);
		 }
		 else
		 {
			 Assert.assertTrue(true);
		 }
	 }
 }
}
