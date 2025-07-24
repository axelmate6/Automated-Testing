import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlockNameTest extends SetUp {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testBlockTitlePresence() {
        WebElement blockTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]")));
        Assertions.assertTrue(blockTitle.isDisplayed(), "Блок с названием не отображается");
        System.out.println("Название блока: " + blockTitle.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
