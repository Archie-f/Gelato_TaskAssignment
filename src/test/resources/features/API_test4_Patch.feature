
Feature: Put Request

  Background:
    Given the baseURI is set

  @wip
  Scenario: Verify a completed status of a user is updated
    And the user sends a get request to "/todos/19" end point
    And the id of the response payload matches with the request id 19
    When the user sends a patch request to "/todos/" end point with the userId 19
    Then the response payload data should match with the request body