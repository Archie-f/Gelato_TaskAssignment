@ui
Feature: Editing an existing toDo.


  Scenario Outline: The user should edit any existing item
    Given the user is on the todos page
    And there's an "<existing_item>" list with some are "<completed>"
    When the user double clicks any "<item_to_edit>" and edits "<existing_item>" with the "<new_content>"
    Then the old "<item_to_edit>" should be replaced with the "<new_content>"
    Examples:
      | existing_item | completed | item_to_edit | new_content         |
      | Wake up       | Wake up   | Wake up      | Woke up at 5:30     |
      | Workout       |           |              |                     |
      | Shower        | Shower    |              |                     |
      | Breakfast     |           | Breakfast    | Breakfast at Gwen's |
      | Go to office  |           |              |                     |