package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{
    private static final String
        TITLE = "id:org.wikipedia:id/view_page_title_text",
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
        OPTION_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
        OPTION_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']",
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
        MENU_APPEARED_CHANGE_LANGUAGE = "xpath://*[@text='Change language']",
        MENU_APPEARED_SHARE_LINK = "xpath://*[@text='Share link']",
        MENU_APPEARED_ADD_TO_READING_LIST = "xpath://*[@text='Add to reading list']",
        MENU_APPEARED_FIND_IN_PAGE = "xpath://*[@text='Find in page']",
        MENU_APPEARED_SIMILAR_PAGES = "xpath://*[@text='Similar pages']",
        MENU_APPEARED_FRONT_END_THEM = "xpath://*[@text='Font and theme']",
        MY_CREATE_LIST = "id:org.wikipedia:id/item_container",
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    public ArticlePageObject(AppiumDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement(){
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle(){
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter(){
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of the article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder){
        this.waitForElementAndClick(
                OPTION_BUTTON,
                "Cannot find button to open article option",
                5
        );

        this.waitForMenuAppeared();

        this.waitForElementAndClick(
                OPTION_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of article folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void closeArticle(){
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );
    }

    public void waitForMenuAppeared() {
        waitForElementPresent(
                MENU_APPEARED_CHANGE_LANGUAGE,
                "Cannot find text 'Change language'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_SHARE_LINK,
                "Cannot find text 'Share link'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_ADD_TO_READING_LIST,
                "Cannot find text 'Add to reading list'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_FIND_IN_PAGE,
                "Cannot find text 'Find in page'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_SIMILAR_PAGES,
                "Cannot find text 'Similar pages'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_FRONT_END_THEM,
                "Cannot find text 'Font and theme'",
                5
        );
    }

    public void waitForMenuSecondAppeared() {
        waitForElementPresent(
                MENU_APPEARED_CHANGE_LANGUAGE,
                "Cannot find text 'Change language'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_SHARE_LINK,
                "Cannot find text 'Share link'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_ADD_TO_READING_LIST,
                "Cannot find text 'Add to reading list'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_FIND_IN_PAGE,
                "Cannot find text 'Find in page'",
                5
        );
        waitForElementPresent(
                MENU_APPEARED_FRONT_END_THEM,
                "Cannot find text 'Font and theme'",
                5
        );
    }

    public void addSecondArticleToMyList(){
        this.waitForElementAndClick(
                OPTION_BUTTON,
                "Cannot find button to open article option",
                5
        );

        this.waitForMenuSecondAppeared();

        this.waitForElementAndClick(
                OPTION_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                MY_CREATE_LIST,
                "Cannot find 'My list'",
                5
        );
    }

    public void checkArticleWithoutWait(){
        this.assertElementPresent(
                TITLE,
                "Cannot find Article"
        );
    }
}
