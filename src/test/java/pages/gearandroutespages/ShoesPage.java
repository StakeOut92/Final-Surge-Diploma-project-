package pages.gearandroutespages;


import elements.ShoeName;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.AddShoeModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import staticdata.WebUrls;
import testdata.GetNewShoesAccountModel;


@Log4j
public class ShoesPage extends BasePage {



    private By SHOES_BUTTON = By.xpath("//td//a[contains (text(), 'Shoes')]");
    private By SHOE_NAME = By.id("ShoeName");
    private By SHOE_BRAND_INPUT_TEXT_FIELD = By.className("select2-input");
    private By SHOE_BRAND_BUTTON = By.id("s2id_ShoeBrand");
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
    private By ADDED_SHOE_BRAND = By.xpath("//div//a[@class='select2-choice']//span");

    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input data in Shoes tab fields and click 'Add shoe'")
    public void   saveNewShoesForm (AddShoeModel shoeModel) {
        log.info("Staring to add data in Shoes tab fields");
        driver.get(WebUrls.GEAR_AND_ROUTES_URL);
        driver.findElement(SHOES_BUTTON).click();
        driver.findElement(SHOE_NAME).sendKeys(shoeModel.getShoeName());
        driver.findElement(SHOE_BRAND_BUTTON).click();
        driver.findElement(SHOE_BRAND_INPUT_TEXT_FIELD).sendKeys(shoeModel.getShoeBrand());
        driver.findElement(SHOE_BRAND_INPUT_TEXT_FIELD).sendKeys(Keys.ENTER);
        driver.findElement(SHOE_MODEL).sendKeys(shoeModel.getShoeModel());
        driver.findElement(SHOE_COST).sendKeys(shoeModel.getShoeCost());
        driver.findElement(DATE_PURCHASED).sendKeys(shoeModel.getDatePurchased());
        Select shoeSize = new Select(driver.findElement(SHOE_SIZE));
        shoeSize.selectByValue("5");
        driver.findElement(STARTING_DISTANCE).sendKeys(shoeModel.getStartingDistance());
        Select distanceType = new Select(driver.findElement(STARTING_DISTANCE_TYPE));
        distanceType.selectByVisibleText("km");
        driver.findElement(DISTANCE_ALERT).sendKeys(shoeModel.getDistanceAlert());
        Select alertDistanceType = new Select(driver.findElement(DISTANCE_ALERT_TYPE));
        alertDistanceType.selectByValue("km");
        driver.findElement(NOTES).sendKeys(shoeModel.getNotes());
        driver.findElement(ADD_SHOE_BUTTON).click();
        new ShoeName(driver,shoeModel.getShoeName()).clickToNewAddedShoe();
    }

    @Step("Check that new shoe is added successful")
    public AddShoeModel getShoesDetails() {
        return AddShoeModel.builder()
                .shoeName(driver.findElement(SHOE_NAME).getAttribute("value"))
                .shoeBrand(driver.findElement(ADDED_SHOE_BRAND).getText())
                .shoeModel(driver.findElement(SHOE_MODEL).getAttribute("value"))
                .shoeCost(driver.findElement(SHOE_COST).getAttribute("value"))
                .datePurchased(driver.findElement(DATE_PURCHASED).getAttribute("value"))
                .startingDistance(driver.findElement(STARTING_DISTANCE).getAttribute("value"))
                .distanceAlert(driver.findElement(DISTANCE_ALERT).getAttribute("value"))
                .notes(driver.findElement(NOTES).getAttribute("value"))
                .build();
    }

}
