import org.example.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormPlaceholderTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static MainPage mainPage;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Asus/IdeaProjects/Automated-Testing/lesson_10/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mts.by");
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyPlaceholdersForPaymentOptions() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
        }
        By dropdown = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        WebElement dropdownDropdown = driver.findElement(dropdown);
        dropdownDropdown.click();
        mainPage.switchToUslugiSvyazi();
        mainPage.verifyFieldsForUslugiSvyazi();
        dropdownDropdown.click();
        mainPage.switchToDomashniyInternet();
        mainPage.verifyFieldsForDomashniyInternet();
        dropdownDropdown.click();
        mainPage.switchToRassrochka();
        mainPage.verifyFieldsForRassrochka();
        dropdownDropdown.click();
        mainPage.switchToZadolzhennost();
        mainPage.verifyFieldsForZadolzhennost();
    }
}