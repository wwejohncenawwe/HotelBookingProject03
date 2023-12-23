package com.hotel.testcase;

import org.testng.annotations.Test;

import com.hotel.baseclass.BaseClass;
import com.hotel.pojoclass.PojoManager;

public class CancelTestcase  extends BaseClass{

	@Test(dataProvider="cancel",dataProviderClass=com.hotel.testdata.CancelData.class)
	public void loginTC(String uname,String pword,String loc,String hot,String roo,String num,String in,String out,String adu,String chi) {

		PojoManager pojo=new PojoManager();

		pojo.getCancel().setVerifyhotelpage();

		pojo.getCancel().setUsername(uname);

		pojo.getCancel().setPassword(pword);

		pojo.getCancel().setLogin();

		pojo.getCancel().setVerifysearchpage();

		pojo.getCancel().setLocation(loc);

		pojo.getCancel().setHotel(hot);

		pojo.getCancel().setRoomtype(roo);

		pojo.getCancel().setNumberofroom(num);

		pojo.getCancel().setIndate(in);

		pojo.getCancel().SetOutdate(out);

		pojo.getCancel().setAdultroom(adu);

		pojo.getCancel().setChilderedroom(chi);

		pojo.getCancel().setSearch();

		pojo.getCancel().SetSelecthotel();

		pojo.getCancel().setCancelhotel();

	}
}
