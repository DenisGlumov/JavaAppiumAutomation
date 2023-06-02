import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class HomeWork2_1 extends CoreTestCase {
    @Test
    public void testHomeWork2_1() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.assertSearchLineContainsText("Search Wikipedia");
    }
}
