package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver Idriver;
	
	public AddCustomerPage(WebDriver driver) {
		
		Idriver = driver;
		
		PageFactory.initElements(Idriver, this);
		
	}
	
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	
	By btnAddnew = By.xpath("//a[@class='btn bg-blue']");  //add new
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	
	By txtcustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By listiteamAdministrators=By.xpath("li[contains(text(),'Administrators')]");
	By listitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By listitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By listitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");
	
	
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
	
	By txtAdminContent=By.id("AdminComment");//By.xpath("//textarea[@id='AdminCommet']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	//Actions methods
	
	public String getPageTitle() {
		return Idriver.getTitle();
	}
	
	public void clickOnCutomersMenu() {
		
		Idriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersItem() {
		
		Idriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		
		Idriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) {
		
		Idriver.findElement(txtEmail).sendKeys(email);
		
	}
	public void setPassword(String password) {
		
		Idriver.findElement(txtPassword).sendKeys(password);
		
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		
		if(!role.equals("Vendors")) 
		{
			Idriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		}
		Idriver.findElement(txtcustomerRoles).click();
		
		WebElement listitem;
		
		Thread.sleep(3000);
		
		if(role.equals("Administrators")) 
		{
			listitem=Idriver.findElement(listiteamAdministrators);
		}
		else if(role.equals("Guests")) 
		{
			listitem=Idriver.findElement(listitemGuests);
		}
		else if(role.equals("Registered")) 
		{
			listitem=Idriver.findElement(listitemRegistered);
		}
		else if(role.equals("Vendors")) 
		{
			listitem=Idriver.findElement(listitemVendors);
		}
		else 
		{
			listitem=Idriver.findElement(listitemGuests);
		}
		//listitem.click();
		
		JavascriptExecutor js = (JavascriptExecutor)Idriver;
		js.executeScript("arguments[0].click();", listitem);
	
	}
	
	public void setManagerOfVendor(String value) {
		Select drp=new Select(Idriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) 
		{
			Idriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("female")) 
		{
			Idriver.findElement(rdFemaleGender).click();
		}
		else 
		{
			Idriver.findElement(rdMaleGender).click();  //default
		}
	}
	
	public void setFirstName(String fname) {
		Idriver.findElement(txtFirstName).sendKeys(fname);
	}
	public void setLastName(String lname) {
		Idriver.findElement(txtLastName).sendKeys(lname);
	}
	public void setDob(String dob) {
		Idriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String comname) {
		Idriver.findElement(txtCompanyName).sendKeys(comname);
	}
	public void setAdmenContent(String content) {
		Idriver.findElement(txtAdminContent).sendKeys(content);
	}
	public void clickOnSave() {
		Idriver.findElement(btnSave).click();
	}


}
