package com.internetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetBanking.PageObjects.LoginPage;

import internetBanking.utilities.XLUtils;

public class TC_Login_DDT_002_  extends Base_Class{

	@Test(dataProvider="LoginData")
	public void loginDDT(String username,String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("provide a user name");
		lp.SetPassword(pwd);
		logger.info("provide a password");
		lp.ClickLogin();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.ClickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		
		catch(NoAlertPresentException e){
			return false;	
		}
		
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path ="C:\\selenium\\verficationsCreditnials.xlsx";
	 int rownum = XLUtils.getRowCount(path,"Sheet1");
	 int columcount=XLUtils.getCellCount(path,"Sheet1",1);
	 
	  String LoginData [][] = new String[rownum][columcount];
	 
	 for(int i=1;i<=rownum;i++) {
		 
		 for(int j=0;j<columcount;j++) {
			 LoginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i, j); 
		 }
	 }
	 
	return LoginData; 
	 
	}
	}
	

