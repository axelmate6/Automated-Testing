import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FormAndButtonTest extends SetUp {

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
    public void testFillFormAndVerifyConfirmation() {
        mainPage.fillPhoneNumber("297777777");
        mainPage.fillAmount("100.00");
        mainPage.clickContinue();
        paymentPage.iframeSwitch();
        Assertions.assertEquals("100.00", paymentPage.getDisplayedSum());
        Assertions.assertEquals("375297777777", paymentPage.getDisplayedPhone());
        Assertions.assertEquals("100.00", paymentPage.getButtonSum());
        paymentPage.verifyIframeFieldsPlaceholders();
        paymentPage.verifyCardBrands();
    }
}