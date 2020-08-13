package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class YandexMobileHomePage extends BasePage {


    public YandexMobileHomePage(WebDriver driver) {
        super(driver);
    }

    private static final String url = "https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?hid=91491";
    private static final String searchKeyWords = "xiaomi и redmi";
    private By searchLocator = By.xpath("//input[@id='header-search']");
    private static final String searchAttribute = "value";


    public YandexMobileHomePage openPage() throws InterruptedException {
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        logger.info("CURRENT URL IS CORRECT {}", currentUrl);
        Thread.sleep(40000);
        return this;
    }

    public YandexSearchResultPage searchTest(String searchKeyWords, String searchLocator, String searchAttribute) throws InterruptedException {
        //Thread.sleep(40000);
        WebElement input = driver.findElement(By.xpath(searchLocator));
        input.sendKeys(searchKeyWords, Keys.RETURN);
        String value = input.getAttribute(searchAttribute);
        Assert.assertEquals(searchKeyWords, value);
        logger.info("Key words entered are CORRECT");

       return new YandexSearchResultPage(driver);
    }
//    public void searchTest(String searchKeyWords) throws InterruptedException {
//         Thread.sleep(40000);
//         WebElement input = driver.findElement(By.xpath("//input[@id='header-search']"));
//        input.sendKeys(searchKeyWords, Keys.RETURN);
//        String value = input.getAttribute("value");
//        Assert.assertEquals(searchKeyWords, value);
//        logger.info("Key words entered are CORRECT");
//
//    }
    public void searchYandexMobileHomePage(){

    }


    public  void addFirstInSearchResultList(String xpathLocator){
        List<WebElement> firstInSearchResultList = driver.findElements(By.xpath(xpathLocator));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions action = new Actions(driver);
        action.moveToElement(firstInSearchResultList.get(1)).click().perform();
        logger.info("First phone is added to comparison list");
    }

    public YandexSearchResultPage openYandexSearchResultPage(WebDriver driver){
        return new YandexSearchResultPage(driver);
    }
    public YandexComparePage openYandexComparePage(WebDriver driver){
        return new YandexComparePage(driver);
    }

    public void searchTest() {
    }

//    public abstract void confirmAddMessage(){}

}
