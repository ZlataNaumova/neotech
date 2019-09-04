package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;


public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver webDriver) {super(webDriver);}
    public ElementsCollection resultCollection = $$(".iUh30");


    @Override
    public SearchResultPage load() {
        $("#hdtb-msb-vis").shouldBe(Condition.visible);
        return this;
    }

}
