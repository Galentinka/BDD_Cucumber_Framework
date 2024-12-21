package step_definitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Logout {

    public WebDriver driver;

    @Given("User opens Login page")
    public void user_opens_login_page() {
        driver = DriverFactory.getDriver();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("^User enters emailText (.+)$")
    public void user_enters_emailText(String validEmail) {
        driver.findElement(By.id("input-email")).sendKeys(validEmail);
    }

    @And("^User enters passwordText (.+)$")
    public void user_enters_passwordText(String validPassword) {
        driver.findElement(By.id("input-password")).sendKeys(validPassword);
    }

    @And("User clicks on Login button to redirect to account page")
    public void user_clicks_on_login_button_to_redirect_to_account_page() {
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("Account page is displayed")
    public void account_page_is_displayed() {
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }

    @When("User clicks on logout button")
    public void user_clicks_on_logout_button() {
        driver.findElement(By.linkText("Logout")).click();
    }

    @Then("User is redirect to Logout page")
    public void user_is_redirect_to_Logout_page() {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Account Logout']")).isDisplayed());
    }
}
