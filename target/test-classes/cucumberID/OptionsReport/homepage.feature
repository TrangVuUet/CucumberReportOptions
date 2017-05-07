Feature: Home page

#This screnario checks Homepage without Login

Scenario: Home page without Login

Given I access to the Toolqa Demo Homepage
Then I should see the Logo icon and My account icon
Then I should see main Menu

#This screnario checks Homepage when already login

Scenario: Home page with Login

Given I access to the Toolqa Demo Homepage
Given I have already Login
Then I should see the Logo icon and My account icon
Then I should see main Menu
Then I should see Log out link and Site Admin link