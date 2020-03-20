package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.PHPTravelAboutUs;
import com.crowdar.examples.pages.PHPTravelHomePage;
import com.crowdar.examples.pages.GoogleSearchResultPage;
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
}
