package com.revature.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage {

	protected WebDriver webdriver;
	
	@FindBy(id = "firstNameInput")
	public WebElement firstNameInput;
	
	@FindBy(id = "lastNameInput")
	public WebElement lastNameInput;
	
	@FindBy(id = "emailInput")
	public WebElement emailInput;
	
	@FindBy(id = "passwordInput")
	public WebElement passwordInput;
	
	@FindBy(id = "address1Input")
	public WebElement adress1Input;
	
	@FindBy(id = "address2Input")
	public WebElement adress2Input;
	
	@FindBy(id = "cityInput")
	public WebElement cityInput;
	
	@FindBy(id = "stateInput")
	public WebElement stateInput;
	
	@FindBy(id = "zipInput")
	public WebElement zipInput;
	
	@FindBy(id = "phoneInput")
	public WebElement phoneInput;
	
	@FindBy(id = "titleInput")
	public WebElement titleInput;
	
	@FindBy(id = "updateButton")
	public WebElement updateButton;
	
	@FindBy(id = "deleteButton")
	public WebElement deleteButton;
	
	public EditUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.webdriver = driver;
	}
	
}
