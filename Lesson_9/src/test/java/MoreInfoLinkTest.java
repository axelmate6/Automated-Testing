import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class MoreInfoLinkTest extends SetUp {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testMoreInfoLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")));
        link.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Перешли по ссылке: " + currentUrl);
        driver.navigate().back();
        Assertions.assertTrue(driver.getPageSource().contains("Онлайн пополнение"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}