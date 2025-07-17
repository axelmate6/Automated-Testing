import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LogosPresenceTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Asus/IdeaProjects/Automated-Testing/Lesson_9/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
    }

    @Test
    public void testPaymentLogos() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
        }
        String[] logoXPaths = {
                "//img[contains(@alt, 'Visa')]",
                "//img[contains(@alt, 'MasterCard')]",
                "//img[contains(@alt, 'Белкарт')]"
        };
        for (String xpath : logoXPaths) {
            WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Assertions.assertTrue(logo.isDisplayed(), "Логотип не отображается: " + logo.getAttribute("alt"));
            System.out.println("Логотип найден: " + logo.getAttribute("alt"));
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}