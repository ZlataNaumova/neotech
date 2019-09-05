package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleHomePage extends BasePage {
    public GoogleHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private SelenideElement searchField = $x("//input[@name='q']");


    @Override
    public GoogleHomePage load() {
        searchField.shouldBe(Condition.visible);
        return this;
    }

    public SearchResultPage searchByText(String text) {
        searchField.sendKeys(text);
        $(byValue("Google Search")).click();
        return new SearchResultPage(webDriver).load();
    }
}
