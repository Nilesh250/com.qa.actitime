package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverScript {

	public static WebDriver driver;
	public static Properties prop;

	public DriverScript() {
		try {
			File file = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load the Properties file" + e.getMessage());
		}
	}

	public static void initBrowser() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/nileshoza/Documents/DRIVER/geckodriver");
			driver = new FirefoxDriver();

		} else {
			System.out.println("No Browser Specified Properly");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		String url = prop.getProperty("qaurl");
		driver.get(url);

	}

}
