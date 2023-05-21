import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class HomeWork3_1 {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", "/Users/glumovdenis/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void saveFirstArticleToMyList() throws InterruptedException {
        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search 'Search Wikipedia' input",
                5);

        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find search input",
                5);

        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find search 'Object-oriented programming language' input",
                5);

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article option",
                5
        );

        waitForMenuAppeared();

        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find button to open article options",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay",
                5
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of article folder",
                5
        );

        String name_of_folder = "Learning programming";

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK button",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search 'Search Wikipedia' input",
                5);

        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "Appium",
                "Cannot find search input",
                5);

        waitForElementAndClick(By.xpath(
                        "//*[@text='Search Wikipedia']"),
                "Cannot find search 'Appium' input",
                15);

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article option",
                5
        );

        waitForMenuSecondAppeared();

        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find button to open article options",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/item_container"),
                "Cannot find 'My list'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My list",
                5
        );

        Thread.sleep(500);

        waitForElementAndClick(
                By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find created folder",
                5
        );

        swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );

        WebElement element_article = waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Cannot find 'Appium'",
                5
        );

        String article_element_text = element_article.getAttribute("text");

        Assert.assertEquals(
                "Article title have been change after screen orientation",
                "Appium",
                article_element_text
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Cannot find 'Appium'",
                5
        );

        WebElement article = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find 'Appium'",
                5
        );

        String article_text = article.getAttribute("text");

        Assert.assertEquals(
                "Article title have been change after screen orientation",
                "Appium",
                article_text
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private void waitForMenuAppeared() {
        waitForElementPresent(
                By.xpath("//*[@text='Change language']"),
                "Cannot find text 'Change language'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Share link']"),
                "Cannot find text 'Share link'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find text 'Add to reading list'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Find in page']"),
                "Cannot find text 'Find in page'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Similar pages']"),
                "Cannot find text 'Similar pages'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Font and theme']"),
                "Cannot find text 'Font and theme'",
                5
        );
    }

    private void waitForMenuSecondAppeared() {
        waitForElementPresent(
                By.xpath("//*[@text='Change language']"),
                "Cannot find text 'Change language'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Share link']"),
                "Cannot find text 'Share link'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find text 'Add to reading list'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Find in page']"),
                "Cannot find text 'Find in page'",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Font and theme']"),
                "Cannot find text 'Font and theme'",
                5
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(by, error_message, 10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x, middle_y)
                .release().perform();
    }
}
