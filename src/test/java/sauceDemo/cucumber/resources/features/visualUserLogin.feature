Feature: Login dengan visual user

Scenario: user login sebagai visual user
Given user berada di saucedemo.com
When input username "visual_user"
And  input password "secret_sauce"
And klik pada tombol login
Then user akan diarahkan ke Home Page
