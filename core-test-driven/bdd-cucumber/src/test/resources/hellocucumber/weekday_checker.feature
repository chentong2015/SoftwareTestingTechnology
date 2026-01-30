Feature: Is it Friday yet?
  This is doc line for the description of feature

  Scenario: Sunday isn't Friday
      Given today is Sunday
      When I ask whether it's Friday yet
      Then I should be told "Nope"

  Scenario: Friday is Friday
      Given today is Friday
      When I ask whether it's Friday yet
      Then I should be told "Yes"

  Scenario Outline: Today is or is not Friday
     Given today is "<day>"
     When I ask whether it's Friday yet
     Then I should be told "<answer>"
     Examples:
     | day            | answer |
     | Friday         | Yes    |
     | Sunday         | Nope   |
     | anything else  | Nope   |