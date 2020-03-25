package com.crowdar.examples.pages.phptravel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        completeField(By.id("ct_firstname"), "John");
        completeField(By.id("ct_surname"), "Doe");
        completeField(By.id("ct_email_address"), "justanemail@gmail.com");
        completeField(By.id("ct_email_address_confirm"), "justanemail@gmail.com");
        completeField(By.id("ct_phone_no"), "12345678");

        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.id("ct_city")));
        city.clear();
        city.sendKeys("Chicago");

        WebElement emailAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("ct_address_1")));
        emailAddress.clear();
        emailAddress.sendKeys("Baker st.");

        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ct_s3_assurance_select_txt\"]/span/i")));
        agreeButton.submit();

        clickElement(By.id("ct_s3_insurance_select"));
        clickElement(By.linkText("California"));
        clickElement(By.linkText("Confirm reservation"));

    }
}
