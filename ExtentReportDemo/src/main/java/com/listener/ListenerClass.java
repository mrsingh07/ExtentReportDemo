package com.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.basePackage.BaseClass;
import com.extentManager.ExtentManager;


public class ListenerClass extends ExtentManager implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String imgPath = BaseClass.screenShot(BaseClass.driver, result.getName());
			
				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				
				//test.addScreencastFromPath(imgPath);
				//test.addScreenCaptureFromPath(imgPath);
				//test.addScreenCaptureFromPath("http://localhost:8080/job/ExtentDemo/ws/ExtentDemo/ScreenShot/loginPageTest_20200615111209.png");
				//test.addScreenCaptureFromPath("C:/Users/Hitendra/.jenkins/workspace/ExtentDemo/ExtentDemo/ScreenShot/ScreenShot.png");
				//test.addScreenCaptureFromPath("http://localhost:8080/job/ExtentDemo/ws/ExtentDemo/ScreenShot/ScreenShot.png");
				//System.out.println("PATH IS ++++++++++++++++++++++++++++"+imgPath);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}
