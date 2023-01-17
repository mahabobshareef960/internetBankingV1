package com.internetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCutomerPage {

	 WebDriver ldriver;
//create a constructor to initialize the across  driver 
	 public AddCutomerPage(WebDriver rdriver) {
		 ldriver = rdriver;
		 PageFactory.initElements(rdriver, this);
	
	 }
	
	@FindBy(how=How.XPATH,using ="//*[@href='addcustomerpage.php']")
		@CacheLookup
		WebElement ClicklnkAddNewCustomer;
	
	@FindBy(how=How.XPATH,using ="//*[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.XPATH,using ="//*[@type='radio'][@value='m']")
	@CacheLookup
	WebElement SelectGender;
	 
	@FindBy(how=How.XPATH,using ="//*[@type='date']")
	@CacheLookup
	WebElement txtDOB;
	
	@FindBy(how=How.XPATH,using ="//*[@name='addr']")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.XPATH,using ="//*[@name='city']")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how=How.XPATH,using ="//*[@name='state']")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.XPATH,using ="//*[@name='pinno']")
	@CacheLookup
	WebElement txtpincode;
	
	@FindBy(how=How.XPATH,using ="//*[@name='telephoneno']")
	@CacheLookup
	WebElement txtTelephonenumber;
	
	@FindBy(how=How.XPATH,using ="//*[@name='emailid']")
	@CacheLookup
	WebElement txtEmailId;
	
	@FindBy(how=How.XPATH,using ="//*[@name='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.XPATH,using ="//*[@name='password']")
	@CacheLookup
	WebElement btnSubmitt;
	
	//Actions Methods
	
	public void Addcutomer() {
		ClicklnkAddNewCustomer.click();
	}
	
	public void CustomerName(String cusname) {
		txtCustomerName.sendKeys(cusname);
	}
	
	public void Gender() {
		SelectGender.click();
	}
	
	public void CustomerDOB(String mm,String dd,String yy) {
		txtCustomerName.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}
	
	public void CustomerAddress(String address) {
		txtaddress.sendKeys(address);
	}
	
	public void CustomerCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void CustomerState(String state) {
		txtState.sendKeys(state);
	}
	
	public void StatePinCode(String pin) {
		txtpincode.sendKeys(String.valueOf(pin));
	}
	
	public void CustomerTelephoneNumber(String mobilenum) {
		txtTelephonenumber.sendKeys(mobilenum);;
	}
	
	public void CustomerEmailid(String email) {
		txtEmailId.sendKeys(email);
	}
	 
	public void CustomerPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void FinalSubmitt() {
		btnSubmitt.click();
	}
}
