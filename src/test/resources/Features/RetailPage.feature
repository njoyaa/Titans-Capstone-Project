@RetailPage
Feature: Retail Page

  Background: 
    Given User is on Retail website
    And User click on MyAccount
    When User click on Login
    And User enter username '555@gm.com' and password '1111'
    And User click on Login button
    Then User should be logged in to MyAccount dashboard

  Scenario: Register as an Affiliate user with Cheque Payment Method
    When User click on ‘Register for an Affiliate Account’ link
    And User fill affiliate form with below information
      | company | website   | taxID |  | paymentMethod | PayeeName |
      | bbc     | bbc.co.uk |  4545 |  | paypal        | bbcCo     |
    And User check on About us check box
    And User click on Continue button
    Then User should see a success Message

  Scenario: Edit your affiliate information from Cheque payment method to Bank Transfer
    When User click on ‘Edit your affiliate informationlink
    And user click on Bank Transfer radio button
    And User fill Bank information with below information
      | bankName | branch | swiftCode | accountName | accountNumber |
      | Bakhtar  | Kabul  |      4444 | Ahmad       |     123456789 |
    And User click on Continue button
    Then User should see A Success message

  Scenario: Edit your account Information
    When User click on ‘Edit your account information’ link
    And User modify below information
      | firstName  | lastName | email             | telephone    |
      | Ahmadullah | Ahmadi   | abc88888@gmail.com | 916-916-9166 |
    And User click on continue button
    Then User should See a message ‘Success: Your account has been successfully updated.’
