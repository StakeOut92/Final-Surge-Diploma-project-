package tests.logintests;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilites.TestListeners;
import java.net.MalformedURLException;


@Listeners(TestListeners.class)
public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;


    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        DriverType driverType = null;
        if(browser.equals("chrome")){
            driverType = DriverType.CHROME;
        }
        else if (browser.equals("edge")){
            driverType = DriverType.EDGE;
        }
        else if (browser.equals("remotedriver")){
            driverType = DriverType.REMOTEDRIVER;
        }
        driverManager = factory.getManager(driverType);
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
