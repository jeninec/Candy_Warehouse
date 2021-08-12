package com.revature.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage {

	protected WebDriver webdriver;
	
	@FindBy(id = "employeesButton")
	public WebElement employeeButton;
	
	@FindBy(id = "itemButton")
	public WebElement itemButton;
	
	@FindBy(id = "orderButton")
	public WebElement orderButton;
	
	@FindBy(id = "addItemButton")
	public WebElement addItemButton;
	
	@FindBy(id = "submitButton")
	public WebElement submitButton;
	
	@FindBy(id = "itemNameInput")
	public WebElement itemNameInput;
	
	@FindBy(id = "itemCategoryInput")
	public WebElement itemCategoryInput;
	
	@FindBy(id = "itemPriceInput")
	public WebElement itemPriceInput;
	
	@FindBy(id = "itemQuantityInput")
	public WebElement itemQuantityInput;
	
	@FindBy(id = "itemDescriptionInput")
	public WebElement itemDescriptionInput;
	
	@FindBy(id = "itemImgSrcInput")
	public WebElement itemImgSrcInput;
	
	public ManagerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.webdriver = driver;
	}
}
