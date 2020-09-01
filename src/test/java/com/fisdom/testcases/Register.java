package com.fisdom.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fisdom.pages.LoginPage;
import com.fisdom.utility.TestBase;

public class Register extends TestBase{
	LoginPage lp;
	
	@BeforeMethod
	public void setUp() {
		lp = new LoginPage(driver);
		sClassNameForScreenShot = getClass().getSimpleName();
		// t1=extLogger.createNode("Verify Text");
	}
	
	@Test
	public void login() {
		lp.getTitle();
		System.out.println("Login to Webpage");
	}

}
