package step_definitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchProduct {

    public WebDriver driver;

    @Given("User navigates to Landing page")
    public void user_navigates_to_landing_page() {
        driver = DriverFactory.getDriver();
    }

    @When("User enters valid product {string}")
    public void user_enters_valid_product(String validProduct) {
        driver.findElement(By.cssSelector("input.form-control.input-lg")).sendKeys(validProduct);
    }

    @And("User clicks on search button")
    public void user_clicks_on_search_button() {
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
    }

    @Then("User gets product info displayed in the Product page")
    public void user_gets_product_info_displayed_in_the_product_page(){
        driver.findElement(By.linkText("HP LP3065")).isDisplayed();
    }

    @When("User enters invalid product {string}")
    public void user_enters_invalid_product(String invalidProduct){
        driver.findElement(By.cssSelector("input.form-control.input-lg")).sendKeys(invalidProduct);
    }

    @Then("User gets warning message no product found in the Product page")
    public void user_gets_warning_message_no_product_found_in_the_product_page() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
    }
}
