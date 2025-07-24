import org.junit.jupiter.api.*;

public class BlockTitleTest extends SetUp {

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
    public void testBlockTitle() {
        Assertions.assertEquals("Онлайн пополнение без комиссии", mainPage.getBlockTitle());
    }
}