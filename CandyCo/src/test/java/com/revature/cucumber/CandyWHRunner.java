package com.revature.cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.cucumber.pages.*;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.revature.cucumber.steps",
plugin = { "pretty" })
public class CandyWHRunner {

	public static WebDriver driver;
	public static CandyWHPage cMain;
	public static LoginPage loginPage;
	
	@BeforeClass
	public static void setUp() {
		String path = "C:/Users/seanl/Documents/Revature/GitLab_Repository/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		cMain = new CandyWHPage(driver);
		loginPage = new LoginPage(driver);
	}
	
//	@AfterClass
//	public static void tearDown() {
//		driver.quit();
//	}
	
}