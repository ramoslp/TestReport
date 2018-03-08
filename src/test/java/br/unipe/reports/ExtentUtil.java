package br.unipe.reports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentUtil {
	
	private static ExtentReports extentReports = null;
	private static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	
	public static ExtentReports createReporter(String filename) {
		//HTML Reporter
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(filename);
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
		extentHtmlReporter.config().setReportName("Sample ExtentReports with JUnit");
		extentHtmlReporter.config().setChartVisibilityOnOpen(true);
		
		//ExtentX Reporter
//		ExtentXReporter extentXReporter = new ExtentXReporter("localhost");
//		extentXReporter.config().setServerUrl("http://localhost:1337");
//		extentXReporter.config().setReportName("Sample ExtentXReporter");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		
		//System Info
//		try {
//			extentReports.setSystemInfo("HostName", InetAddress.getLocalHost().getHostName());
//            extentReports.setSystemInfo("IP Address",InetAddress.getLocalHost().getHostAddress());
//            extentReports.setSystemInfo("OS",System.getProperty("os.name"));
//            extentReports.setSystemInfo("UserName",System.getProperty("user.name"));
//            extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		
		return extentReports;
	}
	
	public static ExtentReports getExtentReports() {
		return extentReports;
	}
	
	public static void saveReporter() {
		if(extentReports != null) {
			extentReports.flush();
		}
	}
	
	public static synchronized ExtentTest createTest(String testname) {
		ExtentTest extentTest = extentReports.createTest(testname);
		extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
		return extentTest;
	}
	
	public static synchronized ExtentTest createTest(String testname, String testdesc) {
		ExtentTest extentTest = extentReports.createTest(testname, testdesc);
		extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
		return extentTest;
	}
	
	public static synchronized ExtentTest fetchTest() {
		return extentTestMap.get((int) (Thread.currentThread().getId()));
	}

}