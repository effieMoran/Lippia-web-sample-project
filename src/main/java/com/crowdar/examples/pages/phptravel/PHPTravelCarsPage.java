package com.crowdar.examples.pages.phptravel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class PHPTravelCarsPage extends PageBasePHPTravel {

    public PHPTravelCarsPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "/cars";
    }

    public void go() {
        navigateToCompleteURL();
    }

    public String getCarsLegend() {
        return getCars().getText();
    }

    private WebElement getCars() {
        return getWebElement(By.id("ct_cars_legend"));
    }

    public void selectFirstCar() {
        WebElement firstCar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ct_cars\"]/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[2]/button/span[1]")));
        firstCar.click();
    }

    public void completeUserData() {
        completeElementWithFluentWait(By.id("ct_firstname"), "John");
        completeElementWithFluentWait(By.id("ct_surname"), "Doe");
        completeElementWithFluentWait(By.id("ct_email_address"), "justanemail@gmail.com");
        completeElementWithFluentWait(By.id("ct_email_address_confirm"), "justanemail@gmail.com");
        completeElementWithFluentWait(By.id("ct_phone_no"), "12345678");
        completeElementWithFluentWait(By.id("ct_city"), "Chicago");
        completeElementWithFluentWait(By.id("ct_address_1"), "Baker st. 856");

        WebElement confirmReservationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ct_frm_step3\"]/div[1]/div[4]/div/span")));
        confirmReservationButton.submit();
        System.out.println();
    }

    private void completeElementWithFluentWait(By locator, String value) {
        WebElement emailAddress = wait.until(ExpectedConditions.elementToBeClickable(locator));
        emailAddress.clear();
        emailAddress.sendKeys(value);
    }

    public void completePaymentData(Map<String, String> creditCardInformation) {

        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated((By
                .xpath("//*[@id=\"ct_box_Insurance_wrapper\"]/div[2]/iframe"))));
        wait.until(ExpectedConditions.visibilityOfAllElements(frame));
        driver.switchTo().frame(0);
        WebElement element;
        for (String creditCardItem : creditCardInformation.keySet()) {
            element = wait.until((ExpectedConditions.elementToBeClickable(By.id(creditCardItem))));
            element.sendKeys(creditCardInformation.get(creditCardItem));
        }

        element = driver.findElement(By.xpath("//*[@id=\"ct_secure_form\"]/div[5]/div/input"));
        element.click();
    }
}
