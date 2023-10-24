Feature: Login dengan standard user

  Scenario: user login sebagai standard user
    Given user berada di saucedemo.com
    When input username "Standard_user"
    And  input password "secret_sauce"
    And klik pada tombol login
    Then user akan diarahkan ke Home Page