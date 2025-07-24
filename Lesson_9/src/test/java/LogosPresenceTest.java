import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LogosPresenceTest extends SetUp {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testPaymentLogos() {
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

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}