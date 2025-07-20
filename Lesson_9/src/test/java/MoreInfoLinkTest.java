import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class MoreInfoLinkTest {
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
    public void testMoreInfoLink() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
        }
        String linkXpath = "//a[contains(text(), 'Подробнее о сервисе')]";
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkXpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
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