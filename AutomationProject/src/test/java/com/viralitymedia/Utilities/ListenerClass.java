package com.viralitymedia.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerClass extends ExtentManager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	 
		 test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 
		 test.log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 
	 test.log(Status.FAIL,"Test Case :"+result.getMethod().getMethodName()+" is Failed");
	 test.log(Status.FAIL,result.getThrowable());
	 capturescreenshot(result.getMethod().getMethodName()+".jpg");
	 //screenshot code
	/* TakesScreenshot src =(TakesScreenshot) driver;
	 File screenshot = src.getScreenshotAs(OutputType.FILE);
	 
	 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
	 Date date = new Date();
	 String actualdate = format.format(date); 
     String screenshotpath = System.getProperty("user.dir")+
	  "/screenshots/"+actualdate+".png";
     
     File dest = new File(screenshotpath);
     
     
		try {
			FileUtils.copyFile(screenshot, dest);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
     
		test.addScreenCaptureFromPath(screenshotpath,"Test case failure screenshot");*/
	 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 
		 test.log(Status.SKIP,"Test Case: "+result.getMethod().getMethodName()+ " is Skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		 
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		 
		 ExtentManager.setExtent();
	}

	@Override
	public void onFinish(ITestContext context) {
		 
		ExtentManager.endReport();
	}

}
