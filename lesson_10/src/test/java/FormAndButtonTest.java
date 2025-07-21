import org.example.MainPage;
import org.example.PaymentPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormAndButtonTest {

    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Asus/IdeaProjects/Automated-Testing/lesson_10/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) { driver.quit(); }
    }

    @Test
    public void testFillFormAndVerifyConfirmation() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
        }
        mainPage.fillPhoneNumber("297777777");
        mainPage.fillAmount("100.00");
        mainPage.clickContinue();
        paymentPage.iframeSwitch();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span")));
        Assertions.assertEquals("100.00", paymentPage.getDisplayedSum());
        Assertions.assertEquals("375297777777", paymentPage.getDisplayedPhone());
        Assertions.assertEquals("100.00",paymentPage.getButtonSum());
        paymentPage.verifyIframeFieldsPlaceholders();
        List<WebElement> icons = paymentPage.getPaymentIcons();
        Assertions.assertFalse(icons.isEmpty(), "Иконки платёжных систем не отображаются");
    }
}