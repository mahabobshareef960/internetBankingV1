package internetBanking.utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Reports.ExtentReportsClass;

public class ExtentReportUtils  extends TestListenerAdapter{

	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;
	//THIS SETUP FOR extent report this will be execute BeforeTest
	public void OnStart(ITestContext context) {
		
		String timeStamp =new  SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	      //whole file name of report
	     String repName = "Test-Report-"+timeStamp+".html";
	         // Create an object of Extent Reports                                     //THIS IS FOR GENERATE FORMET REPORT PARTICULAR FOLDER
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReports.html");
		spark.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		 spark.config().setDocumentTitle("Automation Testing");
		 //name of the reporter
		 spark.config().setReportName("Functional Testing");
		 //to set the theme
		 spark.config().setTheme(Theme.DARK);
		 
		 extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		 extent.setSystemInfo("Environment", "Production");
		 extent.setSystemInfo("User Name", "syed mahaboob SM");
		// Name of the report
		}
	
	
	 public void onTestSuccess(ITestResult tr)
	  {
	   logger=extent.createTest(tr.getName()); // create new entry in th report
	   logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	  }
	  
	  public void onTestFailure(ITestResult tr)
	  {
	   logger=extent.createTest(tr.getName()); // create new entry in th report
	   logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
	   
	   String screenshotPath=System.getProperty("user.dir")+"\\FailureScreenshots\\"+tr.getName()+".png";
	   try {
	    logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
	   }
	   catch (IOException e) {
	     e.printStackTrace();
	   }
	  }
	  public void onTestSkipped(ITestResult tr)
	  {
	   logger=extent.createTest(tr.getName()); // create new entry in th report
	   logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	  }
	
	public void onFinish(ITestContext testContext)
	  {
	   extent.flush();
	  }
	
}
