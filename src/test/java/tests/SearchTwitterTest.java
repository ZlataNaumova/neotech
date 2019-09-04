package tests;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.GoogleHomePage;
import sun.awt.image.ImageWatched;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(DataProviderRunner.class)
public class SearchTwitterTest extends BaseTest {

    static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Test
    public void searchTwitter(){
        String searchingText = "https://twitter.com";
        List<String> results =  new GoogleHomePage(webDriver).load()
                                .searchText("twitter.com").resultCollection.texts();
        assertThat(results).contains(searchingText);
        assertThat(results.get(0)).isEqualTo(searchingText);
    }


}
