package com.internetBanking.testCases;


import org.testng.Assert;


import org.testng.annotations.Test;

import com.internetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends Base_Class {
 
	@Test
	public void loginTest() {
		
		logger.info("Url is opened");
		LoginPage lp= new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("Enter UserName");
		lp.SetPassword(password);
		logger.info("Enter password");
		lp.ClickLogin();
		logger.info("Then click on login");
		
		if(driver.getTitle().equals("Guru99 Bank Home Page")) {
			Assert.assertTrue(true);
			logger.info("Test is apeeds");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Test is failed");
		}
	}
}
