package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import pages.GoogleHomePage;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchTwitterTest extends BaseTest {

    @Test
    public void searchTwitter() {
        String searchingText = "https://twitter.com";
        ElementsCollection searchResults = new GoogleHomePage(webDriver).load()
                .searchByText("twitter.com").resultCollection;
        searchResults.get(0).shouldHave(Condition.exactText(searchingText));
        // although it doesn't make sense to check that result set contains link because we're already checking that
        // first element is expected. done it as per task description.
        assertThat(searchResults.texts()).contains(searchingText);
    }


}
