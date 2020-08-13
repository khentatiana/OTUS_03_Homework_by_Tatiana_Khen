package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


// abstract make BasePage to be inherited by outside classes, not make any changes.

public class BasePage {
    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
//
//    public void openPage(String url) {
//        driver.get(url);
//        String currentUrl = driver.getCurrentUrl();
//        //Assert.assertEquals(currentUrl, "https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?hid=91491");
//        logger.info("CURRENT URL IS CORRECT {}", currentUrl);
//    }
//    public void searchTest(String searchKeyWords, String locator, String attribute) throws InterruptedException {
//        Thread.sleep(40000);
//        WebElement input = driver.findElement(By.xpath(locator));
//        input.sendKeys(searchKeyWords, Keys.RETURN);
//        String value = input.getAttribute(attribute);
//        Assert.assertEquals(searchKeyWords, value);
//        logger.info("Key words entered are CORRECT");
//
//    }
}
