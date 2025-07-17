import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class FormAndButtonTest {
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
    public void testFormFillAndContinue() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
        }
        String phoneInputXpath = "//*[@id=\"connection-phone\"]";
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(phoneInputXpath)));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");
        WebElement sumField = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        sumField.clear();
        sumField.sendKeys("100");
        Assertions.assertEquals("100", sumField.getAttribute("value"));
        String continueButtonXpath = "//*[@id=\"pay-connection\"]/button";
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueButtonXpath)));
        continueBtn.click();
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframeElement);
        String nextStepXpath = "/html/body/div[8]/div/iframe";
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextStepXpath)));
            System.out.println("Переход выполнен успешно.");
        } catch (TimeoutException e) {
            Assertions.fail("Следующий шаг не появился после нажатия кнопки");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}