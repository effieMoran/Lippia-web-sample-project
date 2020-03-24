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

    private String DROP_OFF_LABEL = "dropoffdate";

    private String CARS_TAB_XPATH = "//a[@data-name=\"cars\"]";

    private String PICK_UP_LOCATION_XPATH = "//span[contains(text(),'Pick up')]";

    private String CITY_NAME = "Chicago";

    private String PICK_UP_LOCATION_INPUT_XPATH = "//*[@id='select2-drop']/div/input";

    private String FIRST_DROP_OFF_LOCATION_XPATH = "//span[contains(text(),'Chicago')][1]";

    private String SEARCH_BUTTON_XPATH = "//button[contains(text(),'Search')]";

    public PHPTravelHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void clickCarsSearch() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CARS_TAB_XPATH)));
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

        clickElementWithFluentWait(By.xpath(PICK_UP_LOCATION_XPATH));

        WebElement pickUpLocationInput =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PICK_UP_LOCATION_INPUT_XPATH)));
        completeField(pickUpLocationInput, CITY_NAME);

        clickElementWithFluentWait(By.xpath(FIRST_DROP_OFF_LOCATION_XPATH));

        //clickElementWithFluentWait(By.xpath(SEARCH_BUTTON_XPATH));
        //WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_BUTTON_XPATH)));
        //searchButton.click();
    }

    /**
     *  Avoidede clickElement(By locator) of Lippia framework due to conflicts with javascript code
     * @param locator
     */
    private void clickElementWithFluentWait(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        webElement.click();
    }
}
