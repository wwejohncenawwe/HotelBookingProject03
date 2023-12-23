package com.hotel.pojoclass;

import com.hotel.baseclass.BaseClass;

public class PojoManager extends BaseClass{

	RegisterPojo register;
	LoginPojo login;
	LogoutPojo logout;
	SearchPojo search;
	CancelPojo cancel;

	public RegisterPojo getRegister() {
		return(register==null)? register=new RegisterPojo(driver):register;
	}

	public LoginPojo getLogin() {
		return(login==null)? login=new LoginPojo(driver):login;
	}
	
	public SearchPojo getSearch() {
		return(search==null)? search=new SearchPojo(driver):search;
	}
	
	public CancelPojo getCancel() {
		return(cancel==null)? cancel=new CancelPojo(driver):cancel;
	}
	
	public LogoutPojo getLogout() {
		return(logout==null)? logout=new LogoutPojo(driver):logout;
	}

}
