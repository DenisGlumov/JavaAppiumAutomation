import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeWork2_3 extends CoreTestCase {
    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }
    @Test
    public void testHomeWork2_3() {
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "java",
                "Cannot find search input",
                5);
        int elementCount = driver.findElements(By.id("org.wikipedia:id/page_list_item_title")).size();
        List<WebElement> elementSearch = driver.findElements(By.id("org.wikipedia:id/page_list_item_title"));

        for (int i = 0; i < elementCount; i++) {
            System.out.println(elementSearch.get(i).getAttribute("text"));
            Assert.assertTrue(elementSearch.get(i).getAttribute("text").contains("Java"));
        }

    }
}
