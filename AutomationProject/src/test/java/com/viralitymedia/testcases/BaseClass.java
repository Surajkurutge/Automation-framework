package com.viralitymedia.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

 
import com.viralitymedia.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig config = new ReadConfig ();
	
	public String url = config.getApplicationURL();
	public String Brandid =config.getBrandid();
	public String Brandpassword =config.getBrandpassword();
	public String Influencerid =config.getInfluencerid();
	public String Influencerpassword =config.getInfluencerpassword();
	public static WebDriver driver;
 
	
	 @Parameters("browser")	
	@BeforeClass
	
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();    
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if (br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		else if (br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	 	
	}
	 
	 	
	@AfterClass 
	public void tearDown()
	{
		driver.quit();
		  
	}
	
	
}
