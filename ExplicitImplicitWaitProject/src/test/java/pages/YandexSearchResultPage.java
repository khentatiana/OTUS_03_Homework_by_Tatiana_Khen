package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class YandexSearchResultPage extends BasePage {


    //    int expectedNumOfResults = 71;
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);


    public YandexSearchResultPage(WebDriver driver) {
        super(driver);
    }

    int expectedNumOfResults = 71;
    private static final String searchResultListLocator = "cia-vs";

    public YandexSearchResultPage checkSearchResultListSize() {
        List<WebElement> searchResultList = driver.findElements(By.className(searchResultListLocator));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(dr -> searchResultList.size() > 0);
        System.out.println("=================" + searchResultList.size() + "=================");
        Assert.assertEquals(searchResultList.size(), expectedNumOfResults);
        logger.info("List of search results are CORRECT {}", searchResultList.size());
        return new YandexSearchResultPage(driver);
    }

    private static final String sortTabLocator = "//*[@data-autotest-id='dprice']";
    private static final String expectedTabText = "по цене";

    public YandexSearchResultPage sortSearchResultsByCategory() {
        WebElement byPrice = driver.findElement(By.xpath(sortTabLocator));
        byPrice.click();
        String actualText = byPrice.getText();
        Assert.assertEquals(actualText, expectedTabText);
        logger.info("Found tab {}", expectedTabText);
        return new YandexSearchResultPage(driver);
    }

    private static final String firstResultListLocator = "//article[1]//div[2]//div[1]";
    private static final String secondResultListLocator = "//article[2]//div[2]//div[1]";

    public YandexSearchResultPage addFirstInSearchResultList() {
        List<WebElement> firstInSearchResultList = driver.findElements(By.xpath(firstResultListLocator));
        jse.executeScript("window.scrollTo(0,0)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions action = new Actions(driver);
        action.moveToElement(firstInSearchResultList.get(1)).click().perform();
        wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) By.xpath(firstResultListLocator)));
        WebElement price = driver.findElement(By.xpath("//article[1]//div[4]//div[1]//a[1]//div[1]//span//span"));
        String priceText = price.getText();
        logger.info("First phone is added to comparison list. The price is {}", priceText);
        return new YandexSearchResultPage(driver);
    }

    public YandexSearchResultPage addSecondInSearchResultList() {
        List<WebElement> secondsInSearchResultList = driver.findElements(By.xpath(secondResultListLocator));
        jse.executeScript("window.scrollTo(0,0)");
        Actions action = new Actions(driver);
        action.moveToElement(secondsInSearchResultList.get(2)).click().perform();
        WebElement price = driver.findElement(By.xpath("//article[2]//div[4]//div[1]//a[1]//div[1]//span"));
        String priceText = price.getText();
        logger.info("Second phone is added to comparison list. The price is {}", priceText);
        return new YandexSearchResultPage(driver);
    }

    private static final String buttonCompareLocator = "//a[@class='_2EPSjI-GdM _1U1dDjJdGe _2s55WErgIp BCVQlNQsVv x5ZEihgKEK']//span[@class='_14Uuc5WvKg']";

    // private static final String messageXpathLocator = "//div[@class='_1_ABPFjOJQ']";
    public YandexComparePage addedToCompareMessage() {
        //WebElement message = driver.findElement(By.xpath(messageXpathLocator));
        //String messageText = message.getText();
        // System.out.println("========" + messageText);
        WebElement buttonCompare = driver.findElement(By.xpath(buttonCompareLocator));
        wait.until(ExpectedConditions.visibilityOf(buttonCompare));
        buttonCompare.click();
        //return new YandexSearchResultPage(driver);
        return new YandexComparePage(driver);
    }

}
