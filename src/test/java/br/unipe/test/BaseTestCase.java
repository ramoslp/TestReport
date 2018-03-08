package br.unipe.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import br.unipe.common.Property;
import br.unipe.common.Selenium;
import br.unipe.reports.ExtentUtil;

public class BaseTestCase {
	
	protected static WebDriver driver;
	protected static Property property;

	@BeforeClass
	public static void setUp() {
		if(ExtentUtil.getExtentReports() == null) {
			ExtentUtil.createReporter("extentreports.html");
		}
		Property.loadProperties();
		driver = Selenium.getDriver();
		driver.get(Property.SITE_ADDRESS);
	}
	
	@AfterClass
	public static void tearDown() {
		ExtentUtil.saveReporter();
		Selenium.resetDriver();
		driver.quit();
	}
	
	@Rule
	public final TestRule testRule = new TestWatcher() {
		@Override
		protected void succeeded(Description description) {
			ExtentUtil.fetchTest().pass("Sucesso");
		}
		
		@Override
		protected void failed(Throwable e, Description description) {
			try {
				ExtentUtil.fetchTest().fail("Falhou").addScreenCaptureFromPath("images/car.png");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		@Override
		protected void skipped(AssumptionViolatedException e, Description description) {
			
		}
		
		@Override
		protected void starting(Description description) {
			ExtentUtil.createTest(description.getMethodName());
		}
		
		@Override
		protected void finished(Description description) {
			
		}
	};
	
}