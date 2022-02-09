Feature: Login Test 

Scenario: Verify Login Functionality_Positive Flow 
	Given User Navigates to Modulr Payments 
	When User enters username as Mahendra.Bhise77 and password as Mahi17031993# 
	And User click on sign In button 
	Then User should see account overview page 
	And User closes the browser 
	
Scenario: Verify login functionality invalid credentials 
	Given User Navigates to Modulr Payments 
	When User enters username as dsfsdf and password as gfdgdfgdf 
	And User click on sign In button 
	Then User should see error message
	And User closes the browser 

Scenario: Verify password reset functionality 
	Given User Navigates to Modulr Payments 
	Then Forgotten password is visible 
	And User click on forgotten password 
	Then User navigate to Reset Password Screen 
	And User enters username to reset password as testst 
	And User clicks on Request a reset button 
	Then Email sent message should be displayed 
	And User closes the browser 
