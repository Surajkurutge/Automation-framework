package com.viralitymedia.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	//Need to create Object for properties class
	Properties pro;
	
	// Create Constructor 
	public ReadConfig ()
	{
		File src = new File ("./Configrations/config.properties");
		
		try {
			//To Open file & Read data use FileInputStream 	
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			//load is method which load complete config file 
			pro.load(fis);	
		}
		//suppose file is not in location there is chance of exception thats why use try catch block
		catch(Exception e){
			System.out.println("Exception is " + e.getMessage());
		} 
	}

	
	public String getApplicationURL()
	{
		String url = pro.getProperty("URL");
		return url ;
	}
	
	public String getBrandid ()
	{
		String id = pro.getProperty("Brandid");
		return id;
	}
	
	public String getBrandpassword()
	{
		String pass=pro.getProperty("Brandpassword");
		return pass;
	}
	
	public String getInfluencerid()
	{
		String id = pro.getProperty("Influencerid");
		return id;
	}
	
	public String getInfluencerpassword()
	{
		String pass =pro.getProperty("Influencerpassword");
		return pass;
	}
	
	
	
		 
	
}
