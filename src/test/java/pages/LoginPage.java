package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.EmailAndPassword;
import staticdata.WebUrls;
import tests.FinalSurgeLoginTest;


public class LoginPage extends BasePage {

    private By EMAIL_INPUT = By.id("login_name");
    private By PASSWORD_INPUT = By.id("login_password");
    private By LOGIN_BUTTON = By.xpath("//button[contains(.,'Login')]");
    private static final Logger LOGGER = LogManager.getLogger(FinalSurgeLoginTest.class.getName());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login url")
    public void openPage() {
        LOGGER.info("openPage method started");
        driver.get(WebUrls.LOGIN_PAGE);
    }

    @Step("Input email and password in fields")
    public void makeLogin() {
        LOGGER.info("makeLogin method started");
        driver.findElement(EMAIL_INPUT).sendKeys(EmailAndPassword.EMAIL);
        driver.findElement(PASSWORD_INPUT).sendKeys(EmailAndPassword.PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Check that login is successful")
    public boolean isLoginIsSuccessful(){
    LOGGER.info("isLoginIsSuccessful method started");
    driver.findElement(By.xpath("//div[@class='user-info']")).isDisplayed();
    return true;
    }
}
