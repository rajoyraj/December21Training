Feature: Contact Us 

Scenario Outline: Positive test validating contactUsSection
Given Initialize the browser with chrome
When Navigate to HomePage
And Click on Contact Us link in home page to land on contact us Page
And User enters selects subject heading, enter emailAddress,enter order reference number,enter message and click on send us button
Then Verify that user has succefully done that 
And close browsers







