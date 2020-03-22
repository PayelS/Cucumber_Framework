package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver Idriver;
	
	public LoginPage(WebDriver driver) {
		
		Idriver = driver;
				
		PageFactory.initElements(Idriver, this);		
	}
	
	@FindBy(id="Email") WebElement txtEmail;
	
	@FindBy(id="Password") WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log in']") WebElement btnLogin;
	@FindBy(linkText="Logout") WebElement Logout;
	
	
	public void setUserName(String uName) {
		
		txtEmail.clear();
		txtEmail.sendKeys(uName);
	}
	
	public void setPassword(String pwd) {
		
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		
		btnLogin.click();
	}
	
	public void clickLogout() {
		
		Logout.click();
	}




}
