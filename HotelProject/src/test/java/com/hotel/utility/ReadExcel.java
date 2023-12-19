package com.hotel.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static FileInputStream fs;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile,String xlsheet) {
		try {
			fs=new FileInputStream(xlfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb=new XSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	public static int getCellCount(String xlfile,String xlsheet,int rownum) {
		try {
			fs=new FileInputStream(xlfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb=new XSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cellcount;
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) {
		try {
			fs=new FileInputStream(xlfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb=new XSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		CellType type =cell.getCellType();
		String Data;
		switch (type) {
		case STRING:
			Data=cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)){
				Date datecellvalue=cell.getDateCellValue();
				SimpleDateFormat formatter=new SimpleDateFormat("dd-mm-yyyy");
				Data=formatter.format(datecellvalue);
			}
			else {
				double numericcellvalue=cell.getNumericCellValue();
				long l=(long)numericcellvalue;
				Data=String.valueOf(l);
			}
			break;
		default:Data=" ";
		break;
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Data;
	}
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) {
		try {
			fs=new FileInputStream(xlfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb=new XSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		try {
			fo=new FileOutputStream(xlfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}




	}







}
