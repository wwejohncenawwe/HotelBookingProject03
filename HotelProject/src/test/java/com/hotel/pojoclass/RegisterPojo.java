package com.hotel.pojoclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotel.baseclass.BaseClass;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class RegisterPojo extends BaseClass {

	public WebDriver ldriver;
	public String imgvalue;

	public RegisterPojo(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(linkText = "New User Register Here")
	private WebElement registerlink;

	@FindBy(xpath="//td[text()='New User Registration Form ']")
	private WebElement registerverify;

	@FindBy(id="username")
	private WebElement username;

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="re_password")
	private WebElement cpassword;

	@FindBy(id="full_name")
	private WebElement fullname;

	@FindBy(id="email_add")
	private WebElement emailid;

	@FindBy(xpath ="//td/img[@id='captcha']")
	private WebElement captchaimg;

	@FindBy(id="captcha-form")
	private WebElement captchatype;

	@FindBy(id="tnc_box")
	private WebElement terms;

	@FindBy(id="Submit")
	private WebElement registerbtn;

	@FindBy(id="Reset")
	private WebElement resetbtn;

	public WebElement getRegisterLink() {
		return registerlink;
	}

	public void setRegisterLink() {
		getRegisterLink();
		btnClick(registerlink);
	}

	public WebElement getRegisterLinkVerify() {
		return registerverify;
	}

	public void setRegisterLinkVerify() {
		getRegisterLinkVerify();
		if(webelementDisplayed(registerverify)) {
			captureScreenshot1(ldriver,"User Register Pass");
			Assert.assertTrue(true);
			logger.info("User Is On Register Form Page And Snap Capture For Reference");
		}else {
			captureScreenshot2(ldriver,"User Register Fail");
			Assert.assertTrue(false);
			logger.info("User Failed To Click Register Link And Snap Capture For Reference");
		}
	}

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(String uname) {
		getUsername();
		type(username,uname);
		logger.info("User Entered Valid Username");
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String pword) {
		getPassword();
		type(password, pword);
		logger.info("User Entered Valid Password");
	}

	public WebElement getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpass) {
		getCpassword();
		type(cpassword, cpass);
		logger.info("User Entered Valid ConfirmPassword");
	}

	public WebElement getFullname() {
		return fullname;
	}

	public void setFullname(String fname) {
		getFullname();
		type(fullname, fname);
		logger.info("User Entered Valid Fullname");
	}

	public WebElement getEmailid() {
		return emailid;
	}

	public void setEmailid(String email) {
		getEmailid();
		type(emailid, email);
		logger.info("User Entered Valid EmailId");
	}

	public WebElement getCaptchaimg() {
		return captchaimg;
	}

	public void setCaptchaimg() throws IOException, TesseractException {
		getCaptchaimg();
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss").format(new Date());
		File source=captchaimg.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot Passed/"+timestamp+"captcha.png");
		FileUtils.copyFile(source, target);
		ITesseract image=new Tesseract();
		imgvalue=image.doOCR(target);
		logger.info("CaptchaImage Snap Collected And Pass Text Are Stored : "+imgvalue);
	}

	public WebElement getCaptchatype() {
		return captchatype;
	}

	public void setCaptchatype(String value) {
		getCaptchatype();
		type(captchatype,value);
		logger.info("User Entered Valid CaptchaText");
	}

	public WebElement getTerms() {
		return terms;
	}

	public void setTerms() {
		getTerms();
		btnClick(terms);
		logger.info("User Clicked Terms CheckBox");
	}

	public WebElement getRegisterbtn() {
		return registerbtn;
	}

	public void setRegisterbtn() {
		btnClick(registerbtn);
		captureScreenshot1(ldriver,"User Register Pass");
		logger.info("User Clicked Register Button And Pass Snap Capture");
	}

	public WebElement getResetbtn() {
		return resetbtn;
	}

	public void setResetbtn() {
		btnClick(resetbtn);
		logger.info("User Clicked Reset Button");
	}


}


