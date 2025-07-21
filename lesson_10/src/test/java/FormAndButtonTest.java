import org.example.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormAndButtonTest {

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
        if (driver != null) { driver.quit(); }
    }

    @Test
    public void testFillFormAndVerifyConfirmation() {
//        mainPage.fillPhoneNumber("297777777");
//        mainPage.fillAmount("100");
//        mainPage.clickContinue();
//        Assertions.assertEquals("10", paymentPage.getDisplayedSum());
//        Assertions.assertEquals("297777777", paymentPage.getDisplayedPhone());
//        boolean hasCardFields = false;
//        for (var label : paymentPage.getUnfilledFieldsLabels()) {
//            String text = label.getText().toLowerCase();
//            if (text.contains("номер карты") || text.contains("срок действия") || text.contains("cvv")) {
//                hasCardFields = true;
//                break;
//            }
//        }
//        Assertions.assertTrue(hasCardFields, "Поля реквизитов карты присутствуют");
//
//        // Проверка отображения иконок платёжных систем
//        var icons = paymentPage.getPaymentIcons();
//        Assertions.assertFalse(icons.isEmpty(), "Иконки платёжных систем отображаются");
    }
}