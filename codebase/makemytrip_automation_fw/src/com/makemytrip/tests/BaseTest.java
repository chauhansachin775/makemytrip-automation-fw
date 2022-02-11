//author : sachin singh chauhan

package com.makemytrip.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.makemytrip.utilities.Utility;

public class BaseTest {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
		
	}
	
	@BeforeSuite
	public void initializeUtilities() throws IOException {
		Utility.initializePropertiesFile();
		Utility.initializeExcelFile();
	}
	
	@BeforeMethod
	public void intitializeBrowser() {
		String browserName = Utility.readProperty("browserName");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Utility.readProperty("chromeDriverPath"));
			ChromeOptions opt = new ChromeOptions();
			opt.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			//opt.addArguments("enable-automation");
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			opt.setExperimentalOption("prefs", prefs);
			
				driver = new ChromeDriver(opt);
				driver.manage().window().maximize();
		}
	}
	
	@BeforeMethod (dependsOnMethods = "intitializeBrowser")
	public void launchApplication() {
		String url = Utility.readProperty("url");
		driver.get(url);
	}
	

}
