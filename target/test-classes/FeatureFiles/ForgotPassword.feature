Feature:
To verify the functionality of forgotten password in fb
Scenario:
To validate the forgotten password using mail id
Given User have to enter login page
And User have to click the forgotten password
When User have to enter mailid
  |java@123|se322|amulu@123|
And User have to click the search button
Then it should navigate to reset password page

