import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoreInfoLinkTest extends SetUp {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMoreInfoLink() {
        mainPage.clickMoreInfo();
        mainPage.verifyMoreInfo();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Перешли по ссылке: " + currentUrl);
        driver.navigate().back();
        Assertions.assertTrue(driver.getPageSource().contains("Онлайн пополнение"));
    }
}