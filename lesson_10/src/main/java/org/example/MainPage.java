package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private static WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBlockTitle() {
        String text = driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]")).getText();
        return text.replaceAll("\\s+", " ").trim();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
    }

    public WebElement getMoreInfoLink() {
        return driver.findElement(By.linkText("Подробнее о сервисе"));
    }

    public void clickMoreInfo() {
        getMoreInfoLink().click();
    }

    public WebElement getOptionByName(String name) {
        return driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]//preceding-sibling::input"));
    }

    public WebElement getPhoneNumberField() {
        return driver.findElement(By.id("phoneNumber")); // замените на актуальный локатор
    }

    public WebElement getAmountField() {
        return driver.findElement(By.id("amount")); // замените на актуальный локатор
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]"));
    }

    public void fillPhoneNumber(String number) {
        WebElement field = getPhoneNumberField();
        field.clear();
        field.sendKeys(number);
    }

    public void fillAmount(String amount) {
        WebElement field = getAmountField();
        field.clear();
        field.sendKeys(amount);
    }

    public void clickContinue() {
        getContinueButton().click();
    }

}