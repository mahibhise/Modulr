package Pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	
	WebDriver driver;

	By usernameBx = By.xpath("//*[@id='username-inp']");
	By passwordBx = By.xpath("//*[@id='password-inp']");
	By signInBnt = By.xpath("//*[text()='Sign in ']");
	By forgotPasswordLnk = By.xpath("//*[text()='Forgotten password']");	
	By credentialIncorrectMsg = By.xpath("//*[text() = ' The username or password is incorrect. ']");
	By multipleInvaidLoginMsg = By.xpath("//*[@class='color-white text-body-medium top-margin-2 ng-star-inserted']");
	By forgottenPasswordLnk = By.xpath("//*[@id='forgotPasswordHref']");
	By resetPageHeading = By.xpath("//*[@id='signInHeading']");
	By passwordResetUsernameBx = By.xpath("//*[@id='usernameInput']");
	By requestResetBnt = By.xpath("//*[text()=' Request a reset ']");
	By emailSentTxt = By.xpath("//*[text()='Email sent']");

//Constructor to initialization of data members	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
// function for login in system
	public void enterCredentials(String username, String password)
	{	
		driver.findElement(usernameBx).sendKeys(username);
		driver.findElement(passwordBx).sendKeys(password);
	}
// function for login in system
		public void signInBtnClick()
		{	
			driver.findElement(signInBnt).click();
		}
// function to check invalid credentials message
		public void invalidCredentialsAlertCheck()
		{
//getting alert text and storing in string			
			String incorrectCredentials = driver.findElement(credentialIncorrectMsg).getText();
			String multipleInvalidAlert = driver.findElement(multipleInvaidLoginMsg).getText();
//Alert Message for incorrect login attempt.
			String expectedAlert="The username or password is incorrect";
			String expectedAlertMultipleLogin="Multiple incorrect sign-ins could result in your access being locked. If this does happen, you'll receive an email explaining how to reset your access.";
//AssertConditions			
			assertTrue(incorrectCredentials.contains(expectedAlert));
			assertTrue(multipleInvalidAlert.contains(expectedAlertMultipleLogin));
		}
//Checking visibility of forgotten password button		
		public void forgottenPwdVisibility()
		{
			String ForgotPasswordtext = driver.findElement(forgottenPasswordLnk).getText();
			assertEquals("Forgotten password", ForgotPasswordtext);
	
		}
//Checking visibility of forgotten password button		
		public void ForgoPwdClk()
		{
		driver.findElement(forgottenPasswordLnk).click();
		}		
//Reset Page Heading check
		public void resetPageHeadingCheck()
		{
			String resetPageHeader = driver.findElement(resetPageHeading).getText();
			assertEquals("Reset access", resetPageHeader);
		}
//to enter username to reset the password
		public void enterUsernameToResetPassword(String ResetPwd)
		{
			driver.findElement(passwordResetUsernameBx).sendKeys(ResetPwd);
		}
//to click reset button
		public void resetBtnClick()
		{
			driver.findElement(requestResetBnt).click();
		}
//to check email sent message
		public void emailSentMsgCheck() throws InterruptedException
		{
			Thread.sleep(2000);
			String resetPageHeader = driver.findElement(emailSentTxt).getText();
			assertEquals("Email sent", resetPageHeader);
		}
		
		
		
}
