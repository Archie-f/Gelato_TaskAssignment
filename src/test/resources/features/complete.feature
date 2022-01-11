Feature: Checking a completed toDo.

  @wip
  Scenario Outline: The user should check the completed items
    Given the user is on the todos page
    When the user clicks the circle near the "<todo_item>"
    Then the "<todo_item>" should be marked as completed
    And todo-count should be seen as the number of active toDos
    And the user should see the "<todo_item>" in Completed list
    Examples:
      | todo_item |
      | Wake up   |
      | Workout   |
      | Shower    |
      | Breakfast |