package br.unipe.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.unipe.common.Property;
import br.unipe.common.Selenium;

public class BaseTestCase {
	
	protected static WebDriver driver;
	protected static Property property;

	@BeforeClass
	public static void getDriver() {
		Property.loadProperties();
		driver = Selenium.getDriver();
		driver.get(Property.SITE_ADDRESS);
	}
	
	@AfterClass
	public static void finalizar() {
		Selenium.resetDriver();
		driver.quit();
	}
	
}