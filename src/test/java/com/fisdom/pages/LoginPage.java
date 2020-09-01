package com.fisdom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.fisdom.utility.TestBase;

public class LoginPage extends TestBase{
	
	Logger log = Logger.getLogger(getClass().getSimpleName());

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void getTitle() {
		System.out.println(driver.getTitle());
	}
	
	
}
