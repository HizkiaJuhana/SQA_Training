Feature: Login dengan invalid credential

  Scenario: user login dengan invalid credential
    Given user berada di saucedemo.com
    When input username "Standard_user"
    And  input password "secret_sauca"
    And klik pada tombol login
    Then user akan menerima pesan notifikasi "Epic sadface: Username and password do not match any user in this service"