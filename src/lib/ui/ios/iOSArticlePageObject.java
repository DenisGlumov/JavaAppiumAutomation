package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTION_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        MY_CREATE_LIST = "id:org.wikipedia:id/item_container";
        CLOSE_ARTICLE_BUTTON = "id:Back";
       // CLOSE_ARTICLE_BUTTON = "id:Search";
        //ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
    }

    public iOSArticlePageObject(AppiumDriver driver){
        super(driver);
    }
}
