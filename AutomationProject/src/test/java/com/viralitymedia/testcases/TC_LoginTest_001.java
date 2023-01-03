package com.viralitymedia.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.viralitymedia.pageObjects.Loginpage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest()
	{ 
		 
		
		Loginpage lp =new Loginpage(driver);
		lp.setmailid(Brandid);
		lp.setpassword(Brandpassword);
		lp.clickonlogin();
		logger.info("log in successfully");
		
	
		 
		
		if(driver.getTitle().equals("Virality Media"))
		{
			Assert.assertTrue(true);
			logger.info("***************");
	 
		}
		else
		{
			Assert.assertTrue(false,"Login failed");
		}
		
		//lp.clickonprofile();
		logger.info("profile section");
		System.out.println(driver.getCurrentUrl());
		
		lp.clickonlogout();
		logger.info("click on logout done");
		logger.info("Logout successfully");
		
		 
	}

}
