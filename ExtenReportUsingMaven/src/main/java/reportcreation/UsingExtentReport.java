package reportcreation;


import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UsingExtentReport {
	
	ExtentReports extentreport;
	ExtentSparkReporter extentsparkreporter;
	ExtentTest testcase;
	
	
	WebDriver ob;
	
	
	@BeforeSuite
	public void openbrowser() throws InterruptedException
	{
		
		extentreport=new ExtentReports();
		extentsparkreporter=new ExtentSparkReporter("Extentreport.html");
		extentreport.attachReporter(extentsparkreporter);
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver\\chromedriver.exe");
		 ob=new ChromeDriver();
		
		
	}
	
	
	@Test
	public void google()
	{
		testcase= extentreport.createTest("Verify Google Title");
		
		testcase.log(Status.INFO, "Navigating to Google Page");
		
		ob.get("https://www.google.com");
		String title= ob.getTitle();
		
		testcase.log(Status.INFO, "Actual title "+ title);
		testcase.log(Status.INFO, "Expected title" + "Google");
		testcase.log(Status.INFO, "Verification of Acutal and Expected title");
		if(title.equals("Google"))
		{
			testcase.log(Status.PASS, "Acutal and expected title are equal");
		}
		else
		{
			testcase.log(Status.FAIL, "Acutal and expected title are not equal");
		}
	}
	
	@Test
	public void bing() throws IOException, InterruptedException
	{
		testcase= extentreport.createTest("Verify Bing Title");
		testcase.log(Status.INFO, "Navigating to bing Page");
		ob.get("https://www.bing.com");
		String title= ob.getTitle();
		
		testcase.log(Status.INFO, "Actual title "+ title);
		testcase.log(Status.INFO, "Expected title" + "Bing");
		testcase.log(Status.INFO, "Verification of Acutal and Expected title");
		if(title.equals("bing"))
		{
			testcase.log(Status.PASS, "Acutal and expected title are equal");
		}
		else
		{
			testcase.log(Status.FAIL, "Acutal and expected title are not equal");
			
			
			
			
			
			
		}
		
	}
	
	@AfterSuite
	public void close()
	{
		ob.close();
		extentreport.flush();
	}
	
	public static void main(String[] args) {
		
	}
	

	
	
}

