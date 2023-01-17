package com.internetBanking.PageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
//create a constructor to access remote driver
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		}
	
	@FindBy(xpath="//*[@type='text']")
	@CacheLookup
	WebElement txtuser;
	
	@FindBy(xpath="//*[@type='password']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//*[@type='submit']")
	@CacheLookup
	WebElement ClickOnLogin;
	
	@FindBy(xpath="//*[@href='Logout.php']")
	@CacheLookup
	WebElement ClickOnLogOut;
	
	
	//create a methods to perform actions
	
	public void SetUsername(String uname) {
		txtuser.sendKeys(uname);
	}
	
	public void SetPassword(String psword) {
		txtpassword.sendKeys(psword);
	}
	
	
	public void ClickLogin() {
		ClickOnLogin.click();
	}
	
	
	public void ClickLogOut() {
		ClickOnLogOut.click();
	}
	
	

}
