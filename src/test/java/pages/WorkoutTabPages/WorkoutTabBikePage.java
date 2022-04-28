package pages.WorkoutTabPages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
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
    public void saveNewBikeWorkoutForm() {
        log.info("Start added data in Bike workout fields");
        driver.get(WebUrls.ADD_WORKOUT_BUTTON);
        driver.findElement(BIKE_TAB).click();
        driver.findElement(TIME_OF_DAY_FIELD).sendKeys("1400");
        driver.findElement(WORKOUT_NAME).sendKeys(GenerateFakeMessage.getName());
        driver.findElement(WORKOUT_DESCRIPTION).sendKeys(GenerateFakeMessage.getDescription());
        driver.findElement(DISTANCE_FIELD).sendKeys(GenerateFakeMessage.getDistance());
        Select distanceType = new Select(driver.findElement(DISTANCE_TYPE));
        distanceType.selectByVisibleText("km");
        driver.findElement(DURATION_FIELD).sendKeys("11000");
        Select paceType = new Select(driver.findElement(PACE_TYPE));
        paceType.selectByVisibleText("min/km");
        driver.findElement(ELEVATION_GAIN).sendKeys(GenerateFakeMessage.getElevation());
        Select elevationGainType = new Select(driver.findElement(ELEVATION_GAIN_TYPE));
        elevationGainType.selectByVisibleText("m");
        driver.findElement(ELEVATION_LOSS).sendKeys(GenerateFakeMessage.getElevation());
        Select elevationGainLoss = new Select(driver.findElement(ELEVATION_LOSS_TYPE));
        elevationGainLoss.selectByVisibleText("m");
        driver.findElement(GOOD_RADIO_BUTTON).click();
        Select perceivedEffort = new Select(driver.findElement(PERCEIVED_EFFORT));
        perceivedEffort.selectByValue("5");
        driver.findElement(AVG_POWER).sendKeys(GenerateFakeMessage.getAverage());
        driver.findElement(MAX_POWER).sendKeys(GenerateFakeMessage.getAverage());
        driver.findElement(AVG_CADENCE).sendKeys(GenerateFakeMessage.getAverage());
        driver.findElement(MAX_CADENCE).sendKeys(GenerateFakeMessage.getAverage());
        driver.findElement(MINIMUM_HR).sendKeys("80");
        driver.findElement(AVERAGE_HR).sendKeys("100");
        driver.findElement(MAXIMUM_HR).sendKeys("120");
        driver.findElement(CALORIES_BURNED).sendKeys(GenerateFakeMessage.getCaloriesBurned());
        log.info("All elements are added, click on Add workout button");
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

    public boolean isWorkoutCreated() {
        driver.findElement(ACTIVITY_TYPE_NAME).isEnabled();
        return true;
    }

}
