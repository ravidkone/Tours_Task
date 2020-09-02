package com.fisdom.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fisdom.pages.HomePage;
import com.fisdom.pages.LoginPage;
import com.fisdom.utility.Constants;
import com.fisdom.utility.TestBase;

public class HomeTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeTest
	public void setUp() throws Exception {
		lp = new LoginPage(driver);
		hp=new HomePage(driver);
		sClassNameForScreenShot = getClass().getSimpleName();
		lp.EmailLogin(System.getProperty("email"), System.getProperty("email"));
		lp.clickOnLogin();
	}

	@Test(priority = 1)
	public void verifyHomePage() {
		oCommon.verifyEqual(hp.verifyHomePage(), Constants.HomePageTitle, "Verify HomePage Title",
				extLogger.createNode("Verify HomePage Title"));
		Assert.assertEquals(Constants.HomePageTitle, hp.verifyHomePage());
		
	}
	
}
