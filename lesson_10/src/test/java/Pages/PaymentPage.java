package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By iframeClass = By.className("bepaid-iframe");
    private final By payClass = By.className("pay-description__cost");
    private final By cardPageClass = By.className("card-page__card");
    private final By payTextClass = By.className("pay-description__text");
    private final By cardBrands = By.className("cards-brands__container");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void iframeSwitch(){
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(iframeClass));
        driver.switchTo().frame(iframeElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(payClass));
    }

    public String getDisplayedSum() {
        String[] displayedSum = driver.findElement(payClass).getText().split(" ");
        return displayedSum[0];
    }

    public String getButtonSum(){
        WebElement we =driver.findElement(cardPageClass);
        String[] buttonSum = we.findElement(By.tagName("button")).getText().split(" ");
        return buttonSum[1];
    }

    public String getDisplayedPhone() {
        String[] displayedPhone = driver.findElement(payTextClass).getText().split("[^\\d\\.]+");
        return  displayedPhone[displayedPhone.length - 1];
    }

    public List<WebElement> getPaymentIcons1() {
        WebElement container = driver.findElement(cardBrands);
        return container.findElements(By.tagName("img"));

    }

    public List<WebElement> getPaymentIcons2() {
        WebElement container = driver.findElement(cardBrands);
        WebElement cont = container.findElement(By.tagName("div"));
        return cont.findElements(By.tagName("img"));

    }

    public void verifyIframeFieldsPlaceholders() {
        WebElement app = driver.findElement(By.tagName("app-card-input"));
        List<WebElement> lables = app.findElements(By.tagName("label"));
        for (int i = 0; i < lables.size()-1; i++) {
            WebElement lable = lables.get(i);
            String placeholder = lable.getText();
            System.out.println(placeholder + " найден");
        }
    }

    public void verifyCardBrands() {
        List<WebElement> icons = getPaymentIcons1();
        List<WebElement> icons2 = getPaymentIcons2();
        for (WebElement icon : icons) {
            if (icon.getAttribute("src").contains("visa")) {
                Assertions.assertTrue(icon.getAttribute("src").contains("visa"), "Логотип не отображается: ");
                System.out.println("Логотип найден: " + icon.getAttribute("src"));
            } else if (icon.getAttribute("src").contains("mastercard")) {
                Assertions.assertTrue(icon.getAttribute("src").contains("mastercard"), "Логотип не отображается: ");
                System.out.println("Логотип найден: " + icon.getAttribute("src"));
            } else if (icon.getAttribute("src").contains("belkart")) {
                Assertions.assertTrue(icon.getAttribute("src").contains("belkart"), "Логотип не отображается: ");
                System.out.println("Логотип найден: " + icon.getAttribute("src"));
            }
        }
        for (WebElement icon : icons2) {
            if (icon.getAttribute("src").contains("maestro")) {
                Assertions.assertTrue(icon.getAttribute("src").contains("maestro"), "Логотип не отображается: ");
                System.out.println("Логотип найден: " + icon.getAttribute("src"));
            } else if (icon.getAttribute("src").contains("mir")) {
                Assertions.assertTrue(icon.getAttribute("src").contains("mir"), "Логотип не отображается: ");
                System.out.println("Логотип найден: " + icon.getAttribute("src"));
            }
        }
        Assertions.assertFalse(icons.isEmpty(), "Иконки платёжных систем не отображаются");
    }
}