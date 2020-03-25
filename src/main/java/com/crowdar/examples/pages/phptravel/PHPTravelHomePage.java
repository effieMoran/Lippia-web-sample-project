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
        WebElement dropOffDatePicker = wait.until(ExpectedConditions.elementToBeClickable(By.name(DROP_OFF_LABEL)));
        dropOffDatePicker.click();

        WebElement pickUpDateDatePicker = wait.until(ExpectedConditions.elementToBeClickable(By.name("pickupdate")));
        pickUpDateDatePicker.click();

        LocalDate pickUpDate = LocalDate.now();
        pickUpDate = pickUpDate.plusDays(1);
        LocalDate dropOffDate = pickUpDate.plusDays(2);

        String pickUpFormattedDate = pickUpDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        completeField(pickUpDateDatePicker, pickUpFormattedDate);

        String dropOffFormattedDate = dropOffDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        completeField(dropOffDatePicker, dropOffFormattedDate);

        clickElementWithFluentWait(By.xpath(PICK_UP_LOCATION_XPATH));

        WebElement pickUpLocationInput =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PICK_UP_LOCATION_INPUT_XPATH)));
        completeField(pickUpLocationInput, CITY_NAME);

        clickElementWithFluentWait(By.xpath(FIRST_DROP_OFF_LOCATION_XPATH));

        //clickElement(By.xpath(SEARCH_BUTTON_XPATH));
        //WebElement searchButton = driver.findElement(By.xpath(SEARCH_BUTTON_XPATH));
        //searchButton.submit();

        walkArourd(pickUpDate, dropOffDate);

        System.out.println();
    }

    private void walkArourd(LocalDate pickUpDate, LocalDate dropOffDate) {
        driver.get("https://phptravels.net/car?startlocation=Chicago+-+North+%28illinois%29&endlocation=Chicago+-+North+%28illinois%29&pickupLocationId=159768&returnLocationId=159768&clientId=741882&residencyId=US&pickupDateTime=" +
                pickUpDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+
                "T10%3A00&returnDateTime=" +
                dropOffDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+
                "T10%3A00" +
                "&currency=USD#book");
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
