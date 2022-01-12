@ui
Feature: Checking a completed toDo.


  Scenario Outline: The user should check the completed items
    Given the user is on the todos page
    When the user clicks the circle near the "<completed_item>" among the "<todo_item>" list
    Then the "<completed_item>" should be marked as completed
    And todo-count should be seen as the number of active toDos
    And the user should see the "<completed_item>" in Completed list
    Examples:
      | todo_item    | completed_item |
      | Wake up      | Wake up        |
      | Workout      |                |
      | Shower       | Shower         |
      | Breakfast    | Breakfast      |
      | Go to office |                |
      | Work         |                |