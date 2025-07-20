import org.example.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentLogosTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Asus/IdeaProjects/Automated-Testing/lesson_10/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPaymentLogosPresence() {
        Assertions.assertFalse(mainPage.getPaymentLogos().isEmpty(), "Логотипы платежных систем найдены");
    }
}