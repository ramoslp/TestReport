package br.unipe.common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.unipe.common.Property;

public class Selenium {
	
	private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		String browser = Property.BROWSER_NAME;
		if (driver == null) {
			if(Browser.FIREFOX.equals(browser)) {
				File file = new File(Property.FIREFOX_DRIVE_PATH);
				System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
				
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	
	public static void resetDriver() {
		driver = null;
	}

}