package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class lockedOutUserLogin{
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com";
    @Given("user berada di saucedemo.com untuk locked out user")
    public void userBeradaDiSaucedemocomAsLockedOutUser() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        String loginPageAssert = driver.findElement(By.xpath("//div[text()='Swag Labs']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("input username untuk locked out user")
    public void inputUsernameAsLockedOutUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @And("input password untuk locked out user")
    public void inputPasswordAsLockedOutUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("klik pada tombol login untuk locked out user")
    public void klikPadaTombolLoginAsLockedOutUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("login-button")).click();
    }

    @Then("user akan menerima pesan notifikasi untuk locked out user")
    public void userAkanMenerimaPesanNotifikasiAsLockedOutUser() {
        // Write code here that turns the phrase above into concrete actions
        String homePageAssert = driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']")).getText();
        Assert.assertEquals(homePageAssert, "Epic sadface: Sorry, this user has been locked out.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
