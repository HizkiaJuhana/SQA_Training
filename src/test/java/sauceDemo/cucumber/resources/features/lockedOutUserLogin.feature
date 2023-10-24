Feature: login dengan locked user

  Scenario: user login sebagai locked out user
    Given user berada di saucedemo.com
    When input username "locked_out_user"
    And  input password "secret_sauce"
    And klik pada tombol login
    Then user akan menerima pesan notifikasi "Epic sadface: Sorry, this user has been locked out."