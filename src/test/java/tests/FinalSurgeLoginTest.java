package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilites.Retry;

@Log4j
public class FinalSurgeLoginTest extends BaseTest {
    LoginPage loginPage;


    @Test(retryAnalyzer = Retry.class)
    @Description("Check that validation is successful when entering a login and password")
    public void loginTest() {
        log.info("FinalSurgeLoginTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        Assert.assertTrue(loginPage.isLoginIsSuccessful(), "Login is not success");
    }
}
