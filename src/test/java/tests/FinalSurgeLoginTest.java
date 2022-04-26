package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilites.Retry;


public class FinalSurgeLoginTest extends BaseTest {
    LoginPage loginPage;
    private static final Logger LOGGER = LogManager.getLogger(FinalSurgeLoginTest.class.getName());

    @Test(retryAnalyzer = Retry.class)
    @Description("Check that validation is successful when entering a login and password")
    public void loginTest() {
        LOGGER.info("FinalSurgeLoginTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        Assert.assertTrue(loginPage.isLoginIsSuccessful(), "Login is not success");
    }
}
