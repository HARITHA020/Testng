Feature: login into DemoBlaze application 
Background:

Given  registered  user on demo home page
When  user  clicks login link

@validlogin
Scenario: :Login with valid credentials
When the  user enters valid credentials
      |harithasr|12345|
And when   user clicks the login button
Then user  should be redirected to user homepage
And  user  should see their username on home page