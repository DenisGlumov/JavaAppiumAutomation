package lib.ui;

import com.sun.jna.platform.win32.Winspool;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListPageObject extends MainPageObject{

    public static final String
            FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
            ARTICLE_BY_TITLE_TPL = "//*[@text='{TITLE}']",
            ARTICLE_SELECTION = "org.wikipedia:id/page_list_item_title";

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
                By.xpath(folder_name_xpath),
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title){
        String article_xpath = getSaveArticleByTitle(article_title);
        this.waitForElementPresent(By.xpath(article_xpath), "Cannot find saved article by title", 15);
    }


    public void waitForArticleToDisappearByTitle(String article_title){
        String article_xpath = getSaveArticleByTitle(article_title);
        this.waitForElementNotPresent(By.xpath(article_xpath), "Saved article still present with title", 15);
    }

    public void swipeByArticleToDelete(String article_title){
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSaveArticleByTitle(article_title);
        this.swipeElementToLeft(
                By.xpath(article_xpath),
                "Cannot find saved article"
        );
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void articleSelection(){
        this.waitForElementAndClick(
                By.id(ARTICLE_SELECTION),
                "Cannot find 'Appium'",
                5
        );
    }
}
