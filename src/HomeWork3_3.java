import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class HomeWork3_3 extends CoreTestCase {

    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        String title_before_rotation = articlePageObject.getArticleTitle();

        this.rotateScreenLandscape();
        String title_after_rotation = articlePageObject.getArticleTitle();

        assertEquals(
                "Article title have been change after screen orientation",
                title_before_rotation,
                title_after_rotation
        );
        this.rotateScreenPortrait();
        String title_after_second_rotation = articlePageObject.getArticleTitle();

        assertEquals(
                "Article title have been change after screen orientation",
                title_before_rotation,
                title_after_second_rotation
        );
    }
}
