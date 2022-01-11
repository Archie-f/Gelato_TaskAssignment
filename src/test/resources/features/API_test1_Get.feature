
Feature: Get Request

  Background:
    Given the baseURI is set


  Scenario: Verify the each user has 20 todos
    When the user sends a get request to "/todos" end point
    Then response status code should be 200
    And response content-type: "application/json; charset=utf-8"
    And there should be total 200 todos in the response payload


  Scenario: Verify the id of the response payload matches with the request id
    When the user sends a get request to "/todos/13" end point
    Then response status code should be 200
    And response content-type: "application/json; charset=utf-8"
    And the id of the response payload matches with the request id 13

  @wip
  Scenario: Verify the id of the response payload matches with the request id
    When the user sends a get request to "/users/7/todos" end point
    Then response status code should be 200
    And response content-type: "application/json; charset=utf-8"
    And the number of uncompleted todos of user should match with the expected number 11