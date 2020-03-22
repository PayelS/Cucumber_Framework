package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageObjects.AddCustomerPage;
import com.pageObjects.LoginPage;
import com.pageObjects.SearchCustomerPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base{
	@Before
	
	public void setup() throws IOException {
		logger = Logger.getLogger("Cucumber_Framework");
		PropertyConfigurator.configure("Log4j.properties");
		
		//Reading Property file
		configProp = new Properties();
		
		FileInputStream fis = new FileInputStream("config.properties");
		configProp.load(fis);

		
		
		
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Payel/Downloads/chromedriver");
				//System.getProperty("user.dir")+"/Users/Payel/Desktop/OwnFRM/Cucumber_Framework/Drivers/chromedriver.exe");
		
		Idriver = new ChromeDriver();
		}
		
		logger.info("******Lunching Browser*******");
		
		
	}
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		
		
		lp = new LoginPage(Idriver);
	   
	}

	@When("User opens {string}")
	public void user_opens(String url) {
	    
	Idriver.get(url);
	
	logger.info("******opening URL*******");
	//driver.manage().window().maximize();
	
	
	
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
		logger.info("******Getting Email & Password*******");    
	lp.setUserName(email);
	lp.setPassword(password);
	
	
	}

	@When("Click on Login")
	public void click_on_Login() {
		logger.info("******Click on LogIn*******");   
	lp.clickLogin();
	
	
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
	    
	if(Idriver.getPageSource().contains("Login was unsuccessful.")) {
		System.out.println("Login was Unsuccessful");
		
		Idriver.close();
		
		Assert.assertTrue(false);
	}else {
		
		Assert.assertEquals(title, Idriver.getTitle());
	}
	
	System.out.println("This is the page title: "+title);
	
	
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("******Clicking on LogOut*******");
		lp.clickLogout();
		Thread.sleep(3000);
	
	
	}

//	@Then("Page Title should be {string}")
//	public void page_Title_should_be(String string) {
//	    
//	}

	@Then("close browser")
	public void close_browser() {
		logger.info("******Closing Browser*******");
		
		Idriver.close();
	    
	}
	
	
	//Customers Feature's step definitions........................................
	
	
	@When("User can view Dasboard")
	public void user_can_view_Dasboard() {
	    //driver = new ChromeDriver();
		addCust = new AddCustomerPage(Idriver);
		
		String title = Idriver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Dashboard / nopCommerce administration", title);
	
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCutomersMenu();
	    
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCustomersItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
	
		String newCustomerPageTittle = addCust.getPageTitle();
		System.out.println(newCustomerPageTittle);
	Assert.assertEquals("Add a new customer / nopCommerce administration",newCustomerPageTittle );
	
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		logger.info("******Adding new Customer*******");
		
	    String email = randomestring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test1235");
		addCust.setCustomerRoles("Guest");
		Thread.sleep(2000);
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Female");
		addCust.setFirstName("Payel");
		addCust.setLastName("Shayan");
		addCust.setDob("7/05/1990");
		addCust.setCompanyName("QA");
		addCust.setAdmenContent("This is for testing.........");
	
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnSave();
	    
	}

	@Then("User can view confirmation messege {string}")
	public void user_can_view_confirmation_messege(String msg) throws InterruptedException {
		logger.info("******Confirmation Msg*******");
		Thread.sleep(3000);
	    Assert.assertTrue(Idriver.findElement(By.tagName("body")).getText()
	    		.contains("The new customer has been added successfully."));
	   
	}

//Customer Search by email-------------------------------------------------------
	
	@When("Enter customer Email")
	public void enter_customer_Email() {
		
		searchCust = new SearchCustomerPage(Idriver);
		
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	    
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		
		searchCust.clickSearch();
	    Thread.sleep(2000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
	    
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		
		Assert.assertEquals(true, status);
		
		
	
	
	}






}
