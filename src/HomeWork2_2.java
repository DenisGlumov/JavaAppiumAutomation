import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class HomeWork2_2 extends CoreTestCase {
    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testHomeWork2_2() {
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "football",
                "Cannot find search input",
                5);
        int elementCount = driver.findElements(By.id("org.wikipedia:id/page_list_item_title")).size();
        System.out.println(elementCount);

        Assert.assertNotEquals("Found only one article",
                1,
                elementCount);

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                5
        );

        MainPageObject.waitForElementAndClick(By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find search button to cancel search ",
                5
        );

        MainPageObject.waitForElementNotPresent(By.id("Navigate up"),
                "Button back still present on the page",
                10
        );
    }
}
