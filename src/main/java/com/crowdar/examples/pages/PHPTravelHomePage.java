package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Eli on 19/3/2020.
 */
public class PHPTravelHomePage extends PageBasePHPTravel {

    private final String INPUT_SEARCH_XPATH = "//input[@class='gLFyf gsfi']";
    private final String SEARCH_BUTTON_NAME = "btnK";
    private final String ABOUT_US_URL = "https://phptravels.net/About-Us";

    public PHPTravelHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void enterSearchCriteria(String text) {
        completeField(By.partialLinkText(INPUT_SEARCH_XPATH), text);
    }


    public void clickButton(String title) {
        //WebElement algo = driver.findElement(By.xpath("//a[text()='"+ title + "']"));
        clickElement(By.xpath("//a[text()='"+ title + "']"));
    }
}
