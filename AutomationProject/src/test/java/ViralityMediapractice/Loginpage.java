package ViralityMediapractice;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginpage   {

	public static void main(String[] args) throws InterruptedException   {
		 
		//System.setProperty("Webdriver.chrome.driver","C:\\Users/chromedriver.exe");
	 
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://virality-fe.antino.ca/login");
		 
		
		Actions act = new Actions(driver);
		 driver.findElement(By.name("email_or_phone")).sendKeys("skurutage@gmail.com");
		 Thread.sleep(40);
		 driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Test@123");
		 Thread.sleep(40);
		 driver.findElement(By.xpath("//*[text()='Log in']")).click();
		 
		 driver.findElement(By.xpath("//*[@href='/campaign']")).click();
		 
		 //create campaign button
		 
		 driver.findElement(By.xpath("//*[@type='button']")).click();
	 
	 
	    WebElement upload = driver.findElement(By.xpath("//*[@type='file']"));
		 
		 upload.sendKeys("C:\\Users\\DELL\\Pictures\\Screenshots\\ss.png");
		 
		
		 driver.findElement(By.id(":r4:")).sendKeys("test campaign for automation");
		 driver.findElement(By.xpath("//*[@data-testid='CalendarIcon']")).click();
		 
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(new Date());
		    cal.add(Calendar.DATE, 2);
		    String newDate = dateFormat.format(cal.getTime());
		    
		    
		    
		    
		 
		
		 driver.findElement(By.name("campaignDetails")).sendKeys("campaign details for automation");
		 driver.findElement(By.xpath("//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-mxe9ex']")).click();
		 
		 driver.findElement(By.xpath("//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-6bbvuc']")).click();
		 driver.findElement(By.id(":r8:")).sendKeys("hashtags for automation");
		 driver.findElement(By.id(":r9:")).sendKeys("Tags for Automation");
		 
		 //dropdown 
		 //Context type
		  driver.findElement(By.id("mui-component-select-contentType")).click();
		 
		 driver.findElement(By.xpath("//*[@data-value=\"image\"]")).click();
		 
		// DailyPost
		 driver.findElement(By.id("mui-component-select-postsPerDay")).click();
		 driver.findElement(By.xpath("//*[@data-value='2']")).click();
		 //imp instruction
		 
		 driver.findElement(By.name("importantInstructions")).sendKeys("Instructions for automation");
		 //payment type 
		 driver.findElement(By.id("mui-component-select-paymentMethod")).click();
		 driver.findElement(By.xpath("//*[@data-value='amount']")).click();
		 driver.findElement(By.id(":rd:")).sendKeys("1000");
		 
		 

	}

}
