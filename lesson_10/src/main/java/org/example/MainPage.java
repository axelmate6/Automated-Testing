package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.mts.by/");
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]")));
    }

    public void selectPayUpBlock() {
        // Предположим, что блок уже есть на странице
        // Можно добавить клик по кнопке или ссылке, если нужно
    }

    public void selectPaymentOption(String optionName) {
        String optionXpath = "//div[contains(@class,'payment-options')]//label[contains(text(),'" + optionName + "')]//preceding-sibling::input";
        WebElement optionRadio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        if (!optionRadio.isSelected()) {
            optionRadio.click();
        }
    }

    public void clickContinue() {
        String continueBtnXpath = "//button[contains(text(),'Продолжить')]";
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueBtnXpath)));
        btn.click();
    }
}