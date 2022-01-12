
Feature: Delete Request

  Background:
    Given the baseURI is set


  Scenario: Verify a completed status of a user is updated
    When the user sends a delete request to "/todos/" end point with the userId 15
    Then the response payload data should be empty