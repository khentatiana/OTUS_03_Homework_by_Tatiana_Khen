package base;

import manager.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected static WebDriver driver;
    protected static Logger logger = LogManager.getLogger(BaseTest.class);


    @BeforeMethod
    protected void oneTimeSetUp() {

        String browserType = System.getProperty("browser").toUpperCase();
        logger.info("Browser name is {}", browserType);
        System.out.println("======Browser name is " + browserType + "======");
        driver = WebDriverFactory.createNewDriver(browserType);
        logger.info("{} driver is created ", browserType);
        System.out.println("======New driver " + browserType + " is created======");
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        }
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            String browserType = System.getProperty("browser").toUpperCase();
            driver.quit();
            System.out.println("=========" + browserType + " browser is closed=====");
            logger.info("====={} browser is closed=====", browserType);
        }
    }

}