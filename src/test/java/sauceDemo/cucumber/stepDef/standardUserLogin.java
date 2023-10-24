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

public class standardUserLogin {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";
    @Given("user berada di saucedemo.com")
    public void userBeradaDiSaucedemocomAsStandardUser() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        String loginPageAssert = driver.findElement(By.xpath("//div[text()='Swag Labs']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("input username")
    public void inputUsernameAsStandardUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    }

    @And("input password")
    public void inputPasswordAsStandardUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @And("klik pada tombol login")
    public void klikPadaTombolLoginAsStandardUser() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login-button")).click();

    }

    @Then("user akan diarahkan ke Home Page")
    public void userAkanDiarahkanKeHomepageAsStandardUser() {
        // Write code here that turns the phrase above into concrete actions
        String homePageAssert = driver.findElement(By.xpath("//div[text()='Swag Labs']")).getText();
        Assert.assertEquals(homePageAssert, "Swag Labs");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
