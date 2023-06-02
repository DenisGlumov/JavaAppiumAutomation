package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
        OPTION_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        OPTION_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        MENU_APPEARED_CHANGE_LANGUAGE = "xpath://*[@text='Change language']";
        MENU_APPEARED_SHARE_LINK = "xpath://*[@text='Share link']";
        MENU_APPEARED_ADD_TO_READING_LIST = "xpath://*[@text='Add to reading list']";
        MENU_APPEARED_FIND_IN_PAGE = "xpath://*[@text='Find in page']";
        MENU_APPEARED_SIMILAR_PAGES = "xpath://*[@text='Similar pages']";
        MENU_APPEARED_FRONT_END_THEM = "xpath://*[@text='Font and theme']";
        MY_CREATE_LIST = "id:org.wikipedia:id/item_container";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
