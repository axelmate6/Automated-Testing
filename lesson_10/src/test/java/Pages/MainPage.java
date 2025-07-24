package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By titleBlock = By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]");
    private final By moreInfoLink = By.linkText("Подробнее о сервисе");
    private final By phoneNumber = By.id("connection-phone");
    private final By amountField = By.id("connection-sum");
    private final By continueButton = By.xpath("//button[contains(text(),'Продолжить')]");
    private final By uslugiSvyazi = By.linkText("Услуги связи");
    private final By domashniyInternet = By.xpath("//*[@id=\"pay\"]/option[2]");
    private final By rassrochka = By.xpath("//*[@id=\"pay\"]/option[3]");
    private final By zadolzhennost = By.xpath("//*[@id=\"pay\"]/option[4]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getBlockTitle() {
        String text = driver.findElement(titleBlock).getText();
        return text.replaceAll("\\s+", " ").trim();
    }

    public WebElement getMoreInfoLink() {
        WebElement element = driver.findElement(moreInfoLink);
        return element;
    }

    public void logosPresence(){
        String[] logoXPaths = {
                "//img[contains(@alt, 'Visa')]",
                "//img[contains(@alt, 'Verified By Visa')]",
                "//img[contains(@alt, 'MasterCard')]",
                "//img[contains(@alt, 'MasterCard Secure Code')]",
                "//img[contains(@alt, 'Белкарт')]"
        };
        for (String xpath : logoXPaths) {
            WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Assertions.assertTrue(logo.isDisplayed(), "Логотип не отображается: " + logo.getAttribute("alt"));
            System.out.println("Логотип найден: " + logo.getAttribute("alt"));
        }
    }

    public void clickMoreInfo() {
        getMoreInfoLink().click();
    }

    public void verifyMoreInfo(){
        wait.until(ExpectedConditions.titleIs("Порядок оплаты и безопасность интернет платежей"));
    }

    public WebElement getPhoneNumberField() {
        return driver.findElement(phoneNumber);
    }

    public WebElement getAmountField() {
        return driver.findElement(amountField);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public void dropdownClick(){
        By dropdown = By.className("select__header");
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        WebElement dropdownDropdown = driver.findElement(dropdown);
        dropdownDropdown.click();
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
        WebElement element = driver.findElement(uslugiSvyazi);
        return element;
    }

    public WebElement getDomashniyInternet(){
        WebElement element = driver.findElement(domashniyInternet);
        return element;
    }

    public WebElement getRassrochka(){
        WebElement element = driver.findElement(rassrochka);
        return element;
    }

    public WebElement getZadolzhennost(){
        WebElement element = driver.findElement(zadolzhennost);
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
        getDomashniyInternet().click();
    }

    public void switchToRassrochka(){
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(rassrochka));
        field.click();
    }

    public void switchToZadolzhennost(){
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(zadolzhennost));
        field.click();
    }

    public void switchToUslugiSvyazi(){
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(uslugiSvyazi));
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