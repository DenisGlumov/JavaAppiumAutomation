package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject{
    protected static String
        TITLE,
        FOOTER_ELEMENT,
        OPTION_BUTTON,
        OPTION_ADD_TO_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        MENU_APPEARED_CHANGE_LANGUAGE,
        MENU_APPEARED_SHARE_LINK,
        MENU_APPEARED_ADD_TO_READING_LIST,
        MENU_APPEARED_FIND_IN_PAGE,
        MENU_APPEARED_SIMILAR_PAGES,
        MENU_APPEARED_FRONT_END_THEM,
        MY_CREATE_LIST,
        CLOSE_ARTICLE_BUTTON;
    public ArticlePageObject(AppiumDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement(){
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle(){
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }

    public void swipeToFooter(){

        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    80
            );
        } else {
            this.swipeUpTitleElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    80 );
        }
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

    public void addArticlesToMySaved(){
        this.waitForElementAndClick(OPTION_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list",5);
    }

    public void checkArticleWithoutWait(){
        this.assertElementPresent(
                TITLE,
                "Cannot find Article"
        );
    }
}
