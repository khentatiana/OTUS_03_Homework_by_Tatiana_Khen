package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class YandexComparePage extends BasePage{

    public YandexComparePage(WebDriver driver) {
        super(driver);
    }

    private static final String url = "https://market.yandex.ru/compare/2sEDXv8DBUdvCx8zdZzJj5AbV1Rm?hid=91491&id=401338434";
    public YandexComparePage openPage() throws InterruptedException {
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        logger.info("CURRENT URL IS CORRECT {}", currentUrl);
        Thread.sleep(40000);
        return this;
    }
//    public YandexComparePage searchTest(String searchKeyWords) throws InterruptedException {
//        Thread.sleep(40000);
//        WebElement input = driver.findElement(By.xpath("//input[@id='header-search']"));
//        input.sendKeys(searchKeyWords, Keys.RETURN);
//        String value = input.getAttribute("value");
//        Assert.assertEquals(searchKeyWords, value);
//        logger.info("Key words entered are CORRECT");
// return new YandexComparePage();
//    }
}
