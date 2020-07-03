package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {

    @Test
    public void yandexMobileTest() throws InterruptedException {
        //Call openYandexMobilePage method
        openYandexMobilePage();
        searchTest();
        searchResults();
        sortSearchResultsByPrice();

    }

    public static void openYandexMobilePage() {
        driver.get("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?hid=91491");
        String currentUrl = driver.getCurrentUrl();
        // Assert.assertEquals(currentUrl, "https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?hid=91491");
        logger.info("CURRENT URL IS CORRECT {}", currentUrl);
    }

    public static void searchTest() throws InterruptedException {
        Thread.sleep(40000);
        String searchKeyWords = "Xiaomi и RedMi";
        WebElement input = driver.findElement(By.xpath("//input[@id='header-search']"));
        input.sendKeys(searchKeyWords, Keys.RETURN);

        String value = input.getAttribute("value");
        Assert.assertEquals(searchKeyWords, value);
        logger.info("Key words entered are CORRECT");

    }

    public static void searchResults() {
        List<WebElement> searchResultList = driver.findElements(By.className("cia-vs"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(dr -> searchResultList.size() > 0);
        System.out.println("=================" + searchResultList.size() + "=================");
        Assert.assertEquals(searchResultList.size(), 71);
        logger.info("List of search results are CORRECT {}", searchResultList.size());
    }

    public static void sortSearchResultsByPrice() {
        WebElement byPrice = driver.findElement(By.xpath("//*[@data-autotest-id='dprice']"));
        byPrice.click();
        String text = byPrice.getText();
        System.out.println(text);
        Assert.assertEquals(text, "по цене");
        logger.info("Found tab по цене");

    }

}
