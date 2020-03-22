package StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pageObjects.AddCustomerPage;
import com.pageObjects.LoginPage;
import com.pageObjects.SearchCustomerPage;

public class Base {
	
	public  WebDriver Idriver;
	
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	public Properties configProp;
	
	
//To generete random string for Unique email id
	public static String randomestring() {
		
		String generetedString1 = RandomStringUtils.randomAlphabetic(5);
		
		return(generetedString1);
	}	


}
