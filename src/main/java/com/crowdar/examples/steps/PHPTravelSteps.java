package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.PHPTravelAboutUs;
import com.crowdar.examples.pages.PHPTravelCarsPage;
import com.crowdar.examples.pages.PHPTravelHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Eli on 19/3/2020.
 */
public class PHPTravelSteps extends PageSteps {

    @Given("The user is in home page")
    public void home() {
        Injector._page(PHPTravelHomePage.class).go();
    }

    @When("The user go to (.*) page")
    public void search(String pageName) {
        Injector._page(PHPTravelHomePage.class).clickButton(pageName);
        //Injector._page(PHPTravelHomePage.class).clickSearchButton();

    }

    @Then("The (.*) page is displayed")
    public void statVerification(String pageName) {
        Assert.assertTrue(!Injector._page(PHPTravelAboutUs.class).getWebElement(By.xpath("//div[contains(text(), " + pageName + ")]")).isDisplayed());
    }

    @Given("The user is in Cars page")
    public void carsPage() throws InterruptedException {
        Injector._page(PHPTravelCarsPage.class).go();
        Thread.sleep(200000);
    }

    @Then("The search page list the available cars in those days.")
    public void verifySearchList() {

    }

    @When("The user search a car between two days")
    public  void searchCarBetweenTwoDays(){

    }

    @When("The user select the first result in the list")
    public void selectTheFirstResult() {

    }
    @When("The user complete the booking car form")
    public void completeCarBookin() {

    }
    @When("The user complete the payment form <payment data provided below>")
    public void completePaymentForm() {

    }
    @Then("A reservation number is provided")
    public void reservationNumberVerification() {

    }
}
