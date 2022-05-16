package com.qa.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.qa.config.DriverFactory;

public class GoogleTest {
	private static WebDriver driver;

	@BeforeClass
	public static void init() throws Exception {
		driver = DriverFactory.returnDriver();
		driver.manage().window().setSize(new Dimension(500, 500));
	}

	@Before
	public void setUp() {
		driver.get("https://www.google.com/");
	}

	@Test
	public void testOne() throws InterruptedException {
		Thread.sleep(1000);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
