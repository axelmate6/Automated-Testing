import org.example.MainPage;
import org.example.PayUpPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnfilledFieldsTest {
    private WebDriverWait wait;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Asus/IdeaProjects/Automated-Testing/lesson_10/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        mainPage.selectPayUpBlock();

        mainPage.selectPaymentOption("Услуги связи");

        mainPage.clickContinue();
    }

    @Test
    public void testUnfilledFieldsLabels() {
        PayUpPage topUpPage = new PayUpPage(driver);

        Assertions.assertEquals("Номер телефона", topUpPage.getFieldLabel("phoneNumber"));
        Assertions.assertEquals("Сумма", topUpPage.getFieldLabel("amount"));
        Assertions.assertEquals("Комментарий", topUpPage.getFieldLabel("comment"));
        Assertions.assertEquals("Карта", topUpPage.getFieldLabel("cardDetails"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}