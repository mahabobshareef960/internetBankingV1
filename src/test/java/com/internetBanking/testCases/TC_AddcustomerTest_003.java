package com.internetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.internetBanking.PageObjects.AddCutomerPage;
import com.internetBanking.PageObjects.LoginPage;

public class TC_AddcustomerTest_003 extends Base_Class {
  
	@Test
	public void addnewcustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("user name must be provided");
		lp.SetPassword(password);
		logger.info("enter a password");
		lp.ClickLogin();
		
		Thread.sleep(4000);
		
		AddCutomerPage addcust = new AddCutomerPage(driver);
		//after call all methods which we have created in page object Actions of elements
		logger.info("providing customer details");
		Thread.sleep(5000);
		addcust.Addcutomer();
		System.out.println("now u r in user page");
		/*addcust.CustomerName("Mahaboob");
		addcust.Gender();
		addcust.CustomerDOB("20","06","1991");
		Thread.sleep(4000);
		addcust.CustomerAddress("India");
		addcust.CustomerCity("banglore");
		addcust.CustomerState("Ap");
		addcust.StatePinCode("517325");
		addcust.CustomerTelephoneNumber("9603205829");
		
		String email =  randomstring()+"@gmail.com";
		addcust.CustomerEmailid(email);
		addcust.CustomerPassword("talha");
		addcust.FinalSubmitt();
		
		Thread.sleep(4000);
		
		logger.info("Validation part");
		boolean  res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}*/
		
	}
	
	
	
}
