package pages.gearandroutespages;

import elements.BikeName;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.AddBikeModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import staticdata.WebUrls;

@Log4j
public class BikePage extends BasePage{

    private By BIKE_BUTTON = By.xpath("//td//a[contains (text(), 'Bikes')]");
    private By BIKE_NAME = By.id("ShoeName");
    private By BIKE_BRAND_BUTTON = By.id("s2id_ShoeBrand");
    private By BIKE_BRAND_INPUT_TEXT_FIELD = By.className("select2-input");
    private By BIKE_MODEL = By.id("ShoeModel");
    private By BIKE_COST = By.id("ShoeCost");
    private By BIKE_PURCHASED = By.id("ShoeDate");
    private By STARTING_DISTANCE = By.id("StartDist");
    private By STARTING_DISTANCE_TYPE = By.id("DistType");
    private By TRACK_DISTANCE_BUTTON = By.id("TrackDist");
    private By FRONT_TIRE_DISTANCE = By.id("FrontDist");
    private By FRONT_DIST_TYPE = By.id("FrontDistType");
    private By REAR_TIRE_DISTANCE = By.id("RearDist");
    private By REAR_DIST_TYPE = By.id("RearDistType");
    private By DISTANCE_ALERT = By.id("DistAlert");
    private By DISTANCE_ALERT_TYPE = By.id("DistAlertType");
    private By NOTES = By.id("ShoeNotes");
    private By ADD_BIKE_BUTTON = By.id("saveButton");
    private By ADDED_BIKE_BRAND = By.xpath("//div//a[@class='select2-choice']//span");


    public BikePage(WebDriver driver) {
        super(driver);
    }

    @Step("Input data in Bike tab fields and click 'Add Bike'")
    public void saveNewBikeForm(AddBikeModel bikeModel){
        log.info("Starting to add data in Bike tab fields");
        driver.get(WebUrls.GEAR_AND_ROUTES_URL);
        driver.findElement(BIKE_BUTTON).click();
        driver.findElement(BIKE_NAME).sendKeys(bikeModel.getBikeName());
        driver.findElement(BIKE_BRAND_BUTTON).click();
        driver.findElement(BIKE_BRAND_INPUT_TEXT_FIELD).sendKeys(bikeModel.getBikeBrand());
        driver.findElement(BIKE_BRAND_INPUT_TEXT_FIELD).sendKeys(Keys.ENTER);
        driver.findElement(BIKE_MODEL).sendKeys(bikeModel.getBikeModel());
        driver.findElement(BIKE_COST).sendKeys(bikeModel.getBikeCost());
        driver.findElement(BIKE_PURCHASED).sendKeys(bikeModel.getDatePurchased());
        driver.findElement(STARTING_DISTANCE).clear();
        driver.findElement(STARTING_DISTANCE).sendKeys(bikeModel.getStartingDistance());
        Select startingDistanceType = new Select(driver.findElement(STARTING_DISTANCE_TYPE));
        startingDistanceType.selectByVisibleText("km");
        driver.findElement(TRACK_DISTANCE_BUTTON).click();
        driver.findElement(FRONT_TIRE_DISTANCE).clear();
        driver.findElement(FRONT_TIRE_DISTANCE).sendKeys(bikeModel.getFrontTireStartingDistance());
        Select frontTyreDistanceType = new Select(driver.findElement(FRONT_DIST_TYPE));
        frontTyreDistanceType.selectByVisibleText("km");
        driver.findElement(REAR_TIRE_DISTANCE).clear();
        driver.findElement(REAR_TIRE_DISTANCE).sendKeys(bikeModel.getRearTireStartingDistance());
        Select rearTyreDistanceType = new Select(driver.findElement(REAR_DIST_TYPE));
        rearTyreDistanceType.selectByVisibleText("km");
        driver.findElement(DISTANCE_ALERT).sendKeys(bikeModel.getDistanceAlert());
        Select distanceAlertType = new Select(driver.findElement(DISTANCE_ALERT_TYPE));
        distanceAlertType.selectByVisibleText("km");
        driver.findElement(NOTES).sendKeys(bikeModel.getNotes());
        driver.findElement(ADD_BIKE_BUTTON).click();
        new BikeName(driver,bikeModel.getBikeName()).clickToNewAddedBike();
    }

    @Step("Return new bike added data")
    public AddBikeModel getBikeDetails(){
        log.info("Start method that return actual result in Bike tab");
        return AddBikeModel.builder()
                .bikeName(driver.findElement(BIKE_NAME).getAttribute("value"))
                .bikeBrand(driver.findElement(ADDED_BIKE_BRAND).getText())
                .bikeModel(driver.findElement(BIKE_MODEL).getAttribute("value"))
                .bikeCost(driver.findElement(BIKE_COST).getAttribute("value"))
                .datePurchased(driver.findElement(BIKE_PURCHASED).getAttribute("value"))
                .startingDistance(driver.findElement(STARTING_DISTANCE).getAttribute("value"))
                .frontTireStartingDistance(driver.findElement(FRONT_TIRE_DISTANCE).getAttribute("value"))
                .rearTireStartingDistance(driver.findElement(REAR_TIRE_DISTANCE).getAttribute("value"))
                .distanceAlert(driver.findElement(DISTANCE_ALERT).getAttribute("value"))
                .notes(driver.findElement(NOTES).getAttribute("value"))
                .build();
    }
}
