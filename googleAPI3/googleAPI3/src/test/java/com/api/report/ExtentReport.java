package com.api.report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	private static ExtentReports report;
	private static ExtentTest logger;

	public static void report()
	{
		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/testReport.html");

	}
	
	public static void startTest(String desc)
	{
		logger=report.startTest(desc);
	}

	public static void statusPass(LogStatus pass,String desc)
	{
		logger.log(LogStatus.PASS, desc);
	}

	public static void statusFail(LogStatus fail,String desc)
	{
		logger.log(LogStatus.FAIL, desc);
	}
	
	public static void endTest()
	{
		report.endTest(logger);
	}
	
	public static void flush()
	{
		report.flush();
	}

}
