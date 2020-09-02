package com.fisdom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.fisdom.utility.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "input_5")
	WebElement enterMobileNumber;
	@FindBy(xpath = "//div[text()='GOOGLE']")
	WebElement clickGoogle;
	@FindBy(xpath = "//div[text()='FACEBOOK']")
	WebElement clickFB;
	@FindBy(xpath = "//span[text()='REGISTER']")
	WebElement RegisterLink;
	@FindBy(xpath = "//div[text()='Email']")
	WebElement EmailLink;
	@FindBy(xpath = "(//button[text()='LOGIN'])[1]")
	WebElement clickLogin;
	@FindBy(id = "input_2")
	WebElement enterEmail;
	@FindBy(id="input_6")
	WebElement enterPassword;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());
		
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean getMobileNumFieldStatus() {
		extLogger.log(Status.INFO,"Mobile Number text box enabled: "+enterMobileNumber.isEnabled());
		return enterMobileNumber.isEnabled();
	}
	
	public boolean getFBLinkStatus() {
		extLogger.log(Status.INFO,"FB button enabled: "+clickFB.isEnabled());
		return clickFB.isEnabled();
	}
	public boolean getGoogleLinkStatus() {
		extLogger.log(Status.INFO,"Google button enabled: "+clickGoogle.isEnabled());
		return clickGoogle.isEnabled();
	}
	
	public boolean getRegisterLinkStatus() {
		extLogger.log(Status.INFO,"Google button enabled: "+RegisterLink.isEnabled());
		return RegisterLink.isEnabled();
	}
	public boolean getEmailLinkStatus() {
		extLogger.log(Status.INFO,"Google button enabled: "+EmailLink.isEnabled());
		return EmailLink.isEnabled();
	}
	
	public void EmailLogin(String email,String password) {
		EmailLink.click();
		enterEmail.sendKeys(email);
		enterPassword.sendKeys(password);
		
	//	return new HomePage(driver);
	}
	
	public void enterMobileNum(String mobileNum) throws InterruptedException {
		oBrowserUtil.waitForElementVisible(driver, enterMobileNumber, 10);
		enterMobileNumber.sendKeys(mobileNum);
	}
	public void clickOnLogin() throws Exception {
		if(oBrowserUtil.isDisplayed(clickLogin)) {
			clickLogin.click();
			extLogger.log(Status.INFO,"Clicked on Login button");
		}else {
			throw new Exception("Login button not displayed ");
		}
	}
}
