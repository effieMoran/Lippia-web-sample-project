package com.crowdar.examples.pages.phptravel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PHPTravelAboutUs extends PageBasePHPTravel {

    private final String ABOUT_US_HEADER = "//*[@id=\"toggleStyle04-headingOne\"]/h5/a";
    public PHPTravelAboutUs(RemoteWebDriver driver) {
        super(driver);
        this.url = "/About-Us";
    }

    public WebElement getAboutUsHeader(String title) {
        return driver.findElement(By.xpath(ABOUT_US_HEADER));
    }
}
