package com.crowdar.examples.pages.phptravel;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Eli on 19/3/2020.
 */
public class PHPTravelHomePage extends PageBasePHPTravel {

    public PHPTravelHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void clickElementToRedirectByPageTitle(String title) {
        clickElement(By.partialLinkText(title));
    }
}
