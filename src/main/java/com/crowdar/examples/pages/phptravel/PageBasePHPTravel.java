package com.crowdar.examples.pages.phptravel;

import com.crowdar.core.pageObjects.PageBaseWeb;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Eli on 19/3/2020.
 */
public class PageBasePHPTravel extends PageBaseWeb {

    public PageBasePHPTravel(RemoteWebDriver driver) {
        super(driver);
        BASE_URL = "http://phptravels.net";
    }
}


