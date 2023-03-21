package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {

	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustomerOpt;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement enterCustomerNameTbx;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement enterCustomerDescrition;
	
	@FindBy(xpath="(//div[text()='- Select Customer -'])[1]")
	private WebElement selectCustomerDD;
	
@FindBy(xpath="//div[text()='Our company' and @class='itemRow cpItemRow ']")
private WebElement ourCompanyTx;

@FindBy(xpath="//div[text()='Create Customer']")
private WebElement createCustomerBtn;
	
@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
private WebElement actualCustomerCreated;
	
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getAddNewBtn() {
		return addNewBtn;
	}


	public WebElement getNewCustomerOpt() {
		return newCustomerOpt;
	}


	public WebElement getEnterCustomerNameTbx() {
		return enterCustomerNameTbx;
	}


	public WebElement getEnterCustomerDescrition() {
		return enterCustomerDescrition;
	}


	public WebElement getSelectCustomerDD() {
		return selectCustomerDD;
	}


	public WebElement getOurCompanyTx() {
		return ourCompanyTx;
	}


	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}


	public WebElement getActualCustomerCreated() {
		return actualCustomerCreated;
	}

	
	
	
}




