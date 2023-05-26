package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
            STEP_LEARN_MORE_LINK = "id:Узнать подробнее о Википедии",
            STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:Новые способы изучения",
            STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "id:Искать на почти 300 языках",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Узнать подробнее о сборе данных",
            NEXT_LINK = "id:Далее",
            GET_STARTED_BUTTON = "id:Начать";
    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink(){
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Узнать подробнее о Википедии' link", 10);
    }

    public void waitForNewWayToExploreText(){
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'Новые способы изучения' link", 10);
    }

    public void waitForAddOrEditPreferredLangText(){
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Cannot find 'Искать на почти 300 языках' link", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText(){
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Cannot find 'Узнать подробнее о сборе данных' link", 10);
    }

    public void clickNextButton(){
        this.waitForElementAndClick(NEXT_LINK, "Cannot find and click 'далее' link", 10);
    }

    public void clickGetStartedButton(){
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find and click 'Начать' link", 10);
    }
}
