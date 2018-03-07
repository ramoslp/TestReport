package br.unipe.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public abstract class Property {

	public static String FIREFOX_DRIVE_PATH;
	public static String BROWSER_NAME;
	public static String SITE_ADDRESS;
	
	public static Properties propConfigTeste;
	private static final String PROP_FILE_CONFIG = "src/test/resources/config.properties";
	
	public static Properties getConfig() {
		Properties propConfigTeste = null;
		try {
			FileInputStream fileInputStream = null;
			File file = new File(PROP_FILE_CONFIG);
			if(file.exists()) {
				propConfigTeste = new Properties();
				fileInputStream = new FileInputStream(file);
				propConfigTeste.load(fileInputStream);
				fileInputStream.close();
			}
		}catch (Exception e) {
			System.err.println(e);
		}
		return propConfigTeste;
	}
	
	public static void loadProperties() {
		Properties properties = getConfig();
		FIREFOX_DRIVE_PATH = new File("").getAbsolutePath()
				+ "/src/test/resources/driver/windows/geckodriver.exe";
		BROWSER_NAME = properties.getProperty("browser.name");
		SITE_ADDRESS = properties.getProperty("site.address");
	}
}