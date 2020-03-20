package com.crowdar.examples.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PHPTravelAboutUs extends PageBasePHPTravel {

    public PHPTravelAboutUs(RemoteWebDriver driver) {
        super(driver);
        this.url = "/About-Us";
    }

}
