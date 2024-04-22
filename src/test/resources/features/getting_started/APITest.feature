@SEP-02 @api # if the scenarios are for API, then teh @api tag need to be added
Feature: Verify Product Schema
  As a QA engineer, I want to verify the response schema of the product endpoint,
  So that I can ensure it contains all necessary fields with correct data types.

  Background:
    Given Accept header is "application/json"

  Scenario: Response body and Status Code
    When I send a get request to the product endpoint '/products/56/prices'
    Then the status code should be '200'
    And the response body should contain priceId, type and receipt
    And the receipt should contain paymentType and PaymentSummary






