@SEP5-4
Feature: Enter my Personal details
  As a user, I should be able to enter my Personal details.

  @SEP5-4-TC1
  Scenario Outline: Entering valid personal details
    Given the user is on the enrollment page "<program code>"
    When user enter "<firstName>" into the First Name field
    And user enter "<lastName>" into the Last Name field
    And user enter "<email>" into the Email Address field
    And user enter "<phone>" into the Phone field
    And user select from the "<How did you hear about us?>" dropdown
    And For only Teens plan the user should be able to enter Valid parent fields values.
    Then the user should be able to click Next button and land in the payment plan page.


    Examples:
      | program code | firstName | lastName | email                     | phone      | How did you hear about us? |
      | taws         | John      | Doe      | john.doe@example.com      | 1234567890 | Email                      |
      | rfep         | Jane      | Smith    | jane.smith@example.com    | 0987654321 | Facebook                   |
      | jfft         | Alice     | Johnson  | alice.johnson@example.com | 5555555555 | Google                     |
      | jss          | Bob       | Brown    | bob.brown@example.com     | 4444444444 | LinkedIN                   |

  @SEP5-4-TC2
  Scenario Outline: Entering valid personal details
    Given the user is on the enrollment page "<program code>"
    When user enter "<firstName>" into the First Name field
    And user enter "<lastName>" into the Last Name field
    And user enter "<email>" into the Email Address field
    And user enter "<phone>" into the Phone field
    And user select from the "<How did you hear about us?>" dropdown
    And For only Teens plan the user should be able to enter invalid parent fields values.
    Then the Next button should be disabled.

    Examples:
      | program code | firstName | lastName | email                | phone      | How did you hear about us? |
      | taws         | 33        | @        | @                    | jj         | Email                      |
      | rfep         | ,         | $%       | .com                 | $$$        | Facebook                   |
      | jfft         | $R$       | 4fr      | $@.4                 | ===        | Google                     |
      | jss          | )_)_      | 23322    | com                  | jj         | Other                      |
      | taws         | 33        | ...      | 0999                 | ^^^        | Email                      |

  @SEP5-4-TC3laila
  Scenario Outline: All field types are missing values.
    Given the user is on the enrollment page "<program code>"
    When the user delete the values of the first name fields and should see the complaints of it in red color.
    And the user delete the values of the last name fields and should see the complaints of it in red color.
    And the user delete the values of the email fields and should see the complaints of it in red color.
    And the user delete the values of the phone fields and should see the complaints of it in red color.
    And For only Teens plan when the user click on next button and should be able to see all the missing parent fields in red color.
    Then the Next button should be disabled.


    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |
  @SEP5-4-TC4
  Scenario Outline: Default field types should complaint if any is missing for every "<program>"
    Given the user is on the enrollment page "<program code>"
    When the user delete the values of the first name fields and should see the complaints of it in red color.
    And the user delete the values of the last name fields and should see the complaints of it in red color.
    And the user delete the values of the email fields and should see the complaints of it in red color.
    And the user delete the values of the phone fields and should see the complaints of it in red color.
    And For only Teens plan when the user click on next button and should be able to see all the missing parent fields in red color.


    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |
  @SEP5-4-TC5
  Scenario Outline: The 'Next' button should be disabled if any required data is missing or invalid for every "<program>"
    Given the user is on the enrollment page "<program code>"
    When the user delete the values of the first name fields and should see the complaints of it in red color.
     # And I delete the values of the last name fields i should see the complaints of it in red color.
     # And I delete the values of the email fields i should see the complaints of it in red color.
     # And I delete the values of the phone fields i should see the complaints of it in red color.
    And For only Teens plan the user should be able to enter Valid parent fields values.
    Then the Next button should be disabled.

    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |
  @SEP5-4-TC6
  Scenario Outline: The 'Next' button should be disabled if any required data is missing or invalid for every "<program>"
    Given the user is on the enrollment page "<program code>"
     # When I delete the values of the first name fields i should see the complaints of it in red color.
    And the user delete the values of the last name fields and should see the complaints of it in red color.
     # And I delete the values of the email fields i should see the complaints of it in red color.
     # And I delete the values of the phone fields i should see the complaints of it in red color.
    And For only Teens plan the user should be able to enter Valid parent fields values.
    Then the Next button should be disabled.

    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |
  @SEP5-4-TC7
  Scenario Outline: The 'Next' button should be disabled if any required data is missing or invalid for every "<program>"
    Given the user is on the enrollment page "<program code>"
     # When I delete the values of the first name fields i should see the complaints of it in red color.
     # And I delete the values of the last name fields i should see the complaints of it in red color.
    And the user delete the values of the email fields and should see the complaints of it in red color.
     # And I delete the values of the phone fields i should see the complaints of it in red color.
    And For only Teens plan the user should be able to enter Valid parent fields values.
    Then the Next button should be disabled.

    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |
  @SEP5-4-TC8
  Scenario Outline: The 'Next' button should be disabled if any required data is missing or invalid for every "<program>"
    Given the user is on the enrollment page "<program code>"
     # When I delete the values of the first name fields i should see the complaints of it in red color.
     # And I delete the values of the last name fields i should see the complaints of it in red color.
     # And I delete the values of the email fields i should see the complaints of it in red color.
    And the user delete the values of the phone fields and should see the complaints of it in red color.
    And For only Teens plan the user should be able to enter Valid parent fields values.
    Then the Next button should be disabled.

    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |
  @SEP5-4-TC9
  Scenario Outline: The 'Next' button should be disabled if any required data is missing or invalid for every "<program>"
    Given the user is on the enrollment page "<program code>"
    When the user delete the values of the first name fields and should see the complaints of it in red color.
    And the user delete the values of the last name fields and should see the complaints of it in red color.
    And the user delete the values of the email fields and should see the complaints of it in red color.
    And the user delete the values of the phone fields and should see the complaints of it in red color.
    And For only Teens plan the user should be able to enter Valid parent fields values.
    Then the Next button should be disabled.

    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |
  @SEP5-4-TC10
  Scenario Outline: The 'Next' button should be disabled if any required data is missing or invalid for every "<program>"
    Given the user is on the enrollment page "<program code>"
    When the user delete the values of the first name fields and should see the complaints of it in red color.
    And the user delete the values of the last name fields and should see the complaints of it in red color.
    And the user delete the values of the email fields and should see the complaints of it in red color.
    And the user delete the values of the phone fields and should see the complaints of it in red color.
     # And For only Teens plan I should be able to enter Valid parent fields values.
    Then the Next button should be disabled.

    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |

