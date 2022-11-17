package com.viralitymedia.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.viralitymedia.pageObjects.Loginpage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest()
	{
		driver.get(URL);
		Loginpage lp =new Loginpage(driver);
		lp.setmailid(Influencerid);
		lp.setpassword(Influencerpassword);
		lp.clickonlogin();
		
		if(driver.getTitle().equals("Virality Media"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false,"Login failed");
		}
	}

}
