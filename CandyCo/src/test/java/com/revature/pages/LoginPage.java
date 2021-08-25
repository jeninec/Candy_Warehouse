package com.revature.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	protected WebDriver webdriver;
	
	@FindBy(id = "inputEmail")
	public WebElement emailInput;
	
	@FindBy(id = "inputPass")
	public WebElement passwordInput;
	
	@FindBy(id = "loginButton")
	public WebElement loginButton;
	
	@FindBy(id = "logoutButton")
	public WebElement logoutButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.webdriver = driver;
	}
	
}