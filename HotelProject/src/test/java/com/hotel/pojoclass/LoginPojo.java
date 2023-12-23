package com.hotel.pojoclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotel.baseclass.BaseClass;

public class LoginPojo extends BaseClass{

	public WebDriver ldriver;

	public LoginPojo(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//td[text()='Existing User Login - Build 1']")
	private WebElement verifyhotelpage;

	@FindBy(xpath="//td/input[@id='username']")
	private WebElement username;

	@FindBy(xpath="//td/input[@id='password']")
	private WebElement password;

	@FindBy(xpath="//td/input[@id='login']")
	private WebElement login;

	@FindBy(xpath="//td/div/b[text()='Invalid Login details or Your Password might have expired. ']/a")
	private WebElement invalidlogin;

	@FindBy(xpath="//td[text()='Forgot Password Form ']")
	private WebElement forgotpassword;

	@FindBy(xpath="//td[text()='Welcome to Adactin Group of Hotels']")
	private WebElement loginresult;


	public WebElement getVerifyhotelpage() {
		return verifyhotelpage;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getInvalidlogin() {
		return invalidlogin;
	}

	public WebElement getForgotpassword() {
		return forgotpassword;
	}

	public WebElement getLoginresult() {
		return loginresult;
	}


	public void setVerifyhotelpage() {
		getVerifyhotelpage();
		boolean value=webelementDisplayed(verifyhotelpage);
		if(value==true) {
			Assert.assertTrue(true);
			captureScreenshot1(ldriver,"Adactin Hotel FrontPage Snap Pass");
			logger.info("User Is On AdactinHotel Login Page And Snap Capture For Reference");
		}else {
			Assert.assertTrue(false);
			captureScreenshot2(ldriver,"Adaction Hotel Failed Snap");
			logger.info("User Not In AdactinHotel Page");
		}
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
		webdriverVisibleWait(getLoginresult());
		if(webelementDisplayed(loginresult)) {
			captureScreenshot1(ldriver,"User Login Pass");
			Assert.assertTrue(true,"Login Pass");
			logger.info("User Login Success And Pass Snap Capture");
		}
		else if(webelementDisplayed(getInvalidlogin())) {
			captureScreenshot2(ldriver,"User Login Fail");
			Assert.assertTrue(true,"Login Failed");
			logger.info("Login Failed And Fail Snap Capture");
			invalidlogin.click();
			logger.info("User Clicked Forgot Password Link Due To LoginFailed");
		}else if(webelementDisplayed(getForgotpassword())){
			captureScreenshot2(ldriver,"User Forgot Password");
			logger.info("Login Failed User Navigate To Forgot Login Password Page");
			Assert.assertTrue(true,"User Is On Forgot Password Changing Page");
			logger.info("User Is On Password Updating Page And Snap Capture");
		}
		else {
			logger.info("User Unable To Click LoginButton");
			Assert.assertTrue(false);
		}
	}
}







