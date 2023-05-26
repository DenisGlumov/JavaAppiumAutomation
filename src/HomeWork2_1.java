import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class HomeWork2_1 extends CoreTestCase {
    @Test
    public void testHomeWork2_1() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.assertSearchLineContainsText("Search Wikipedia");
    }
}
