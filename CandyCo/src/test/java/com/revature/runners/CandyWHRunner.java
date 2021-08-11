package com.revature.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.CandyWHMain;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.revature.steps")
public class CandyWHRunner {

	public static WebDriver driver;
	public static CandyWHMain cMain;
	
	@BeforeClass
	public static void setUp() {
		String path = "C:/Users/seanl/Documents/Revature/GitLab_Repository/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		cMain = new CandyWHMain(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
}
