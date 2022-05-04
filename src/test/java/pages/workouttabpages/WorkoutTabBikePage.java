package pages.workouttabpages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.AddWorkoutBikeModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import staticdata.WebUrls;
import utilites.GenerateFakeMessage;

@Log4j
public class WorkoutTabBikePage extends BasePage {

    private By BIKE_TAB = By.xpath("//a[@data-code='bike']");
    private By TIME_OF_DAY_FIELD = By.id("WorkoutTime");
    private By WORKOUT_NAME = By.id("Name");
    private By WORKOUT_DESCRIPTION = By.id("Desc");
    private By DISTANCE_FIELD = By.id("Distance");
    private By DISTANCE_TYPE = By.id("DistType");
    private By DURATION_FIELD = By.id("Duration");
    private By PACE_TYPE = By.id("PaceType");
    private By ELEVATION_GAIN = By.id("EGain");
    private By ELEVATION_GAIN_TYPE = By.id("EGainDistType");
    private By ELEVATION_LOSS = By.id("ELoss");
    private By ELEVATION_LOSS_TYPE = By.id("ELossDistType");
    private By GOOD_RADIO_BUTTON = By.id("hf_good");
    private By PERCEIVED_EFFORT = By.id("PerEffort");
    private By AVG_POWER = By.id("PowAvg");
    private By MAX_POWER = By.id("PowMax");
    private By AVG_CADENCE = By.id("CadAvg");
    private By MAX_CADENCE = By.id("CadMax");
    private By MINIMUM_HR = By.id("MinHR");
    private By AVERAGE_HR = By.id("AvgHR");
    private By MAXIMUM_HR = By.id("MaxHR");
    private By CALORIES_BURNED = By.id("kCal");
    private By ADD_WORKOUT_BUTTON = By.id("saveButton");
    private By ACTIVITY_TYPE_NAME = By.xpath("//span[@class='activityTypeName']");


    public WorkoutTabBikePage(WebDriver driver) {
        super(driver);
    }

    @Step("Input data in Bike workout tab fields and click 'Add Workout'")
    public void saveNewBikeWorkoutForm(AddWorkoutBikeModel bikeModel) {
        log.info("Start added data in Bike workout fields");
        driver.get(WebUrls.ADD_WORKOUT_BUTTON);
        driver.findElement(BIKE_TAB).click();
        driver.findElement(TIME_OF_DAY_FIELD).sendKeys(bikeModel.getTimeOfDay());
        driver.findElement(WORKOUT_NAME).sendKeys(bikeModel.getWorkoutName());
        driver.findElement(WORKOUT_DESCRIPTION).sendKeys(bikeModel.getWorkoutDescription());
        driver.findElement(DISTANCE_FIELD).sendKeys(bikeModel.getDistance());
        Select distanceType = new Select(driver.findElement(DISTANCE_TYPE));
        distanceType.selectByVisibleText("km");
        driver.findElement(DURATION_FIELD).sendKeys(bikeModel.getDuration());
        Select paceType = new Select(driver.findElement(PACE_TYPE));
        paceType.selectByVisibleText("min/km");
        driver.findElement(ELEVATION_GAIN).sendKeys(bikeModel.getElevationGain());
        Select elevationGainType = new Select(driver.findElement(ELEVATION_GAIN_TYPE));
        elevationGainType.selectByVisibleText("m");
        driver.findElement(ELEVATION_LOSS).sendKeys(bikeModel.getElevationLoss());
        Select elevationGainLoss = new Select(driver.findElement(ELEVATION_LOSS_TYPE));
        elevationGainLoss.selectByVisibleText("m");
        driver.findElement(GOOD_RADIO_BUTTON).click();
        Select perceivedEffort = new Select(driver.findElement(PERCEIVED_EFFORT));
        perceivedEffort.selectByValue("5");
        driver.findElement(AVG_POWER).sendKeys(bikeModel.getAvgPower());
        driver.findElement(MAX_POWER).sendKeys(bikeModel.getMaxPower());
        driver.findElement(AVG_CADENCE).sendKeys(bikeModel.getAvgCadence());
        driver.findElement(MAX_CADENCE).sendKeys(bikeModel.getMaxCadence());
        driver.findElement(MINIMUM_HR).sendKeys(bikeModel.getMinHr());
        driver.findElement(AVERAGE_HR).sendKeys(bikeModel.getAvgHr());
        driver.findElement(MAXIMUM_HR).sendKeys(bikeModel.getMaxHr());
        driver.findElement(CALORIES_BURNED).sendKeys(bikeModel.getCaloriesBurned());
        log.info("All elements are added, click on Add workout button");
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

    public boolean isWorkoutCreated() {
        if (driver.findElement(ACTIVITY_TYPE_NAME).isEnabled()) {
            return true;
        } else
            return false;
    }
}
