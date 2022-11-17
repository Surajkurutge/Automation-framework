package com.viralitymedia.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public String URL ="https://virality-fe.antino.ca/login";
	public String Brandid ="skurutage@gmail.com";
	public String Brandpassword ="Test@123";
	public String Influencerid ="kurutagesuraj@gmail.com";
	public String Influencerpassword ="Test@1234";
	public static WebDriver driver;
	
			
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	}
	
	@AfterClass 
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
