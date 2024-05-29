@SEP5-1
Feature: View the product landing page

  As a customer, I should be able to see the product landing page.

  Scenario Outline:
    Given the user is on the enrollment page "<program code>"
    Then the system should display the text "Secure checkout"
    And the system should display the "<program name>"
    And the footer on the left side should display logo
    And the footer on the left side should display in following order
      | Terms and conditions |
      | Privacy Policy       |
      | Disclaimer           |
      | Cookie Policy        |
    And the footer on the right side should display "Need help? Contact us at enrollment@cydeo.com"



    Examples:
      | program code | program name                  |
      | taws         | Test Automation with Selenium |
      | rfep         | React Front End Program       |
      | jfft         | Java Foundations for Teens    |
      | jss          | Java Selenium SDET            |