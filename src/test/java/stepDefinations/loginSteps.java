package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	WebDriver driver = null;
	Properties prop;
	loginPage loginObj;
	
	@Given("User Navigates to Modulr Payments")
	public void user_navigates_to_modulr_payments() throws IOException {
//to create a instance of properties file 
	 FileInputStream fis = new FileInputStream("C:\\Users\\AEPAC\\eclipse-workspace\\modulrfinance.com\\src\\test\\java\\utilitiesAndConfig\\config.properties");
	 prop = new Properties();
     prop.load(fis);  
     
//setting driver path     
	 System.setProperty("webdriver.chrome.driver","M:/chromedriver_win32/chromedriver.exe");	 
	 
//Initialization of driver	 
	 driver = new ChromeDriver();	
	 
//navigating to the modulrFinace site	 
	 driver.get(prop.getProperty("url"));
	 
//implicit wait
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
//Maximizing the window	 
	 driver.manage().window().maximize();	
	}

//Function to enter credentails in Modulr
	@When("^User enters username as (.*) and password as (.*)$")
	public void user_enters_and(String username, String password) {
		 loginObj = new loginPage(driver);	 
		 loginObj.enterCredentials(username, password);
	}

//Function to click signIn button
	@Then("^User click on sign In button$")
	public void user_click_on_button() {
		loginObj.signInBtnClick();
	}
	
//Account overview Page verifications
	@Then("User should see account overview page")
	public void user_should_see_account_overview_page() {		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Modulr Payments";
		assertEquals(expectedTitle,actualTitle);
	}
	

//to check invalid Credential message 
		@Then("^User should see error message$")
		public void errorMessage() {		
			loginObj.invalidCredentialsAlertCheck();
		}

		@Then("^Forgotten password is visible$")
		public void forgotten_password_is_visible() {
			loginObj.forgottenPwdVisibility();
		}

		@Then("^User click on forgotten password$")
		public void user_click_on_forgotten_password() {
			loginObj.ForgoPwdClk();
		}
		
	
}
