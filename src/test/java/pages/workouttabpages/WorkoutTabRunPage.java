package pages.workouttabpages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import staticdata.WebUrls;
import utilites.GenerateFakeMessage;


@Log4j
public class WorkoutTabRunPage extends BasePage {


    private By RUN_TAB = By.xpath("//a[@data-code='run']");
    private By TIME_OF_DAY_FIELD = By.id("WorkoutTime");
    private By WORKOUT_NAME = By.id("Name");
    private By WORKOUT_DESCRIPTION = By.id("Desc");
    private By DISTANCE_FIELD = By.id("Distance");
    private By DISTANCE_TYPE = By.id("DistType");
    private By DURATION_FIELD = By.id("Duration");
    private By PACE_TYPE = By.id("PaceType");
    private By GREAT_RADIO_BUTTON = By.id("hf_great");
    private By PERCEIVED_EFFORT = By.id("PerEffort");
    private By MINIMUM_HR = By.id("MinHR");
    private By AVERAGE_HR = By.id("AvgHR");
    private By MAXIMUM_HR = By.id("MaxHR");
    private By CALORIES_BURNED = By.id("kCal");
    private By ADD_WORKOUT_BUTTON = By.id("saveButton");
    private By ACTIVITY_TYPE_NAME = By.xpath("//span[@class='activityTypeName']");



    public WorkoutTabRunPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input data in Run workout tab fields and click 'Add Workout'")
    public void saveNewRunWorkoutForm() {
        log.info("Start added information in workout Run fields");
        driver.get(WebUrls.ADD_WORKOUT_BUTTON);
        driver.findElement(RUN_TAB).click();
        driver.findElement(TIME_OF_DAY_FIELD).sendKeys("1200");
        driver.findElement(WORKOUT_NAME).sendKeys(GenerateFakeMessage.getName());
        driver.findElement(WORKOUT_DESCRIPTION).sendKeys(GenerateFakeMessage.getDescription());
        driver.findElement(DISTANCE_FIELD).sendKeys(GenerateFakeMessage.getDistance());
        Select distanceType = new Select(driver.findElement(DISTANCE_TYPE));
        distanceType.selectByVisibleText("km");
        driver.findElement(DURATION_FIELD).sendKeys("10000");
        Select paceType = new Select(driver.findElement(PACE_TYPE));
        paceType.selectByVisibleText("min/km");
        driver.findElement(GREAT_RADIO_BUTTON).click();
        Select perceivedEffort = new Select(driver.findElement(PERCEIVED_EFFORT));
        perceivedEffort.selectByVisibleText("3 (Light)");
        driver.findElement(MINIMUM_HR).sendKeys("80");
        driver.findElement(AVERAGE_HR).sendKeys("100");
        driver.findElement(MAXIMUM_HR).sendKeys("120");
        driver.findElement(CALORIES_BURNED).sendKeys(GenerateFakeMessage.getCaloriesBurned());
        log.info("All elements are added, click on Add workout button");
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

    public boolean isWorkoutCreated(){
        driver.findElement(ACTIVITY_TYPE_NAME).isEnabled();
        return true;
    }


}
