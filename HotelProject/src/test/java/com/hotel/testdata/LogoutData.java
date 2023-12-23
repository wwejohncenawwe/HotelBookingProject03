package com.hotel.testdata;

import org.testng.annotations.DataProvider;

import com.hotel.utility.ReadExcel;

public class LogoutData {

	String[][] Data=null;

	String path="C:\\Users\\Mani\\git\\HotelBookingProject03\\HotelProject\\src\\test\\java\\com\\hotel\\testdata\\TC02.xlsx";

	@DataProvider(name="logout")
	public String[][] getData(){
		Data=getExcelData();
		return Data;
	}

	public String[][] getExcelData() {
		int rowcount=ReadExcel.getRowCount(path,"logout");
		int cellcount=ReadExcel.getCellCount(path,"logout", rowcount);
		String datavalue[][]=new String[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<cellcount;j++) {
				datavalue[i-1][j]=ReadExcel.getCellData(path,"logout", i, j);
			}
		}
		return datavalue;
	}
}	



