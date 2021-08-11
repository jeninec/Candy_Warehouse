package com.revature.steps;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

import com.revature.pages.CandyWHMain;
import com.revature.runners.CandyWHRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class CandyWHStepImpl {

	public static CandyWHMain cMain = CandyWHRunner.cMain;
	public static WebDriver driver = CandyWHRunner.driver;
	
}
