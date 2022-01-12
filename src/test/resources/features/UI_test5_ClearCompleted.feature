@ui
Feature: Clearing completed toDos.


  Scenario Outline: The user should edit any existing item
    Given the user is on the todos page
    And there's an "<existing_item>" list with some are "<completed>"
    When the user clicks on the Clear completed button
    Then the completed buttons are cleared from the list
    Examples:
      | existing_item | completed |
      | Wake up       | Wake up   |
      | Workout       |           |
      | Shower        | Shower    |
      | Breakfast     |           |
      | Go to office  |           |