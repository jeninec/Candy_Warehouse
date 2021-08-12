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

public class AdminStepImpl {

	public static CandyWHPage cMain = CandyWHRunner.cMain;
	public static LoginPage loginPage = CandyWHRunner.loginPage;
	public static EditUserPage editUserPage = CandyWHRunner.editUserPage;
	public static WebDriver driver = CandyWHRunner.driver;
	
	
	@Given("^The User is on the home page$")
	public void the_User_is_on_the_home_page() throws Throwable {
		driver.get("http://localhost:4200/home");
	}

	@When("^The User clicks on the login link$")
	public void the_User_clicks_on_the_login_link() throws Throwable {
	    cMain.loginLink.click();
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
	    cMain.adminLink.click();
	}
	
	@Then("^The User should be on the admin page$")
	public void the_User_should_be_on_the_admin_page() throws Throwable {
		assertEquals("http://localhost:4200/admin", driver.getCurrentUrl());
	}
	
	@When("^The User goes to the edit user page$")
	public void the_User_goes_to_the_edit_user_page() throws Throwable {
	    driver.get("http://localhost:4200/editUser/1");
	}

	@Then("^The User should be on the edit user page$")
	public void the_User_should_be_on_the_edit_user_page() throws Throwable {
		assertEquals("http://localhost:4200/editUser/1", driver.getCurrentUrl());
	}

	@When("^The User clicks the update user button$")
	public void the_User_clicks_the_update_user_button() throws Throwable {
	    editUserPage.updateButton.click();
	}

	@When("^The User clicks the delete user button$")
	public void the_User_clicks_the_delete_user_button() throws Throwable {
	    editUserPage.deleteButton.click();
	}


}
