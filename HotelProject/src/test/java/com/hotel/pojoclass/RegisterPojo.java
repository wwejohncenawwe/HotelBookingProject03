package com.hotel.pojoclass;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotel.baseclass.BaseClass;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

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
	//	@FindBy(xpath = "//td/a[@id='change-image']")
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
			assertTrue(true);
			logger.info("user is on register form page");
		}else {
			assertTrue(false);
			logger.info("user failed to click register link");
		}
	}
	public WebElement getUsername() {
		return username;
	}
	public void setUsername(String uname) {
		getUsername();
		type(username,uname);
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword(String pword) {
		getPassword();
		type(password, pword);
	}
	public WebElement getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpass) {
		getCpassword();
		type(cpassword, cpass);
	}
	public WebElement getFullname() {
		return fullname;
	}
	public void setFullname(String fname) {
		getFullname();
		type(fullname, fname);
	}
	public WebElement getEmailid() {
		return emailid;
	}
	public void setEmailid(String email) {
		getEmailid();
		type(emailid, email);
	}
	public WebElement getCaptchaimg() {
		return captchaimg;
	}
	public String setCaptchaimg() throws Exception {
		getCaptchaimg();
		//		imgvalue=captchaimg.getAttribute("src").trim();
		//		imgvalue=captchaimg.getText();
		File source=captchaimg.getScreenshotAs(OutputType.FILE);
		String target="D:\\Eclipse Workspace\\HotelProject\\Screenshots\\captcha.png";
		FileHandler.copy(source, new File (target));
		Thread.sleep(2000);
				ITesseract image=new Tesseract();
			String imgvalue=image.doOCR (new File(target));
//			imgvalue.split("");
		logger.info("captchaimg collected: "+imgvalue);
		return imgvalue;
	}
	public WebElement getCaptchatype() {
		return captchatype;
	}
	public void setCaptchatype(String value) {
		getCaptchatype();
		type(captchatype,value);
	}
	public WebElement getTerms() {
		return terms;
	}
	public void setTerms() {
		getTerms();
		btnClick(terms);
	}
	public WebElement getRegisterbtn() {
		return registerbtn;
	}
	public void setRegisterbtn() {
		btnClick(registerbtn);
	}
	public WebElement getResetbtn() {
		return resetbtn;
	}
	public void setResetbtn() {
		btnClick(resetbtn);
	}


}


