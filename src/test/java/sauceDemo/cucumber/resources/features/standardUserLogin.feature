Feature: Login dengan standard user

  Scenario: user login sebagai standard user
    Given user berada di saucedemo.com
    When input username
    And  input password
    And klik pada tombol login
    Then user akan diarahkan ke Home Page