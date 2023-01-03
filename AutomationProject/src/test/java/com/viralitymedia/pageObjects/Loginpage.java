package com.viralitymedia.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="email_or_phone")
	WebElement mailid;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Log in']")
	WebElement button;
	
	@FindBy (xpath="//*[@href=\"/profile\"]")
	WebElement profilebutton ;
	
	@FindBy (xpath="//*[text()=\"Logout\"]")
	WebElement ClickOnLogout;
	
	@FindBy (xpath="//*[text()=\"Yes\"]")
	WebElement Yesbutton ;
	
	public void setmailid (String id)
	{
		mailid.sendKeys(id);
	}
	
	public void setpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickonlogin()
	{
		button.click();
	}
	
	public void clickonprofile()
	{
		profilebutton.click();
	}
	
	 
	
	public void clickonlogout()
	{
		ClickOnLogout.click();
		Yesbutton.click();
	}
}
