package lib.ui;
import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListPageObject extends MainPageObject{

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            ARTICLE_SELECTION,
            CLOSE_BUTTON;

    private static String getFolderXpathByName(String name_of_folder){
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSaveArticleByTitle(String article_title){
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }
    public MyListPageObject(AppiumDriver driver){
        super(driver);
    }
    public void openFolderByName(String name_of_folder) throws InterruptedException {
        Thread.sleep(500);
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        System.out.println(folder_name_xpath);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title){
        String article_xpath = getSaveArticleByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title", 25);
    }


    public void waitForArticleToDisappearByTitle(String article_title){
        String article_xpath = getSaveArticleByTitle(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title", 15);
    }

    public void swipeByArticleToDelete(String article_title){
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSaveArticleByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article"
        );

        if (Platform.getInstance().isIOS()) {
            this.clickToTheRightUpperCorner(article_xpath, "Cannot find saved article");

        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void articleSelection(){
        this.waitForElementAndClick(
                ARTICLE_SELECTION,
                "Cannot find 'Appium'",
                5
        );
    }

    public void clickCloseButton(){
        this.waitForElementAndClick(
                CLOSE_BUTTON,
                "Cannot click button 'Close'",
                5
        );
    }
}
