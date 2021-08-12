package com.revature.cucumber.steps;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.revature.cucumber.CandyWHRunner;
import com.revature.cucumber.pages.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagerStepImpl {

	public static CandyWHPage cMain = CandyWHRunner.cMain;
	public static LoginPage loginPage = CandyWHRunner.loginPage;
	public static ManagerPage managerPage = CandyWHRunner.managerPage;
	public static WebDriver driver = CandyWHRunner.driver;
	
	@When("^The User inputs a manager email and password$")
	public void the_User_inputs_a_manager_email_and_password() throws Throwable {
	    loginPage.emailInput.sendKeys("mwest@gmail.com");
	    loginPage.passwordInput.sendKeys("pass");
	}

	@When("^The User clicks the manager link$")
	public void the_User_clicks_the_manager_link() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    cMain.managerLink.click();
	}

	@Then("^The User should be on the manager page$")
	public void the_User_should_be_on_the_manager_page() throws Throwable {
		assertEquals("http://localhost:4200/manager", driver.getCurrentUrl());
	}
	
	@When("^The User clicks the employees button$")
	public void the_User_clicks_the_employees_button() throws Throwable {
	    managerPage.employeeButton.click();
	}

	@When("^The User clicks the orders button$")
	public void the_User_clicks_the_orders_button() throws Throwable {
	    managerPage.orderButton.click();
	}
	
}
