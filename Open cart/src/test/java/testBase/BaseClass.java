package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","regression","Master"})
	@Parameters({"browser"})
	public void setup(String browser) throws IOException
	{
		// loading config file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(browser.toLowerCase())
				{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("invalid browser"); return;
				}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
        
	}
	
	@AfterClass(groups= {"Sanity","regression","Master"})
	public void teardown()
	{
	driver.quit();
	}
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(6);
		return generatedstring;
		
	}
	public String randomnumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	public String randomalphanumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(4);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
