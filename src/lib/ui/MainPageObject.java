package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class MainPageObject {

    protected AppiumDriver driver;
    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public WebElement assertElementHasText(By by, String text, String error_message) {
        WebElement element = waitForElementPresent(by,
                "Cannot find search 'Search Wikipedia' input",
                10);
        String elementText = element.getAttribute("text");
        Assert.assertEquals(error_message,
                text,
                elementText
        );
        return element;
    }

    public void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        PointOption pointOption = new PointOption<>();


        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(PointOption.point(x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x,end_y))
                .release()
                .perform();
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeUpToFindElement(By by, String error_messege, int max_swipes) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swiped > max_swipes) {
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_messege, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(by, error_message, 10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(PointOption.point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
                .moveTo(PointOption.point(left_x, middle_y))
                .release()
                .perform();
    }

    public void waitForMenuAppeared() {
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

    public int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + by.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeeoutInSeconds);
        return element.getAttribute(attribute);
    }

    public void waitForMenuSecondAppeared() {
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

    public void assertElementPresent(By by, String error_message) {
        Assert.assertTrue(
                error_message,
                driver.findElement(by).isDisplayed()
        );
    }
}
