package com.fisdom.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fisdom.pages.HomePage;
import com.fisdom.pages.LoginPage;
import com.fisdom.utility.TestBase;
import com.fisdom.utility.Constants;

public class LoginTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeMethod
	public void setUp() {
		lp = new LoginPage(driver);
		hp=new HomePage(driver);
		sClassNameForScreenShot = getClass().getSimpleName();
		// t1=extLogger.createNode("Verify Text");
	}

	@Test(priority = 1)
	public void verifyTitle() {
		oCommon.verifyEqual(lp.getTitle(), Constants.loginPageTitle, "Verify Page Title",
				extLogger.createNode("Verify Title"));
		Assert.assertEquals(Constants.loginPageTitle, lp.getTitle());
		System.out.println("Title is: " + lp.getTitle());
		extLogger.log(Status.INFO,"Title Matched");
		System.out.println("Login to Webpage");
	}
	
	@Test(priority = 2)
	public void verifyAllFieldStatus() {
		Assert.assertEquals(lp.getMobileNumFieldStatus(), true);
		Assert.assertEquals(lp.getGoogleLinkStatus(), true);
		Assert.assertEquals(lp.getFBLinkStatus(), true);
		Assert.assertEquals(lp.getRegisterLinkStatus(), true);
		Assert.assertEquals(lp.getEmailLinkStatus(), true);
	}
	
	@Test(priority = 3)
	public void loginViaEmail() throws Exception {
	 lp.EmailLogin(System.getProperty("email"),System.getProperty("password"));
	 lp.clickOnLogin();
	}
	
	@Test(dependsOnMethods ="loginViaEmail")
	public void logout() throws Exception {
		 hp.isLogoutEnabled();
		 hp.clickLogout();	
	}

}
