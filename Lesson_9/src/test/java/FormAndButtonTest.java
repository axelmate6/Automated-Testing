import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class FormAndButtonTest extends SetUp {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testFormFillAndContinue() {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"connection-phone\"]")));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");
        WebElement sumField = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        sumField.clear();
        sumField.sendKeys("100");
        Assertions.assertEquals("100", sumField.getAttribute("value"));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-connection\"]/button")));
        continueBtn.click();
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(iframeElement);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gpay-button-online-api-id\"]")));
        System.out.println("Переход выполнен успешно.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}