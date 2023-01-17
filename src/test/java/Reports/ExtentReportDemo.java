package Reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	public WebDriver driver;
//this the entire setup of extent report	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extentreport;
	public ExtentTest test;
	
	@BeforeTest
	public void SetupExtent() {
	htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
     htmlreporter.config().setDocumentTitle("Automation  report");//title of the report
     htmlreporter.config().setReportName("Functional report");//name of the reporter
     htmlreporter.config().setTheme(Theme.DARK);
     
     extentreport = new ExtentReports();
     extentreport.attachReporter(htmlreporter);
     extentreport.setSystemInfo("HostName","LocalHost");
     extentreport.setSystemInfo("OS","Windows10");
     extentreport.setSystemInfo("TesterName","Shareef");
     extentreport.setSystemInfo("Browser","Chrome");
     
	}
	
	@AfterTest
	public void endReport() {
		extentreport.flush();
	}
	//first set the browser setup
	@BeforeMethod
	public void BrowserSetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}
	
	//now we can write actual Test cases
	@Test
	public void verifynopcommerceTitle() {
		//we need to make entry in ur extentReport
		//here we can write the test cases
		
		test = extentreport.createTest("nopCommerceTitle");
		 String title = driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals(title,"nopCommerce demo store");
	}
	@Test
	public void VerifynopcommerceLogo() {
		test = extentreport.createTest("nopCommerceLogo");
		Boolean status= driver.findElement(By.xpath("//*[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	@Test
	public void nopcommerceLogin() {
		test = extentreport.createTest("Logintest");
		test.createNode("Login wit valid data");
		Assert.assertTrue(true);
		
		test.createNode("Login wit Invalid data");
		Assert.assertTrue(true);
	}
	//this for when test cases are failed to take screen short
	     public static String getScreenshot(WebDriver driver ,String screenshotName) throws IOException {
		String datename = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
//Indicates a driver or an HTML element that can capture a screenshot and store it in different ways. 
		TakesScreenshot ts = (TakesScreenshot) driver;
/*Java File class represents the files and directory pathnames in an abstract 
 * manner. This class is used for creation of files and directories, 
 * file searching, file deletion, etc. The File object represents the actual file/directory on the disk.
 *  Following is the list of constructors to create a File object.*/
		File source = ts.getScreenshotAs(OutputType.FILE);
//after execution ,you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + datename + ".png";
		File finalDestnation = new File(destination);
/*Returns a human-readable version of the file size, where the input represents a 
 * specific number of bytes. Computes the checksum of a file using the specified 
 * checksum object. Computes the checksum of a file using the CRC32 checksum routine.
 *  Cleans a directory without deleting it.*/
		FileUtils.copyFile(source,finalDestnation);
		return destination;
		
	}
	//this for failed test cases
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	  if(result.getStatus() == ITestResult.FAILURE) {
      test.log(Status.FAIL, "TEST CASE IS FAILED IS" +result.getName());//to add name in extent report
      test.log(Status.FAIL, "TEST CASE IS FAILED IS" +result.getThrowable());//to add error/exception in a extent report
	  
       String screenshortPath = ExtentReportDemo.getScreenshot(driver,result.getName());
       test.addScreenCaptureFromPath(screenshortPath);
	  } 
      else if(result.getStatus() == ITestResult.SKIP) {
          test.log(Status.SKIP, "TEST CASE SKIPPED IS" +result.getName());
	  }	
	  
      else if(result.getStatus() == ITestResult.SUCCESS) {
          test.log(Status.PASS, "TEST CASE SUCCESS IS" +result.getName());
	}
	  driver.close();
	
}
	
     
}




