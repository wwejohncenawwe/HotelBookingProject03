package com.hotel.testcase;

import org.testng.annotations.Test;

import com.hotel.baseclass.BaseClass;
import com.hotel.pojoclass.RegisterPojo;


public class RegisterTestcase01 extends BaseClass{

	@Test
	public void testCase01() throws Exception {
		RegisterPojo reg=new RegisterPojo(driver);
		reg.setRegisterLink();
		reg.setRegisterLinkVerify();
		Thread.sleep(2000);
		reg.setUsername("user");
		reg.setPassword("pass");
		reg.setCpassword("cpass");
		reg.setFullname("full");
		reg.setEmailid("emailgmail@gmail.com");
		reg.setCaptchaimg();
		reg.setCaptchatype(reg.imgvalue);
		reg.setTerms();
		Thread.sleep(2000);
//		reg.setResetbtn();
	}
}
