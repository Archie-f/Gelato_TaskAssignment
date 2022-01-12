@wip
Feature: Get Request

  Background:
    Given the baseURI is set


  Scenario: Verify there are total 200 todos
    When the user sends a get request to "/todos" end point
    Then there should be total 200 todos in the response payload


  Scenario: Verify the id of the response payload matches with the request id
    When the user sends a get request to "/todos/13" end point
    Then the id of the response payload matches with the request id 13


  Scenario: Verify the id of the response payload matches with the request id
    When the user sends a get request to "/users/7/todos" end point
    Then the number of uncompleted todos of user should match with the expected number 11
