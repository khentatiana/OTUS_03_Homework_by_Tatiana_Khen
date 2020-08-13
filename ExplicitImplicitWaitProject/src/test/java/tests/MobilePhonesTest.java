package tests;



import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IBaseBeforeAfter;
import pages.BasePage;
import pages.YandexComparePage;
import pages.YandexMobileHomePage;
import pages.YandexSearchResultPage;
import utils.BaseHooks;

public class MobilePhonesTest extends BaseHooks {
    @Epic("Epic sample tests for Yandex")
    @Feature(value = "Test1")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This is MobilePhonesTest")

    @Test
    public void yandexMobileTest() throws InterruptedException {
        YandexMobileHomePage yandexMobileHomePage = new YandexMobileHomePage(driver);
        YandexComparePage yandexComparePage = new YandexComparePage(driver);
        YandexSearchResultPage yandexSearchResultPage = new YandexSearchResultPage(driver);


        yandexMobileHomePage.openPage();
        logger.info("========Opened mobile page");
        yandexMobileHomePage.searchTest();
        logger.info("========Searching for key words");

        yandexSearchResultPage.checkSearchResultListSize();
        logger.info("========Checked search results");
        yandexSearchResultPage.sortSearchResultsByCategory();
        logger.info("========Sorted results");
        yandexSearchResultPage.addFirstInSearchResultList();
        logger.info("========Added first phone to compare list");
        //searchResultPage.addedToCompareMessage();
        //driver.navigate().back();
        yandexSearchResultPage.addSecondInSearchResultList();
        logger.info("========Added second phone to compare list");
        //
        //yandexSearchResultPage.addedToCompareMessage();
        logger.info("========Clicked compare message");
        Thread.sleep(40000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("============" + currentUrl);
        Thread.sleep(40000);
        yandexComparePage.openPage();
        logger.info("========Opened compare mobile page");
        Thread.sleep(40000);

    }

}
//div[contains(@data-bem, '%n')]
