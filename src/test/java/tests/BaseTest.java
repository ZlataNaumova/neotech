package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Optional;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public static WebDriver webDriver;

    @Rule // automatically takes screenshot of every failed test
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @BeforeClass
    public static void beforeClass() {
        logger.info("Graphics environment info: {}", GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration()
                .getBounds()
                .toString());
        Configuration.browser = Optional.ofNullable(System.getenv("BROWSER")).orElse("chrome").toLowerCase();
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.timeout = 6000;
        WebDriverManager.chromedriver().version("2.38").setup();
        Configuration.baseUrl = "https://www.google.com/";
        logger.debug("base url is {}", Configuration.baseUrl);

    }

    @Before
    public void prepareBrowser() {
        WebDriverRunner.clearBrowserCache();
        //TODO inspect string bellow
        Selenide.open(Configuration.baseUrl);
        webDriver = getWebDriver();
        //new GoogleHomePage(webDriver).load();
        webDriver.manage().window().setPosition(new Point(1, 1));
        logger.info("Browser size is {}", webDriver.manage().window().getSize().toString());
    }

}
