Feature: Cart in Demoblaze

Background:
Given registered user on home page
When user click login link
Then user should be redirected to login form
When user enters "admin" and "admin"
And user clicks the login button
Then user should be redirected to user homepage
And user should see their username on home page

@addtocart
Scenario: Add product to cart
When user selects a product
And user is redirected to product selected page
And user clicks on Add to cart
And user accepts the alert
And user navigates to cart page
Then product should be displayed in cart

@removefromcart
Scenario: Remove product from cart
When user selects a product
And user is redirected to product selected page
And user clicks on Add to cart
And user accepts the alert
And user navigates to cart page
When user deletes the product
Then cart should be empty