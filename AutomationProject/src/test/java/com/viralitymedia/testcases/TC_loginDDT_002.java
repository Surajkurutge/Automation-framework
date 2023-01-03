package com.viralitymedia.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.viralitymedia.Utilities.XLUtility;
import com.viralitymedia.pageObjects.Loginpage;

public class TC_loginDDT_002 extends BaseClass {
	public boolean isclickable()
	{
	WebElement res =driver.findElement(By.xpath("//*[@href='/profile']"));
	
	
		try {
			res.click();
			return true ;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@Test (dataProvider="LoginData")
	public void loginDDT (String user,String pwd ) throws InterruptedException
	{
		Loginpage lp =new Loginpage(driver);
		lp.setmailid(user);
		logger.info("Email id provided");
		
		lp.setpassword(pwd);
		logger.info("Password is provided");
		Thread.sleep(10);
		lp.clickonlogin();
		
		System.out.println(driver.getCurrentUrl());
		
		 
		
		if(isclickable() )
		{
			logger.info("Login successfully");
			lp.clickonprofile();
			logger.info("clicked");
			
			Assert.assertTrue(true);
			
			lp.clickonlogout();
			logger.info("Logout successfully");
			driver.get("https://virality-fe.antino.ca/");
			driver.findElement(By.xpath("//*[text()=' Login']")).click();
			
			
		}
		else
		{
			logger.info("Invalid credentials");
			Assert.assertTrue(false);
			
		}
		
		
	}
	
	
	
	
	
	
	
	@DataProvider (name="LoginData")
	
	public String [][] getData () throws IOException   //Two dimension array
	{
		String path = ("C:\\Users\\PawanQA\\git\\Automation-framework\\AutomationProject\\src\\test\\java\\com\\viralitymedia\\testdata\\LoginData.xlsx");
		
		XLUtility xlutil = new XLUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		
		String logindata [][] = new String [totalrows][totalcols];
		
		for (int i =1;i<=totalrows;i++)
		{
			for (int j=0; j<totalcols ; j++)
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
		
	}
	

}
