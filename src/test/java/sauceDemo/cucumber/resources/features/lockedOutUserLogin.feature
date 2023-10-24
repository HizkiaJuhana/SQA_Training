Feature: login dengan locked user

  Scenario: user login sebagai locked out user
    Given user berada di saucedemo.com untuk locked out user
    When input username untuk locked out user
    And  input password untuk locked out user
    And klik pada tombol login untuk locked out user
    Then user akan menerima pesan notifikasi untuk locked out user