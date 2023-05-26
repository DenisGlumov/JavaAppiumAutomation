import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
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

        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("football");

        int elementCount = searchPageObject.getAmountOfFoundArticles();
        System.out.println(elementCount);
        assertTrue(
                "We found too few results",
                elementCount > 0
        );
        searchPageObject.clearTheSearchLine();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelButtonToDisappear();
    }
}
