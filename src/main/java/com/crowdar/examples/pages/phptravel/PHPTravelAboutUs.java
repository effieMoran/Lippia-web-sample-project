package com.crowdar.examples.pages.phptravel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PHPTravelAboutUs extends PageBasePHPTravel {

    public PHPTravelAboutUs(RemoteWebDriver driver) {
        super(driver);
        this.url = "/About-Us";
    }

    public WebElement getAboutUsHeader(String title) {
        return driver.findElement(By.partialLinkText(title));
    }

}
