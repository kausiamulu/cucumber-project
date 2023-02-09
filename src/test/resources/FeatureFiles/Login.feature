Feature: 
  
  To validate login functionlaity of facebook

  Background: 
    Given User have to enter login page

  Scenario: 
    
    To validate login using  email and  password

    And User have to maximize the window
    When User have to enter emailid and password
      | kausalya@gmail.com | kausi     | Amulu@123      | 9578152952 |
      | nanthu@gmail.com   | nanthu    | nanthu@123     |      12345 |
      | thisha@123         | amulu@123 | thishamulu@123 |     098765 |
    And User have to click login button
    Then User have to be in invalid credentials page
