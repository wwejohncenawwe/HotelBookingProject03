package com.hotel.pojoclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotel.baseclass.BaseClass;

public class SearchPojo extends BaseClass{

	public WebDriver ldriver;

	public SearchPojo(WebDriver rdriver) {
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

	@FindBy(xpath="//td[text()='Search Hotel ']")
	private WebElement verifysearchpage;

	@FindBy(id="location")
	private WebElement location;

	@FindBy(xpath="//td/span[@id='location_span']")
	private WebElement locationmandatory;

	@FindBy(id="hotels")
	private WebElement hotels;

	@FindBy(id="room_type")
	private WebElement roomtype;

	@FindBy(xpath="//td/select[@id='room_nos']/option[text()='1 - One']")
	private WebElement numberofrooms;

	@FindBy(xpath="//td/span[@id='num_room_span']")
	private WebElement numberofroomsmandatory;

	@FindBy(id="datepick_in")
	private WebElement indate;

	@FindBy(xpath="//td/span[@id='checkin_span']")
	private WebElement indatemandatory;

	@FindBy(id="datepick_out")
	private WebElement outdate;

	@FindBy(xpath="//td/span[@id='checkout_span']")
	private WebElement outdatemandatory;

	@FindBy(xpath="//td/select[@id='adult_room']/option[2]")
	private WebElement adultroom;

	@FindBy(xpath="//td/span[@id='adults_room_span']")
	private WebElement adultmandatory;

	@FindBy(xpath="//td/select[@id='child_room']/option[1]")
	private WebElement childerenroom;

	@FindBy(id="Submit")
	private WebElement search;

	@FindBy(id="Reset")
	private WebElement reset;

	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement searchresult;


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

	public WebElement getVerifysearchpage() {
		return verifysearchpage;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getLocationmandatory() {
		return locationmandatory;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}

	public WebElement getNumberofrooms() {
		return numberofrooms;
	}

	public WebElement getNumberofroomsmandatory() {
		return numberofroomsmandatory;
	}

	public WebElement getIndate() {
		return indate;
	}

	public WebElement getIndatemandatory() {
		return indatemandatory;
	}

	public WebElement getOutdate() {
		return outdate;
	}

	public WebElement getOutdatemandatory() {
		return outdatemandatory;
	}

	public WebElement getAdultroom() {
		return adultroom;
	}

	public WebElement getAdultmandatory() {
		return adultmandatory;
	}

	public WebElement getChilderenroom() {
		return childerenroom;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getSearchresult() {
		return searchresult;
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

	public void setVerifysearchpage() {
		getVerifysearchpage();
		webdriverVisibleWait(getVerifysearchpage());
		if(webelementDisplayed(verifysearchpage)) {
			captureScreenshot1(ldriver,"Search Menu");
			Assert.assertTrue(true);
			logger.info("User Is On Search Menu Page And Snap Capture For Reference");
		}else {
			logger.info("User Not In Search Menu Page Please Navigate To Search Page For Hotel Searchin Operation");
			Assert.assertTrue(false);
		}
	}

	public void setLocation(String loc) {
		getLocation();
		selectByVisibleText(location,loc);
		logger.info("User Selected The Location");
	}

	public void setHotel(String hot) {
		getHotels();
		selectByVisibleText(hotels,hot);
		logger.info("User Selected The Hotel");
	}

	public void setRoomtype(String roo) {
		getRoomtype();
		selectByVisibleText(roomtype,roo);
		logger.info("User Selected The Roomtype");
	}

	public void setNumberofroom(String num) {
		getNumberofrooms();
		if(webelementDisplayed(numberofrooms)){
			logger.info("Numberofroom All Ready Selected So Moved To Next Line");
		}else {
			selectByVisibleText(numberofrooms,num);
			logger.info("User Selected The Numberofroom");
		}
	}

	public void setIndate(String in) {
		getIndate();
		clear(indate);
		logger.info("User Cleared Old Indate");
		type(indate,in);
		logger.info("User Entered The New Indate");
	}

	public void SetOutdate(String out) {
		getOutdate();
		clear(outdate);
		logger.info("User Cleared Old Outdate");
		type(outdate,out);
		logger.info("User Entered The New Outdate");
	}

	public void setAdultroom(String adu) {
		getAdultroom();
		if(webelementDisplayed(adultroom)){
			logger.info("Adultroom All Ready Selected So Moved To Next Line");
		}else {
			selectByVisibleText(adultroom,adu);
			logger.info("User Selected The Adultroom");
		}
	}

	public void setChilderedroom(String chi) {
		getChilderenroom();
		if(webelementDisplayed(childerenroom)){
			logger.info("Childerenroom All Ready Selected So Moved To Next Line");
		}else {
			selectByVisibleText(childerenroom,chi);
			logger.info("User Selected The Childerenroom");
		}
	}

	public void setSearch() {
		getSearch();
		btnClick(search);
		logger.info("User Clicked Search Button");
		webdriverVisibleWait(getSearchresult());
		//		webdriverVisibleWait(getLocationmandatory());
		//		webdriverVisibleWait(getNumberofroomsmandatory());
		//		webdriverVisibleWait(getIndatemandatory());
		//		webdriverVisibleWait(getOutdatemandatory());
		//		webdriverVisibleWait(getAdultmandatory());
		if(webelementDisplayed(searchresult)) {
			captureScreenshot1(ldriver,"User Search Pass");
			Assert.assertTrue(true);
			logger.info("User Hotel Search Success And Pass Snap Capture");
		}else if(webelementDisplayed(locationmandatory)) {
			captureScreenshot2(ldriver,"User Search Fail Due To Location Invalid");
			logger.info("User Didnot Selected The Location Or Location Is Missing Please Select Valid Location And Snap Capture");
			try {
				getLocation();
				selectByIndex(location, 1);
				logger.info("User Not Selected Location So Tried By Index");
			}catch(Exception e) {
				e.printStackTrace();
				logger.info("Unable To Select Location Using Index");
			}
			Assert.assertTrue(false);
		}else if(webelementDisplayed(numberofroomsmandatory)) {
			captureScreenshot2(ldriver,"User Search Fail Due To Numberofrooms Invalid");
			logger.info("User Didnot Selected The Numberofroom Or Numberofroom Is Missing Please Select Valid Numberofrooms And Snap Capture");
			try {
				getNumberofrooms();
				selectByIndex(location, 1);
				logger.info("User Not Selected Numberofroom So Tried By Index");
			}catch(Exception e) {
				e.printStackTrace();
				logger.info("Unable To Select Numberofroom Using Index");
			}
			Assert.assertTrue(false);
		}else if(webelementDisplayed(indatemandatory)) {
			captureScreenshot2(ldriver,"User Search Fail Due To Indate Invalid");
			logger.info("User Didnot Selected The Indate Or Indate Is Missing Please Select Valid Indate And Snap Capture");
			try {
				getIndate();
				type(indate,"24/12/2023");
				logger.info("User Not Selected Indate So Tried By Sendkey");
			}catch(Exception e) {
				e.printStackTrace();
				logger.info("Unable To Select Indate Using Senkey");
			}
			Assert.assertTrue(false);
		}else if(webelementDisplayed(outdatemandatory)) {
			captureScreenshot2(ldriver,"User Search Fail Due To Outdate Invalid");
			logger.info("User Didnot Selected The Outdate Or Outdate Is Missing Please Select Valid Outdate And Snap Capture");
			try {
				getOutdate();
				type(indate,"25/12/2023");
				logger.info("User Not Selected Outdate So Tried By Sendkey");
			}catch(Exception e) {
				e.printStackTrace();
				logger.info("Unable To Select Outdate Using Senkey");
			}
			Assert.assertTrue(false);
		}else if(webelementDisplayed(adultmandatory)) {
			captureScreenshot2(ldriver,"User Search Fail Due To Adultroom Invalid");
			logger.info("User Didnot Selected The Adultroom Or Adultroom Is Missing Please Select Valid adultroom And Snap Capture");
			try {
				getAdultroom();
				selectByIndex(location, 1);
				logger.info("User Not Selected Adultroom So Tried By Index");
			}catch(Exception e) {
				e.printStackTrace();
				logger.info("Unable To Select Adultroom Using Index");
			}
			Assert.assertTrue(false);
		}else {
			captureScreenshot2(ldriver,"User Search Fail");
			setReset();
			Assert.assertTrue(false);
			logger.info("User Search Hotel Failed And Snap Capture");
		}
	}

	public void setReset() {
		getReset();
		btnClick(reset);
		logger.info("User Clicked Reset Button");
	}

}




