package com.crowdar.examples.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PHPTravelCarsPage extends PageBasePHPTravel {

    public PHPTravelCarsPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "/cars";
    }

    public void go() {
        navigateToCompleteURL();
    }
}
