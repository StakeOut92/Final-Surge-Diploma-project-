package tests.workouttabtests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginpages.LoginPage;
import pages.workouttabpages.WorkoutTabRunPage;

@Log4j
public class AddRunWorkoutTest extends BaseTest {
    LoginPage loginPage;
    WorkoutTabRunPage workoutTabRunPage;

    @Test
    @Description("Checking that new run workout was created and check that he successfully created")
    public void addNewRunWorkoutTest(){
    log.info("addNewRunWorkoutTest started");
    loginPage = new LoginPage(driver);
    loginPage.openPage();
    loginPage.makeLogin();
    workoutTabRunPage = new WorkoutTabRunPage(driver);
    workoutTabRunPage.saveNewRunWorkoutForm();
    Assert.assertTrue(workoutTabRunPage.isWorkoutCreated(),"Workout is not created");
    }
}
