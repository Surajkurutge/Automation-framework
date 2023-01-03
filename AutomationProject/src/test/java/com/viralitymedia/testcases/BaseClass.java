package com.viralitymedia.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import com.viralitymedia.Utilities.ExtentManager;
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
	 
	 
	 
	 static Logger logger;
	 @BeforeClass
	
	public void setup()
	{
		 
			
		WebDriverManager.chromedriver().setup();  
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\PawanQA\\git\\Automation-framework\\AutomationProject\\Drivers\\chromedriver.exe");
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		logger =Logger.getLogger("Automatino");
		PropertyConfigurator.configure(".\\resource\\log4j.properties");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	 
		driver.get(url);
		logger.info("url launched");
	 	
	}
	 
	 	
	@AfterClass 
	public void tearDown()
	{
		
		driver.quit();
	 
		  
	}
	
	 public static  void capturescreenshot(String fileName)   
	 { 
		
		 String datename = new SimpleDateFormat("dd-MM-yyy HH-mm-ss").format(new Date());
		
		
		 TakesScreenshot screenshot = (TakesScreenshot)driver;
		 File src = screenshot.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./Screenshot/"+datename+fileName);
		 try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
}
