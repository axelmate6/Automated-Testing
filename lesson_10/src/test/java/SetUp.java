import Pages.MainPage;
import Pages.PaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SetUp{
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MainPage mainPage;
    protected PaymentPage paymentPage;

    public void setUp(){
        String currrentDir = System.getProperty("user.dir");
        String driverPath = currrentDir + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (TimeoutException e) {
        }
    }
}
