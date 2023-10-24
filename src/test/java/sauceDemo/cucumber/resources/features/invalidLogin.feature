Feature: Login dengan invalid credential

  Scenario: user login dengan invalid credential
    Given user berada di saucedemo.com untuk invalid user
    When input username untuk invalid user
    And  input password untuk invalid user
    And klik pada tombol login untuk invalid user
    Then user akan menerima pesan notifikasi untuk invalid user