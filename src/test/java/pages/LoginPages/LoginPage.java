package pages.LoginPages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.EmailAndPassword;
import staticdata.WebUrls;
import utilites.GenerateFakeMessage;


@Log4j
public class LoginPage extends BasePage {

    private By EMAIL_INPUT = By.id("login_name");
    private By PASSWORD_INPUT = By.id("login_password");
    private By LOGIN_BUTTON = By.xpath("//button[contains(.,'Login')]");
    private By LOGOUT_BUTTON = By.xpath("//a[contains(text(), 'Logout')]");
    private By INVALID_LOGIN_MESSAGE = By.xpath("//div[@class='alert alert-error']//strong");
    private By PLEASE_ENTER_PASSWORD_MESSAGE = By.xpath("//label[contains(@for, 'login_password') and contains(@class, 'error')]");
    private By PLEASE_ENTER_EMAIL_MESSAGE = By.xpath("//label[contains(@for, 'login_name') and contains(@class, 'error')]");
    private By LOGOUT_SUCCESS_MESSAGE = By.xpath("//div[@class='alert alert-success']//strong[contains(text(), 'successfully')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login url")
    public void openPage() {
        log.info("openPage method started");
        driver.get(WebUrls.LOGIN_PAGE);
    }

    @Step("Input email and password in fields")
    public void makeLogin() {
        log.info("makeLogin method started");
        driver.findElement(EMAIL_INPUT).sendKeys(EmailAndPassword.EMAIL);
        driver.findElement(PASSWORD_INPUT).sendKeys(EmailAndPassword.PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Check that login is successful")
    public boolean isLoginIsSuccessful() {
        log.info("isLoginIsSuccessful method started");
        driver.findElement(By.xpath("//div[@class='user-info']")).isDisplayed();
        return true;
    }

    @Step("Enter incorrect email when login")
    public String loginWithIncorrectEmail() {
        log.info("Login with incorrect email method started");
        driver.findElement(EMAIL_INPUT).sendKeys(GenerateFakeMessage.getRandomEmail());
        driver.findElement(PASSWORD_INPUT).sendKeys(EmailAndPassword.PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        String invalidLoginMessage = driver.findElement(INVALID_LOGIN_MESSAGE).getText();
        return invalidLoginMessage;
    }

    @Step("Enter incorrect password when login")
    public String loginWithIncorrectPassword() {
        log.info("Login with incorrect password method started");
        driver.findElement(EMAIL_INPUT).sendKeys(EmailAndPassword.EMAIL);
        driver.findElement(PASSWORD_INPUT).sendKeys(GenerateFakeMessage.getRandomPassword());
        driver.findElement(LOGIN_BUTTON).click();
        String invalidLoginMessage = driver.findElement(INVALID_LOGIN_MESSAGE).getText();
        return invalidLoginMessage;
    }

    @Step("Login without password")
    public String loginWithoutPassword() {
        log.info("Login without password method started");
        driver.findElement(EMAIL_INPUT).sendKeys(EmailAndPassword.EMAIL);
        driver.findElement(LOGIN_BUTTON).click();
        String enterPasswordMessage = driver.findElement(PLEASE_ENTER_PASSWORD_MESSAGE).getText();
        return enterPasswordMessage;
    }

    @Step("Login without email")
    public String loginWithoutEmail() {
        log.info("Login without email method started");
        driver.findElement(PASSWORD_INPUT).sendKeys(GenerateFakeMessage.getRandomPassword());
        driver.findElement(LOGIN_BUTTON).click();
        String enterEmailMessage = driver.findElement(PLEASE_ENTER_EMAIL_MESSAGE).getText();
        return enterEmailMessage;
    }

    @Step("Login, logout and check that logout is correct")
    public String loginAndLogout(){
        log.info("Login and logout method started");
        driver.findElement(EMAIL_INPUT).sendKeys(EmailAndPassword.EMAIL);
        driver.findElement(PASSWORD_INPUT).sendKeys(EmailAndPassword.PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(LOGOUT_BUTTON).click();
        String logoutSuccessMessage = driver.findElement(LOGOUT_SUCCESS_MESSAGE).getText();
        return logoutSuccessMessage;
    }
}
