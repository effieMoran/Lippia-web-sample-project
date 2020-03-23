package com.crowdar.examples.pages.phptravel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Eli on 19/3/2020.
 */
public class PHPTravelHomePage extends PageBasePHPTravel {

    private final String DROP_OFF_LABEL = "dropoffdate";
    public PHPTravelHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void go() {
        navigateToCompleteURL();
    }


    public void clickCarsSearch() {
        //clickElement(By.xpath("//a[@data-name=\"cars\"]"));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-name=\"cars\"]")));
        element.click();
    }

    public void clickElementToRedirectByPageTitle(String title) {
        clickElement(By.partialLinkText(title));
    }

    public void selectADateAfter() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name(DROP_OFF_LABEL)));
        element.click();

        LocalDate dropOffDate = LocalDate.now();
        dropOffDate = dropOffDate.plusDays(2);
        String formattedDate = dropOffDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        completeField(element, formattedDate);

        // How to complete Chicago
        WebElement city = driver.findElement(By.className("select2-match"));
        clickElement(city);
        completeField(city, "Chicago");

        clickElement(By.linkText("Search"));
    }
}
