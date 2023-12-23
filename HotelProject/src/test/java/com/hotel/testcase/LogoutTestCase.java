package com.hotel.testcase;

import org.testng.annotations.Test;

import com.hotel.baseclass.BaseClass;
import com.hotel.pojoclass.PojoManager;

public class LogoutTestCase extends BaseClass{


	@Test(dataProvider="logout",dataProviderClass=com.hotel.testdata.LogoutData.class)
	public void loginTC(String uname,String pword) {

		PojoManager pojo=new PojoManager();


		pojo.getLogout().setUsername(uname);

		pojo.getLogout().setPassword(pword);

		pojo.getLogout().setLogin();

		pojo.getLogout().setLogout();

	}

}


