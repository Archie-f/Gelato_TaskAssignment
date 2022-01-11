Feature: Editting an existing toDo.


  Scenario Outline: The user should edit any existing item
    Given the user is on the todos page
    And there's an "<existing_item>" list with some are "<completed>"
    When the user clicks on the x button on the right side of the "<item_to_be_deleted>"
    Then the "<item_to_be_deleted>" should disappear from the list
    Examples:
      | existing_item | completed | item_to_be_deleted |
      | Wake up       | Wake up   | Wake up            |
      | Workout       |           |                    |
      | Shower        | Shower    |                    |
      | Breakfast     |           | Breakfast          |
      | Go to office  |           |                    |