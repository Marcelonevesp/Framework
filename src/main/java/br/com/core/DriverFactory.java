package br.com.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}

	public static WebDriver getDriver () {
		if (driver == null) {
			switch (Propriedades.browser) {
			case CHROME: driver = new ChromeDriver(); break;
			case FIREFOX: driver = new FirefoxDriver(); break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
