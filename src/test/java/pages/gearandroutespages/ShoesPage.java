package pages.gearandroutespages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import staticdata.WebUrls;
import utilites.GenerateFakeMessage;

@Log4j
public class ShoesPage extends BasePage{

    private By SHOES_BUTTON = By.xpath("//td//a[contains (text(), 'Shoes')]");
    private By SHOE_NAME = By.id("ShoeName");
    private By SHOE_BRAND = By.id("ShoeBrand");
    private By SHOE_MODEL = By.id("ShoeModel");
    private By SHOE_COST = By.id("ShoeCost");
    private By DATE_PURCHASED = By.id("ShoeDate");
    private By SHOE_SIZE = By.id("ShoeSize");
    private By STARTING_DISTANCE = By.id("StartDist");
    private By STARTING_DISTANCE_TYPE = By.id("DistType");
    private By DISTANCE_ALERT = By.id("DistAlert");
    private By DISTANCE_ALERT_TYPE = By.id("DistAlertType");
    private By NOTES = By.id("ShoeNotes");
    private By ADD_SHOE_BUTTON = By.id("saveButton");

    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input data in Shoes tab fields and click 'Add shoe'")
    public void saveNewShoesForm()  {
        log.info("Staring to add data in Shoes tab fields");
        driver.get(WebUrls.GEAR_AND_ROUTES_URL);
        driver.findElement(SHOES_BUTTON).click();
        driver.findElement(SHOE_NAME).sendKeys("1st new shoes");
        Select shoeBrand = new Select(driver.findElement(SHOE_BRAND));
        shoeBrand.selectByVisibleText("adidas");
        driver.findElement(SHOE_MODEL).sendKeys(GenerateFakeMessage.getShoeModel());
        driver.findElement(SHOE_COST).sendKeys(GenerateFakeMessage.getShoePrice());
        driver.findElement(DATE_PURCHASED).sendKeys("22/04/2022");
        Select shoeSize = new Select(driver.findElement(SHOE_SIZE));
        shoeSize.selectByValue("5");
        driver.findElement(STARTING_DISTANCE).sendKeys(GenerateFakeMessage.getDistance());
        Select distanceType = new Select(driver.findElement(STARTING_DISTANCE_TYPE));
        distanceType.selectByVisibleText("km");
        driver.findElement(DISTANCE_ALERT).sendKeys(GenerateFakeMessage.getDistanceAlert());
        Select alertDistanceType = new Select(driver.findElement(DISTANCE_ALERT_TYPE));
        alertDistanceType.selectByValue("km");
        driver.findElement(NOTES).sendKeys(GenerateFakeMessage.getNotesMessage());
        driver.findElement(ADD_SHOE_BUTTON).click();
    }
}
