package com.fisdom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.fisdom.utility.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "(//span[text()='Logout'])[1]")
	WebElement logout;
	@FindBy(xpath = "//div[text()='ravidkone']")
	WebElement username;

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isLogoutEnabled() {
		return logout.isDisplayed();
	}
	
	public String verifyHomePage() {
		return username.getText();
	}
	public void clickLogout() throws Exception {
		if (oBrowserUtil.isDisplayed(logout)) {
			logout.click();
			extLogger.log(Status.INFO, "Clicked on Logout button");
		} else {
			throw new Exception("Logout button not displayed ");
		}
	}

}
