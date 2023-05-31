package reportcreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class OpenGoogle {

	public static void main(String[] args) {
		
		ExtentReports extenreport;
		ExtentSparkReporter extentspark;
		
		
		
		extenreport=new ExtentReports();
		extentspark=new ExtentSparkReporter("google.html");
		extenreport.attachReporter(extentspark);
		
		
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver NEw\\chromedriver.exe");
		WebDriver ob=new ChromeDriver();
	
		ob.get("https://www.google.com");
		ob.close();
		extenreport.flush();

	}

}
