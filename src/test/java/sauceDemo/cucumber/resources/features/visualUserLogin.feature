Feature: Login dengan visual user

  Scenario: user login sebagai visual user
    Given user berada di saucedemo.com
    When input username
    And  input password
    And klik pada tombol login
    Then user akan diarahkan ke Home Page
