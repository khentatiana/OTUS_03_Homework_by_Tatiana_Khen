package utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseHooks {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected Logger logger = LogManager.getLogger(BaseHooks.class);


    @BeforeClass
    protected void oneTimeSetUp() {

        String browserType = System.getProperty("browser").toUpperCase();
        logger.info("Browser name is {}", browserType);
        System.out.println("======Browser name is " + browserType + "======");
        driver = WebDriverFactory.createNewDriver(browserType);
        logger.info("{} driver is created ", browserType);
        System.out.println("======New driver " + browserType + " is created======");
        if (driver != null) {
            wait = new WebDriverWait(driver, 30);
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            String browserType = System.getProperty("browser").toUpperCase();
            driver.quit();
            System.out.println("=========" + browserType + " browser is closed=====");
            logger.info("====={} browser is closed=====", browserType);
        }
    }

}

