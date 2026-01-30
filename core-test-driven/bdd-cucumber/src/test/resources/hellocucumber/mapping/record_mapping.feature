Feature: Record mapping testing

   Scenario: Record mapping for category values
      Given init new record with default fields
        | bad  | category | isEmbargo | type |
        | 0    | SI       | 0         | C    |
      When Record is mapped
      Then Record has expected category values
        | bad  | category | isEmbargo | type | gender  |
        | 0    | SI       | 0         | C    |         |