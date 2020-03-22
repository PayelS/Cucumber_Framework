package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver Idriver;
	
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver driver) {
		
		Idriver = driver;
		
		PageFactory.initElements(Idriver, this);
		
		waithelper = new WaitHelper(Idriver);
	}
	
	@FindBy(id="SearchEmail") WebElement txtEmail;
	@FindBy(id="SearchFirstName") WebElement txtFirstName ;
	@FindBy(id="SearchLastName") WebElement txtLastName ;
	
	@FindBy(id="SearchMonthOfBirth")  WebElement drpdobmonth;
	@FindBy(id="SearchDayOfBirth")  WebElement drpdobday;
	
	@FindBy(id="SearchCompany")  WebElement txtCompany;
	
	@FindBy(id="search-customers") WebElement btnSearch;
	
	@FindBy(xpath="//table[@role='grid']") WebElement tblSearchResults;
	@FindBy(xpath="//table[@id='customers-grid']") WebElement table;

	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")  List<WebElement> tableRows;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")  List<WebElement> tableColumns;

	public void setEmail(String email) {
	waithelper.WaitForElement(txtEmail, 20);
	txtEmail.clear();
	txtEmail.sendKeys(email);
	}
	
	
	public void setFirstName(String fname) {
		
		waithelper.WaitForElement(txtEmail, 20);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
		
		
	}
	
	public void setLastName(String lname) {
		
		waithelper.WaitForElement(txtEmail, 20);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
		
		
	}
	
	public void clickSearch() {
		
		btnSearch.click();
		waithelper.WaitForElement(txtEmail, 20);
		
	}
	
	public int getNoOfRow() {
		return(tableRows.size());
	}
	
	public int getNoOfColumn() {
		return(tableColumns.size());
		
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag = false;
		
		for(int i=1;i<getNoOfRow();i++) {
			
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			
			if(emailid.equals(email))
			{
				flag=true;
			}
		}
		return flag;
	}



}
