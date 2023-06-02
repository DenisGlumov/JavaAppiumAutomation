package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
                SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
                SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@text='{SUBSTRING}']";
                SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
                SEARCH_RESULT_LIST = "id:org.wikipedia:id/page_list_item_title";
                SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
                CLEAR_SEARCH_LINE = "id:org.wikipedia:id/search_src_text";
    }
    public AndroidSearchPageObject(AppiumDriver driver){
        super(driver);
    }
}
