package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Проверка отображения суммы
    public String getDisplayedSum() {
        return driver.findElement(By.id("confirmation-sum")).getText(); // замените локатор
    }

    // Проверка номера телефона
    public String getDisplayedPhone() {
        return driver.findElement(By.id("confirmation-phone")).getText(); // замените локатор
    }

    // Надписи в незаполненных полях (например, реквизиты карты)
    public List<WebElement> getUnfilledFieldsLabels() {
        return driver.findElements(By.xpath("//div[contains(@class,'unfilled-field')]//label"));
        // замените на актуальный локатор, если есть
    }

    // Иконки платёжных систем
    public List<WebElement> getPaymentIcons() {
        return driver.findElements(By.xpath("//div[@class='payment-icons']//img"));
    }
}