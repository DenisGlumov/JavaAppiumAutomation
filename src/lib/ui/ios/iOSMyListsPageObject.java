package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;

public class iOSMyListsPageObject extends MyListPageObject {

    static {
        CLOSE_BUTTON = "id:Close";
        //ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
        ARTICLE_SELECTION = "id:org.wikipedia:id/page_list_item_title";
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']/..";
    }

    public iOSMyListsPageObject(AppiumDriver driver){
        super(driver);
    }
}
