package tests.logintests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginpages.LoginPage;
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

    @Test
    @Description("Check that if you enter an incorrect password, a message is displayed stating that the username or password entered is incorrect")
    public void loginWithIncorrectEmailTest(){
        log.info("loginWithIncorrectEmailTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        Assert.assertEquals(loginPage.loginWithIncorrectEmail(),"Invalid login credentials. Please try again.","Incorrect login message is not displayed");
    }

    @Test
    @Description("Check that if you enter an incorrect password, a message is displayed stating that the username or password entered is incorrect")
    public void loginWithIncorrectPasswordTest(){
        log.info("loginWithIncorrectPasswordTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        Assert.assertEquals(loginPage.loginWithIncorrectPassword(),"Invalid login credentials. Please try again.","Incorrect login message is not displayed");
    }

    @Test
    @Description("Check that when you enter email, but not enter password, a message about incorrect password is displayed")
    public void loginWithoutPasswordTest(){
        log.info("loginWithoutPasswordTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        Assert.assertEquals(loginPage.loginWithoutPassword(),"Please enter a password.","Invalid message about password");
    }

    @Test
    @Description("Check that when you enter an incorrect email, a message about incorrect email is displayed")
    public void loginWithoutEmailTest(){
        log.info("loginWithoutEmailTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        Assert.assertEquals(loginPage.loginWithoutEmail(),"Please enter your e-mail address.","Invalid message about email");
    }

    @Test
    @Description("Check the possibility of logging out and displaying a message about successful exit from the profile")
    public void logoutFromProfileTest(){
        log.info("logoutFromProfileTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        Assert.assertEquals(loginPage.loginAndLogout(),"You have been successfully logged out of the system.","Logout message is not available or incorrect");
    }
}
