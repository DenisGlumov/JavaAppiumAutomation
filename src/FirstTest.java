import io.appium.java_client.AppiumDriver;
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
import java.util.ArrayList;
import java.util.List;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", "/Users/glumovdenis/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/wikipedia-2-7-50437-r-2023-04-12.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        WebElement elementSkip = driver.findElementById("fragment_onboarding_skip_button");
        elementSkip.click();

        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search 'Search Wikipedia' input",
                5);

        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                5);

        waitForElementPresent(By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java' ",
                15
        );
    }

    @Test
    public void testCancelSearch() {

        WebElement elementSkip = driver.findElementById("fragment_onboarding_skip_button");
        elementSkip.click();

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search 'Search Wikipedia' input",
                5
        );

        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                5);

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                5
        );

        waitForElementAndClick(By.xpath("//*[contains(@content-desc, 'Navigate up')]"),
                "Cannot find search button to cancel search ",
                5
        );

        waitForElementNotPresent(By.id("Navigate up"),
                "Button back still present on the page",
                10
        );
    }

    @Test
    public void testCompareArticleTitle() {
        WebElement elementSkip = driver.findElementById("fragment_onboarding_skip_button");
        elementSkip.click();

        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search 'Search Wikipedia' input",
                5);

        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                5);

        waitForElementAndClick(By.xpath("//*[contains(@text, 'Object-oriented programming language')]"),
                "Cannot find search 'Object-oriented programming language' input",
                5);

        WebElement title_element = waitForElementPresent(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "Cannot find article title",
                15
        );

        String article_element = title_element.getAttribute("text");

        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_element
        );
    }

    @Test
    public void testHomeWork2_1() {
        WebElement elementSkip = driver.findElementById("fragment_onboarding_skip_button");
        elementSkip.click();
        assertElementHasText(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Search Wikipedia",
                "text is different"
        );
    }

    @Test
    public void testHomeWork2_2() {
        WebElement elementSkip = driver.findElementById("fragment_onboarding_skip_button");
        elementSkip.click();
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "football",
                "Cannot find search input",
                5);
        int elementCount = driver.findElements(By.id("org.wikipedia:id/page_list_item_title")).size();

        Assert.assertNotEquals("Found only one article",
                1,
                elementCount);

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                5
        );

        waitForElementAndClick(By.xpath("//*[contains(@content-desc, 'Navigate up')]"),
                "Cannot find search button to cancel search ",
                5
        );

        waitForElementNotPresent(By.id("Navigate up"),
                "Button back still present on the page",
                10
        );
    }

    @Test
    public void testHomeWork2_3() {
        WebElement elementSkip = driver.findElementById("fragment_onboarding_skip_button");
        elementSkip.click();
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "java",
                "Cannot find search input",
                5);
        int elementCount = driver.findElements(By.id("org.wikipedia:id/page_list_item_title")).size();
        List<WebElement> elementSearch = driver.findElements(By.id("org.wikipedia:id/page_list_item_title"));

        for (int i=0; i<elementCount; i++) {
            System.out.println(elementSearch.get(i).getAttribute("text"));
            Assert.assertTrue(elementSearch.get(i).getAttribute("text").contains("Java"));
        }

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

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    private WebElement assertElementHasText(By by, String text, String error_message) {
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
}
