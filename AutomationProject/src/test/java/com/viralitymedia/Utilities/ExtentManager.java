package com.viralitymedia.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.viralitymedia.testcases.BaseClass;

public class ExtentManager extends BaseClass   {
    
	public static  ExtentSparkReporter report;
	public static  ExtentReports extent;
	public static  ExtentTest test;
	
	
	 public static void setExtent() {
		 
		 
		 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		 Date date = new Date();
		 String actualdate = format.format(date);
			
	     String reportpath = System.getProperty("user.dir")+
		  "/Reports/ExtentReport_"+actualdate+".html";
	   
	     report = new ExtentSparkReporter(reportpath);
		 extent = new ExtentReports();
		 extent.attachReporter(report);
		 
		 report.config().setDocumentTitle("Virality-Media");
		 report.config().setTheme(Theme.STANDARD);
		 report.config().setReportName("Virality-Media");
	 }

	  public static void endReport() {
		  extent.flush();
	  }
	 

	
}
