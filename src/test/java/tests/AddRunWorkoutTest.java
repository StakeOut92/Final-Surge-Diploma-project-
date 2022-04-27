package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.workout.WorkoutTabRunPage;

@Log4j
public class AddRunWorkoutTest extends BaseTest{
    LoginPage loginPage;
    WorkoutTabRunPage workoutTabRunPage;

    @Test
    @Description("Checking that new run workout was created and check that he appears in calendar")
    public void addNewRunWorkoutTest(){
    log.info("addNewRunWorkoutTest started");
    loginPage = new LoginPage(driver);
    loginPage.openPage();
    loginPage.makeLogin();
    workoutTabRunPage = new WorkoutTabRunPage(driver);
    log.info("saveNewRunWorkoutForm method started");
    workoutTabRunPage.saveNewRunWorkoutForm();
    Assert.assertTrue(workoutTabRunPage.isWorkoutCreated(),"Workout is not created");
    }
}
