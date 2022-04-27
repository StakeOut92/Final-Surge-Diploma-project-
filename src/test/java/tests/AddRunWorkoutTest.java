package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.workout.WorkoutTabRunPage;
import testdata.GetNewWorkoutRunTabModel;

@Log4j
public class AddRunWorkoutTest extends BaseTest{
    LoginPage loginPage;
    WorkoutTabRunPage workoutTabRunPage;

    @Test
    @Description("Checking that new run workout was created and check that he appers in calendar")
    public void addNewRunWorkoutTest(){
    log.info("addNewRunWorkoutTest started");
    loginPage = new LoginPage(driver);
    loginPage.openPage();
    loginPage.makeLogin();
    workoutTabRunPage = new WorkoutTabRunPage(driver);
    workoutTabRunPage.saveNewRunWorkoutForm(GetNewWorkoutRunTabModel.getRunWorkoutWithAllFields());
    }
}
