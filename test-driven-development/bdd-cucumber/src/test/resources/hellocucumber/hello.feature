Feature: hello feature
   this is a hello testing feature

   Scenario: double value
     this is a line for description information

     Given I have 48 input value
     When I ask to double it
     Then I should get 96

   Scenario: full case
     this is a line for full cases

     Given the first value is 10
     When double the first value
     And plus 10
     Then the answer should be 30
