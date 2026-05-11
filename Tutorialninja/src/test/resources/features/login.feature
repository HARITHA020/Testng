Feature: Login to demo blaze application
 
Background:
Given registered user on home page
When user click login link
Then user should be redirected to login form
@validlogin @smoke @haritha
Scenario: Login with valid username and password
When user enters "admin" and "admin"
And user clicks the login button
Then user should be redirected to user homepage
And  user should see their username on home page

@invalidlogin @regression @haritha
Scenario: Login with invalid username and password
When user enters "admin1" and "ad"
And user clicks the login button
Then user should see appropriate error message

