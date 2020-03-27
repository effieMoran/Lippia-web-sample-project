package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.phptravel.PHPTravelAboutUs;
import com.crowdar.examples.pages.phptravel.PHPTravelCarsPage;
import com.crowdar.examples.pages.phptravel.PHPTravelHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

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
        Injector._page(PHPTravelHomePage.class).clickElementToRedirectByPageTitle(pageName);
    }

    @Then("The (.*) page is displayed")
    public void aboutUsVerification(String pageName) {
        Assert.assertTrue(Injector._page(PHPTravelAboutUs.class).getAboutUsHeader(pageName).isDisplayed());
    }

    @Given("The user is in Cars page")
    public void carsPage() {
        Injector._page(PHPTravelCarsPage.class).go();
    }

    @Then("The search page list the available cars in those days.")
    public void verifySearchList() {
        Assert.assertFalse(Injector._page(PHPTravelCarsPage.class).getCarsLegend().isEmpty());
    }

    @When("The user search a car between two days")
    public void searchCarBetweenTwoDays() {
        Injector._page(PHPTravelHomePage.class).clickCarsSearch();
        Injector._page(PHPTravelHomePage.class).selectADateAfter();
    }

    @When("The user select the first result in the list")
    public void selectTheFirstResult() {
        Injector._page(PHPTravelCarsPage.class).selectFirstCar();
    }

    @When("The user complete the booking car form")
    public void completeCarBooking() {
        Injector._page(PHPTravelCarsPage.class).completeUserData();
    }

    @When("The user complete the payment form (.*)")
    public void completePaymentForm(String name, Map<String, String> creditCardData) {
        Injector._page(PHPTravelCarsPage.class).completePaymentData(creditCardData);
    }

    @Then("A reservation number is provided$")
    public void reservationNumberVerification() {

    }
}
