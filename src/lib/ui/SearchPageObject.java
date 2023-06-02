package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject{

    protected static String
            SEARH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_RESULT_LIST,
            SEARCH_EMPTY_RESULT_ELEMENT,
            CLEAR_SEARCH_LINE;

    public SearchPageObject(AppiumDriver driver){
        super(driver);
    }
    /*TEMPLATE METHODS*/
    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATE METHODS*/

    public void initSearchInput(){
        this.waitForElementPresent(SEARH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARH_INIT_ELEMENT, "Cannot find and click search init element", 5);
     }

     public void waitForCancelButtonToAppear(){
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
     }

    public void waitForCancelButtonToDisappear(){
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void clickCancelSearch(){
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

     public void typeSearchLine(String search_line){
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
     }

     public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
     }
    public void clickByArticleWithSubstring(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }

     public int getAmountOfFoundArticles(){
         this.waitForElementPresent(
                 SEARCH_RESULT_ELEMENT,
                 "Cannot find anything by the result",
                 15
         );
         return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
     }

     public void waitForEmptyResultLabel(){
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);
     }

     public void assertThereIsNoResultOfSearch(){
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
     }

     public void assertSearchLineContainsText (String search_line_contains){
         this.assertElementHasText(
                 SEARH_INIT_ELEMENT,
                 search_line_contains,
                 "text is different"
         );
     }

     public void clearTheSearchLine(){
         this.waitForElementAndClear(
                 CLEAR_SEARCH_LINE,
                 "Cannot find search field",
                 5
         );
     }

     public void checkSearchWordInSearchResult(String name_text_check){
         int elementCount = getAmountOfFoundArticles();
         System.out.println(elementCount);
         List<WebElement> elementSearch = this.getElementSearch(SEARCH_RESULT_LIST);
//         List<WebElement> elementSearch = driver.findElements(SEARCH_RESULT_LIST);
         System.out.println(elementSearch.toString());

         for (int i = 0; i < elementCount; i++) {
             System.out.println(elementSearch.get(i).getAttribute("text"));
             Assert.assertTrue(elementSearch.get(i).getAttribute("text").contains(name_text_check));
         }
     }
}
