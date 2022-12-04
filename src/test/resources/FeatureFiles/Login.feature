Feature:
To validate login functionlaity of facebook
Background:
Given User have to enter login page

Scenario:
To validate login using valid email and invalid password
When User have to enter valid email and invalid password
And User have to click login button
Then User have to be in invalid credentials page

Scenario:
To validate login using invalid email and valid password	
When User have to enter invalid email and valid password
And User have to click login button
Then User have to be in invalid credential page