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

public class invalidLogin{
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";
    @Given("user berada di saucedemo.com untuk invalid user")
    public void userBeradaDiSaucedemocomAsInvalidUser() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        String loginPageAssert = driver.findElement(By.xpath("//div[text()='Swag Labs']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("input username untuk invalid user")
    public void inputUsernameAsInvalidUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    }

    @And("input password untuk invalid user")
    public void inputPasswordAsInvalidUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @And("klik pada tombol login untuk invalid user")
    public void klikPadaTombolLoginAsInvalidUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login-button")).click();

    }

    @Then("user akan menerima pesan notifikasi untuk invalid user")
    public void userAkanMenerimaPesanNotifikasiAsInvalidUser() {
        // Write code here that turns the phrase above into concrete actions
        String homePageAssert = driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']")).getText();
        Assert.assertEquals(homePageAssert, "Epic sadface: Username and password do not match any user in this service");

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
