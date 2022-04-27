package pages.workout;

import elements.WorkoutRunInputFileds;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.WorkoutModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WorkoutStaticLocators;


@Log4j
public class WorkoutTabRunPage extends BasePage {
    WorkoutStaticLocators workoutStaticLocators;
    private By RUN_TAB = By.xpath("//a[@data-code='run']");

    public WorkoutTabRunPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input data in Run workout tab fields and click 'Add Workout'")
    public void saveNewRunWorkoutForm(WorkoutModel runTabModel) {
        WorkoutStaticLocators workoutStaticLocators = new WorkoutStaticLocators();
        driver.findElement(workoutStaticLocators.ADD_WORKOUT_BUTTON).click();
        driver.findElement(RUN_TAB).click();
        new WorkoutRunInputFileds(driver, "WorkoutTime").inputText(runTabModel.getWorkoutTime());
        new WorkoutRunInputFileds(driver, "Name").inputText(runTabModel.getName());
        new WorkoutRunInputFileds(driver, "Desc").inputText(runTabModel.getDesc());
    }

}
