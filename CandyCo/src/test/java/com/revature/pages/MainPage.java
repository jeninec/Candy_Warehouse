package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	protected WebDriver webdriver;
	
	@FindBy(id = "loginLink")
	public WebElement loginLink;
	
	@FindBy(id = "homeLink")
	public WebElement homeLink;
	
	@FindBy(id = "adminLink")
	public WebElement adminLink;
	
	@FindBy(id = "managerLink")
	public WebElement managerLink;
	
	@FindBy(id = "employeeLink")
	public WebElement employeeLink;
	
	@FindBy(id = "userLink")
	public WebElement userLink;
	
	@FindBy(id = "inventoryLink")
	public WebElement inventoryLink;
	
	@FindBy(id = "aboutLink")
	public WebElement aboutLink;
	
	public MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.webdriver = driver;
	}
	
}
