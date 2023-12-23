package com.hotel.testcase;

import org.testng.annotations.Test;

import com.hotel.baseclass.BaseClass;
import com.hotel.pojoclass.PojoManager;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTestcase extends BaseClass{

	@Test(dataProvider="login",dataProviderClass=com.hotel.testdata.LoginData.class)
	@Epic("Login Flow")
	@Feature("Login Form")
	@Story("User Enters Valid Username And Password")
	@Owner("Baby")
	@Severity(SeverityLevel.MINOR)
    @Description("Test That Verifies A User Enter The Page With Valid Logging Details")
	public void loginTC(String uname,String pword) {

		PojoManager pojo=new PojoManager();

		
		pojo.getLogin().setVerifyhotelpage();

		pojo.getLogin().setUsername(uname);

		pojo.getLogin().setPassword(pword);

		pojo.getLogin().setLogin();

	}

}
