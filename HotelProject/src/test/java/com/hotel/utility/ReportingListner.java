package com.hotel.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingListner extends TestListenerAdapter{



	public ExtentSparkReporter htmlreporter;
	public ExtentReports reports;
	public ExtentTest test;

	public void onStart(ITestContext testcontext) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname = "Test-Report-"+timestamp+".html";
		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+repname);
		try {
			htmlreporter.loadXMLConfig(System.getProperty("user.dir")+ "./extent-config.xml");

		} catch (IOException e) {
			e.printStackTrace();
		}
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("Host name","localhost");
		reports.setSystemInfo("Environment","Qa");
		reports.setSystemInfo("user","Baby");

		htmlreporter.config().setDocumentTitle("Adactin Hotel Project");
		htmlreporter.config().setReportName("Functional Testing");
		//		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {
		test = reports.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		String screenshotpath = System.getProperty("user.dir")+"/Reports/"+tr.getName()+".png";
		File file = new File(screenshotpath);
		if (file.exists()) {
			test.fail("screenshot is below: "+test.addScreenCaptureFromPath(screenshotpath));
		}
	}

	public void onTestFailure(ITestResult tr) {
		test = reports.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotpath = System.getProperty("user.dir")+"/Reports/"+tr.getName()+".png";
		File file = new File(screenshotpath);
		if (file.exists()) {
			test.fail("screenshot is below: "+test.addScreenCaptureFromPath(screenshotpath));
		}
	}

	public void onTestSkipped(ITestResult tr) {
		test = reports.createTest(tr.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testcontext) {
		reports.flush();
	}
}


