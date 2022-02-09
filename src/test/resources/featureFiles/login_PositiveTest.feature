Feature: Login Test

#Scenario: Verify Login Functionality_Positive Flow 
#	Given User Navigates to Modulr Payments 
#	When User enters username as Mahendra.Bhise77 and password as Mahi17031993# 
#	And User click on sign In button 
#	Then User should see account overview page 

#Scenario: Verify when user enters invalid credentials 
#	Given User Navigates to Modulr Payments 
#	When User enters username as dsfsdf and password as gfdgdfgdf 
#	And User click on sign In button 
#	Then User should see error message

Scenario: Verify password reset functionality 
	Given User Navigates to Modulr Payments 
	Then Forgotten password is visible
	And User click on forgotten password
#	And User click on sign In button 
#	Then User should see error message 
	