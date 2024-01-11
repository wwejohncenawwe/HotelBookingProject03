package com.hotel.testcase;

import org.testng.annotations.Test;

import com.hotel.baseclass.BaseClass;
import com.hotel.pojoclass.PojoManager;


public class RegisterTestcase extends BaseClass{

	@Test(dataProvider="register",dataProviderClass=com.hotel.testdata.RegisterData.class)
	public void testCase01(String uname,String pword,String cpword,String fname,String email) throws Exception {

		PojoManager pojo = new PojoManager();

		pojo.getRegister().setRegisterLink();

		pojo.getRegister().setRegisterLinkVerify();

		pojo.getRegister().setUsername(uname);

		pojo.getRegister().setPassword(pword);

		pojo.getRegister().setCpassword(cpword);

		pojo.getRegister().setFullname(fname);

		pojo.getRegister().setEmailid(email);

		pojo.getRegister().setCaptchaimg();

		pojo.getRegister().setCaptchatype(pojo.getRegister().imgvalue);

		pojo.getRegister().setTerms();
		
		pojo.getRegister().setRegisterbtn();

		pojo.getRegister().setResetbtn();

	}
}
