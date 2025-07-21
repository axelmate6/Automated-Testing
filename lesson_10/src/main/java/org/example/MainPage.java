package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getBlockTitle() {
        String text = driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]")).getText();
        return text.replaceAll("\\s+", " ").trim();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
    }

    public WebElement getMoreInfoLink() {
        WebElement element = driver.findElement(By.linkText("Подробнее о сервисе"));
        return element;
    }

    public void clickMoreInfo() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getMoreInfoLink());
        getMoreInfoLink().click();
    }

    public WebElement getPhoneNumberField() {
        return driver.findElement(By.id("connection-phone"));
    }

    public WebElement getAmountField() {
        return driver.findElement(By.id("connection-sum"));
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

    public WebElement getUslugiSvyazi(){
        WebElement element = driver.findElement(By.linkText("Услуги связи"));
        return element;
    }

    public WebElement getDomashniyInternet(){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p"));
        return element;
    }

    public WebElement getRassrochka(){
        WebElement element = driver.findElement(By.linkText("Рассрочка"));
        return element;
    }

    public WebElement getZadolzhennost(){
        WebElement element = driver.findElement(By.linkText("Задолженность"));
        return element;
    }

    public void verifyPlaceholder(By locator, String expectedPlaceholder) {
        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        String actualPlaceholder = inputField.getAttribute("placeholder");
        if (!actualPlaceholder.equals(expectedPlaceholder)) {
            throw new AssertionError("Ожидался плейсхолдер '" + expectedPlaceholder + "', но найден '" + actualPlaceholder + "'");
        }
    }

    public void switchToDomashniyInternet(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getDomashniyInternet());
        getDomashniyInternet().click();
    }

    public void switchToRassrochka(){
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")));
        field.click();
    }

    public void switchToZadolzhennost(){
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")));
        field.click();
    }

    public void switchToUslugiSvyazi(){
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")));
        field.click();
    }

    public void verifyFieldsForUslugiSvyazi() {
        verifyPlaceholder(By.xpath("//input[@placeholder='Номер телефона']"), "Номер телефона");
        verifyPlaceholder(By.xpath("//input[@placeholder='Сумма']"), "Сумма");
        verifyPlaceholder(By.xpath("//*[@id=\"connection-email\"]"), "E-mail для отправки чека");
    }

    public void verifyFieldsForDomashniyInternet() {
        verifyPlaceholder(By.xpath("//input[@placeholder='Номер абонента']"), "Номер абонента");
        verifyPlaceholder(By.xpath("//*[@id=\"connection-sum\"]"), "Сумма");
        verifyPlaceholder(By.xpath("//*[@id=\"connection-email\"]"), "E-mail для отправки чека");
    }

    public void verifyFieldsForRassrochka() {
        verifyPlaceholder(By.xpath("//input[@placeholder='Номер счета на 44']"), "Номер счета на 44");
        verifyPlaceholder(By.xpath("//*[@id=\"connection-sum\"]"), "Сумма");
        verifyPlaceholder(By.xpath("//*[@id=\"connection-email\"]"), "E-mail для отправки чека");
    }

    public void verifyFieldsForZadolzhennost() {
        verifyPlaceholder(By.xpath("//input[@placeholder='Номер счета на 2073']"), "Номер счета на 2073");
        verifyPlaceholder(By.xpath("//input[@placeholder='Сумма']"), "Сумма");
        verifyPlaceholder(By.xpath("//*[@id=\"connection-email\"]"), "E-mail для отправки чека");
    }
}