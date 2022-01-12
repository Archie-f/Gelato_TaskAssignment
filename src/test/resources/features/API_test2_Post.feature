@wip
Feature: Post Request

  Background:
    Given the baseURI is set


  Scenario: Verify a new todo for a new user is created
    And the request body contains userId:21 title:"Read 50 more pages" and completed:"false"
    When the user sends a post request to "/todos" end point for a new user
    Then the response payload data should match with the request body


  Scenario: Verify a new todo for an existing user is created
    And the request body contains userId:17 title:"Complete all tests" and completed:"true"
    When the user sends a post request to "/todos" end point for a new user
    Then the response payload data should match with the request body
