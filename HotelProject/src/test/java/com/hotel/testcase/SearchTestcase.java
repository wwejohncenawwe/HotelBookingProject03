package com.hotel.testcase;

import org.testng.annotations.Test;

import com.hotel.baseclass.BaseClass;
import com.hotel.pojoclass.PojoManager;

public class SearchTestcase extends BaseClass{

	@Test(dataProvider="search",dataProviderClass=com.hotel.testdata.SearchData.class)
	public void loginTC(String uname,String pword,String loc,String hot,String roo,String num,String in,String out,String adu,String chi) {

		PojoManager pojo=new PojoManager();


		pojo.getSearch().setVerifyhotelpage();

		pojo.getSearch().setUsername(uname);

		pojo.getSearch().setPassword(pword);

		pojo.getSearch().setLogin();

		pojo.getSearch().setVerifysearchpage();

		pojo.getSearch().setLocation(loc);

		pojo.getSearch().setHotel(hot);

		pojo.getSearch().setRoomtype(roo);

		pojo.getSearch().setNumberofroom(num);

		pojo.getSearch().setIndate(in);

		pojo.getSearch().SetOutdate(out);

		pojo.getSearch().setAdultroom(adu);

		pojo.getSearch().setChilderedroom(chi);

		pojo.getSearch().setSearch();


	}
}
