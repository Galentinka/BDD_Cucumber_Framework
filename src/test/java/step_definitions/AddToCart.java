package step_definitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddToCart {

    public WebDriver driver;

    @Given("User navigates to Login page to search for product")
    public void user_navigates_to_login_page_to_search_for_product() {
        driver = DriverFactory.getDriver();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("^User enters validEmail to login (.+)$")
    public void user_enters_validEmail_to_login(String validEmail) {
        driver.findElement(By.id("input-email")).sendKeys(validEmail);
    }

    @And("^User enters validPassword to login (.+)$")
    public void user_enters_validPassword_to_login(String validPassword) {
        driver.findElement(By.id("input-password")).sendKeys(validPassword);
    }

    @And("User clicks on Login button to login")
    public void user_clicks_on_login_button_to_login () {
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("User is redirect to Account page to search for product")
    public void user_is_redirect_to_account_page_to_search_for_product() {
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }

    @When("User enters {string}")
    public void user_enters(String validProduct) {
        driver.findElement(By.cssSelector("input.form-control.input-lg")).sendKeys(validProduct);
    }

    @And("User clicks on search")
    public void user_clicks_on_search() {
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
    }

    @When("User enters invalid {string}")
    public void user_enters_invalid(String invalidProduct){
        driver.findElement(By.cssSelector("input.form-control.input-lg")).sendKeys(invalidProduct);
    }

    @Then("User gets warning message no product1 found in the Product page")
    public void user_gets_warning_message_no_product1_found_in_the_product_page() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
    }


    @Then("User gets product info displayed")
    public void user_gets_product_info_displayed(){
        driver.findElement(By.linkText("HP LP3065")).isDisplayed();
    }

    @When("User clicks on AddToCart button on Product page")
    public void user_clicks_on_AddToCart_button_on_product_page() {
        driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
    }

    @Then("User is redirected to AddToCart page")
    public void user_is_redirected_to_AddToCart_page() {
        driver.findElement(By.xpath("//h1[text()='HP LP3065']")).isDisplayed();
    }

    @And("User clicks on AddToCart button in AddToCart page")
    public void user_clicks_on_AddToCart_button_in_AddToCart_page() {
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-lg.btn-block")).click();
    }

    @Then("User receive a success message")
    public void user_receive_a_success_message() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed());
    }

    @And("User clicks on AddToCart button on AddToCart page")
    public void user_clicks_on_AddToCart_button_on_AddToCart_page() {
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();
    }

}
