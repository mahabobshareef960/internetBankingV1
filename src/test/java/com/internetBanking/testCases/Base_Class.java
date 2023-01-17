package com.internetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import internetBanking.utilities.ReadConfig;

public class Base_Class {
       //to create object for ReadConfig to initialize  to call all methods
	ReadConfig readconfig = new ReadConfig();
	//after this constructor is invoking the object to base class
	//to reuse this methods or we use  common stuff  for all test cases
	
		public String  baseUrl = readconfig.getApplicationUrl();
		public String  username =readconfig.getUsername() ;
		public String  password = readconfig.getPassword();
		public static WebDriver driver;
		public static Logger logger;
		//if we want to run the program with desired browsers we need to Pass parameter bowser through @Parameers annotations
		@Parameters("browser")
	    @BeforeClass
	    public void setUp(String brwsr) {
	    	
	            //logger = Logger.getLogger(TC_LoginTest_001.class);
	            logger = Logger.getLogger(TC_Login_DDT_002_.class);
	         PropertyConfigurator.configure("C:\\Users\\SHAREEF\\Desktop\\log4j.txt");
	         /*System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		    	System.setProperty("webdriver.gecko.driver",readconfig.getfirefox());
		           driver = new ChromeDriver();
		            driver = new FirefoxDriver();
		    	System.setProperty("webdriver.edge.driver",readconfig.getEdge());
		          driver = new EdgeDriver();*/
	         if(brwsr.equals("chrome")) {
	        	 System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
	        	 driver = new ChromeDriver();
	         }
	         
	         else if (brwsr.equals("edge")) {
	        	 System.setProperty("webdriver.edge.driver",readconfig.getEdge());
		          driver = new EdgeDriver();
	         }
	         
	         driver.get(baseUrl);
	         
	    }
	    
	    @AfterClass
	    public void tearDown() {
	    	driver.quit();
	    }
	    
	    //random data to generate dynamically suppose email is unique
		public String randomstring() {
			String generatedString = RandomStringUtils.randomAlphabetic(8);
			return generatedString;
		}
		
		public String randomnumber() {
			String generatednum = RandomStringUtils.randomNumeric(4);
			return generatednum;
		}    
}
