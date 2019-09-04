package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


abstract public class BasePage {
    public static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    private static final long DEFAULT_WAIT_TIME_OUT = 10;


    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, DEFAULT_WAIT_TIME_OUT);
    }

    public abstract BasePage load();


}
