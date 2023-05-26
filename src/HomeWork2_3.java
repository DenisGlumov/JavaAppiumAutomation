import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class HomeWork2_3 extends CoreTestCase {
    @Test
    public void testHomeWork2_3() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("java");
        searchPageObject.checkSearchWordInSearchResult("Java");
    }
}
