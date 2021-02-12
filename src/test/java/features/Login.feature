Feature: Login to FaceBook



@RegressionTest
Scenario: Check login of facebook
Given User is on the facebook login page
When User enters the UserID and password and clicks on Login button
Then facebook homepage is displayed

@SmokeTest
Scenario: Check values
Given User is on the facebook login page
When User enters the following credentials
|sidhantdubey1908@gmail.com|saritadubey|
Then facebook homepage is displayed

Scenario: Check values
Given User is on the facebook login page
When User enters the following credentials "User" and "Password"

Then facebook homepage is displayed
And page is displayed
@SmokeTest
Scenario Outline: Check login of facebook
Given User is on the facebook login page
When User enters the <UserID> and <password> and clicks on Login button
Then facebook homepage is displayed

Examples:

|UserID|password|
|sidhantdubey08@gmail.com|saritadubey|


