package tests;

import base.BaseTest;
import okhttp3.Route;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {

  //  String url = "https://yandex.ru";
//    @Test
//    public void openHomePage(){
//        driver.get(url);
//        String currentUrl = driver.getCurrentUrl();
//        System.out.println("The HOME page URL is:");
//        System.out.println("======" + currentUrl + "======");
//        System.out.println();
//        logger.info("Opened url {}", currentUrl );
//        String title = driver.getTitle();
//        System.out.println("The HOME page title is:");
//        System.out.println("======" + title + "======");
//        System.out.println();
//        logger.info("Title of opened url {}", title );
//
//        WebElement input = driver.findElement(By.xpath("//input[@id='text']"));
//        input.sendKeys("otus");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable
//                (By.xpath("//div[@href='https://otus.ru/']"))).click();
//
//    }
    @Test
    public void yandexMobileTest() throws InterruptedException{
        //Call openYandexMobilePage method
        openYandexMobilePage();
        searchTest();
        sortSearchResults();

    }
    public static void openYandexMobilePage(){
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
    public static void sortSearchResults(){
        List<WebElement> searchResultList = driver.findElements(By.className("_2Qo3ODl0by cia-vs"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(dr -> searchResultList.size() > 0);
        System.out.println(searchResultList);


        logger.info("List of search results {}", searchResultList );

    }


}
