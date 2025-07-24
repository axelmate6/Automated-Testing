import org.junit.jupiter.api.*;

public class FormPlaceholderTest extends SetUp {

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
    public void verifyPlaceholdersForPaymentOptions() {
        mainPage.verifyFieldsForUslugiSvyazi();
        mainPage.dropdownClick();
        mainPage.switchToDomashniyInternet();
        mainPage.verifyFieldsForDomashniyInternet();
        mainPage.dropdownClick();
        mainPage.switchToRassrochka();
        mainPage.verifyFieldsForRassrochka();
        mainPage.dropdownClick();
        mainPage.switchToZadolzhennost();
        mainPage.verifyFieldsForZadolzhennost();
    }
}