package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;

public class AndroidMyListsPageObject extends MyListPageObject {
    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
        ARTICLE_SELECTION = "id:org.wikipedia:id/page_list_item_title";
    }

    public AndroidMyListsPageObject(AppiumDriver driver){
        super(driver);
    }
}
