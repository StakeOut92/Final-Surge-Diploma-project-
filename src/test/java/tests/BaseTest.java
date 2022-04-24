package tests;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
