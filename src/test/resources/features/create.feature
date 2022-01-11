Feature: Creating a new toDo.

  @wip
  Scenario Outline: The user should create a new toDo item
    Given the user is on the todos page
    When the user creates a new "<todo_item>"
    Then the "<todo_item>" should be listed below
    And todo-count should be seen as the number of active toDos
    Examples:
      | todo_item |
      | Wake up   |
      | Workout   |
      | Shower    |
      | Breakfast |


