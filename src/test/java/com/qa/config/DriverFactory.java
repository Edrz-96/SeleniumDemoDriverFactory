package com.qa.config;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	public static WebDriver returnDriver() throws Exception {

		String driver = System.getProperty("browser", "chrome");
		Map<String, Object> prefs = new HashMap<String, Object>();

		switch (driver.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			prefs.put("download.default_directory", "target");
			prefs.put("profile.default_content_setting_values.cookies", 2);
			prefs.put("network.cookie.cookieBehavior", 2);
			prefs.put("profile.block_third_party_cookies", true);
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.setExperimentalOption("prefs", prefs);
			caps.setCapability(ChromeOptions.CAPABILITY, cOptions);

			return new ChromeDriver(cOptions);

		default:
			throw new Exception("Unsupported Driver " + driver);
		}
	}
}