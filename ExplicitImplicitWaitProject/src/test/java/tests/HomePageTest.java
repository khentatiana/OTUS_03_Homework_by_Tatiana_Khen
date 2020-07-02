package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    String url = "https://yandex.ru";
    @Test
    public void openHomePage(){
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The HOME page URL is:");
        System.out.println("======" + currentUrl + "======");
        System.out.println();
        logger.info("Opened url {}", currentUrl );
        String title = driver.getTitle();
        System.out.println("The HOME page title is:");
        System.out.println("======" + title + "======");
        System.out.println();
        logger.info("Title of opened url {}", title );

        WebElement input = driver.findElement(By.xpath("//input[@id='text']"));
        input.sendKeys("otus");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@href='https://otus.ru/']"))).click();

    }
}
