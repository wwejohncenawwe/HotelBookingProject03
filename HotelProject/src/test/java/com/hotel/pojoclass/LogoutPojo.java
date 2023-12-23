package com.hotel.pojoclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotel.baseclass.BaseClass;

public class LogoutPojo extends BaseClass{

	public WebDriver ldriver;

	public LogoutPojo(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//td/input[@id='username']")
	private WebElement username;

	@FindBy(xpath="//td/input[@id='password']")
	private WebElement password;

	@FindBy(xpath="//td/input[@id='login']")
	private WebElement login;

	@FindBy(xpath="//td/input[@id='username_show']/following::a[text()='Logout']")
	private WebElement logout;

	@FindBy(xpath="//td[text()='You have successfully logged out. ']")
	private WebElement logoutresult;


	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getLogoutresult() {
		return logoutresult;
	}



	public void setUsername(String uname) {
		getUsername();
		type(username,uname);
		logger.info("User Entered The Valid UserName");
	}

	public void setPassword(String pword) {
		getPassword();
		type(password,pword);
		logger.info("User Entered The Valid PassWord");
	}

	public void setLogin() {
		getLogin();
		btnClick(login);
		logger.info("User Clicked LoginButton");
		if(getPageSource().contains("Welcome to Adactin Group of Hotels")) {
			captureScreenshot1(ldriver,"User Login Pass");
			Assert.assertTrue(true,"Login Pass");
			logger.info("User Login Success And Pass Snap Capture");
		}else {
			Assert.assertTrue(false);
			logger.info("User Login Fail");
		}
	}

	public void setLogout() {
		getLogout();
		btnClick(logout);
		webdriverVisibleWait(getLogoutresult());
		if(webelementDisplayed(logoutresult)) {
			captureScreenshot1(ldriver,"User Logout Pass");
			Assert.assertTrue(true,"User Logout Success");
			logger.info("User Logout Pass And Pass Snap Capture");
		}else {
			Assert.assertTrue(false);
			logger.info("User Logout Fail");
		}
	}



}
