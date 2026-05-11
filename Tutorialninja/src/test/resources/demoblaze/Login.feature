Feature: login into DemoBlaze application 
Background:

Given registered user on demo home page
When user clicks login link

@validlogin
Scenario Outline: Login with invalid credentials
When the user enters "<username>" and "<password>"
And when  user clicks the login button
Then user should be see appropriate "<errormessage>"

Examples:
|username|password|errormessage|
|adm     |ad      |Wrong password.|
|admin   |        |Please fill out Username and Password.|
|        |        |Please fill out Username and Password.|
|admin   |ad      |Wrong password.|
|ad      |admin   |Wrong password.|
|admin-  |admin   |User does not exist.|