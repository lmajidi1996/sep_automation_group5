@SEP01
Feature: Product landing page
  As a customer, I should be able to see the product landing page.

  Background:
    Given the user is on the checkout page of "rfep"

  Scenario: Display Complete Product Information
    Then the product name "React Front End Program" should be displayed on the information card
    Then the product name on the information card matches "React Front End Program" on the left side of the screen
    Then the price "$400" should be displayed
    Then the text indicating a "Flexible payments plan available" should be displayed
    Then the Program Start Date should be displayed
    Then the We offer refund policy until the end date should be displayed


