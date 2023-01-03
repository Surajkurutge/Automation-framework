package com.viralitymedia.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	@Test
	public void test() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PawanQA\\git\\Automation-framework\\AutomationProject\\Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://virality-fe.antino.ca/login");
		Thread.sleep(10);
		String s= driver.getTitle();
		System.out.println(s);
	}
}
