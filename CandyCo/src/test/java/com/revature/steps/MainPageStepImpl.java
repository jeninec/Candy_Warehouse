package com.revature.steps;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import com.revature.runners.CandyWHRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.revature.pages.*;

public class MainPageStepImpl {
	
	public static MainPage mainPage = CandyWHRunner.mainPage;
	public static LoginPage loginPage = CandyWHRunner.loginPage;
	public static WebDriver driver = CandyWHRunner.driver;
	

	@Given("^The User is on the home page$")
	public void the_User_is_on_the_home_page() throws Throwable {
		driver.get("http://localhost:4200/home");
	}
	
	@When("^The User clicks on the login link$")
	public void the_User_clicks_on_the_login_link() throws Throwable {
	    mainPage.loginLink.click();
	}
	
	@When("^The User inputs an admin email and password$")
	public void the_User_inputs_an_admin_email_and_password() throws Throwable {
	    loginPage.emailInput.sendKeys("mwest@gmail.com");
	    loginPage.passwordInput.sendKeys("pass");
	}
	
	@When("^The User clicks the login button$")
	public void the_User_clicks_the_login_button() throws Throwable {
	    loginPage.loginButton.click();
	}
	
	@When("^The User clicks the admin link$")
	public void the_User_clicks_the_admin_link() throws Throwable {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    mainPage.adminLink.click();
	}
	
	@Then("^The User should be on the admin page$")
	public void the_User_should_be_on_the_admin_page() throws Throwable {
		assertEquals("http://localhost:4200/admin", driver.getCurrentUrl());
	}
	
	@When("^The User go to the edit user page$")
	public void the_User_go_to_the_edit_user_page() throws Throwable {
	    driver.get("http://localhost:4200/editUser/1");
	}

	@Then("^The User should be on the edit user page$")
	public void the_User_should_be_on_the_edit_user_page() throws Throwable {
		assertEquals("http://localhost:4200/editUser/1", driver.getCurrentUrl());
	}

	@When("^The User inputs a manager email and password$")
	public void the_User_inputs_a_manager_email_and_password() throws Throwable {
		loginPage.emailInput.sendKeys("vshef@gmail.com");
	    loginPage.passwordInput.sendKeys("pass");
	}

	@When("^The User clicks the manager link$")
	public void the_User_clicks_the_manager_link() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mainPage.managerLink.click();
	}

	@Then("^The User should be on the manager page$")
	public void the_User_should_be_on_the_manager_page() throws Throwable {
		assertEquals("http://localhost:4200/manager", driver.getCurrentUrl());
	}

	@When("^The User inputs an employee email and password$")
	public void the_User_inputs_an_employee_email_and_password() throws Throwable {
		loginPage.emailInput.sendKeys("kmoli@gmail.com");
	    loginPage.passwordInput.sendKeys("pass");
	}

	@When("^The User clicks the employee link$")
	public void the_User_clicks_the_employee_link() throws Throwable {
	    mainPage.employeeLink.click();
	}

	@Then("^The User should be on the employee page$")
	public void the_User_should_be_on_the_employee_page() throws Throwable {
		assertEquals("http://localhost:4200/employee", driver.getCurrentUrl());
	}

	@When("^The User inputs an user email and password$")
	public void the_User_inputs_an_user_email_and_password() throws Throwable {
		loginPage.emailInput.sendKeys("kharb@gmail.com");
	    loginPage.passwordInput.sendKeys("pass");
	}

	@When("^The User clicks the user link$")
	public void the_User_clicks_the_user_link() throws Throwable {
	    mainPage.userLink.click();
	}

	@Then("^The User should be on the user page$")
	public void the_User_should_be_on_the_user_page() throws Throwable {
		assertEquals("http://localhost:4200/user", driver.getCurrentUrl());
	}
}
