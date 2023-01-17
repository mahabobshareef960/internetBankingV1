package com.internetBanking.testCases;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;

public class LoginTest {

 WebDriver driver;
 
 @Test(priority=1)
 void loginTest() throws InterruptedException
 {
  //System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32//chromedriver.exe");
  WebDriverManager.chromedriver().setup();
  driver = new ChromeDriver();
  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
  driver.findElement(By.xpath("//*[@type='password']")).sendKeys("admin123");
  driver.findElement(By.xpath("//*[@type='submit']")).click();
  Thread.sleep(2000);
  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
 }
 
 @Test(priority=2)
 void checkTotalNoOfEmployees()
 {
  Assert.assertTrue(true);
 }
 
 @Test(priority=3,dependsOnMethods={"loginTest"})
 void checkNoOfEmployeesEnabled()
 {
  Assert.assertTrue(true);
 }
 
 @AfterMethod
 public void captureScreen(ITestResult result) throws IOException
 {
  if(result.getStatus()==ITestResult.FAILURE)
  {
   TakesScreenshot ts=(TakesScreenshot)driver;
   File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
   File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
   
   FileUtils.copyFile(source,target);
   System.out.println("screenshot captured");
  }
   
 }
 
 @AfterClass
 void closeBrowser()
 {
  driver.quit();
 } 
 
}

