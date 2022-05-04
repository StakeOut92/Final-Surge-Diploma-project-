package tests.workouttabtests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import models.AddWorkoutRunModel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.loginpages.LoginPage;
import pages.workouttabpages.WorkoutTabRunPage;
import testdata.GetNewWorkoutRunModel;
import utilites.TestListeners;

@Listeners(TestListeners.class)
@Log4j
public class AddRunWorkoutTest extends BaseTest {
    LoginPage loginPage;
    WorkoutTabRunPage workoutTabRunPage;
    AddWorkoutRunModel result;

    @Test(priority = 2)
    @Description("Checking that new run workout was created and check that he successfully created")
    public void addNewRunWorkoutTest(){
    log.info("addNewRunWorkoutTest started");
    loginPage = new LoginPage(driver);
    loginPage.openPage();
    loginPage.makeLogin();
    workoutTabRunPage = new WorkoutTabRunPage(driver);
    workoutTabRunPage.saveNewRunWorkoutForm(GetNewWorkoutRunModel.getRunFields());
    Assert.assertTrue(workoutTabRunPage.isWorkoutCreated(),"Workout is not created");
    }

    @Test(priority = 2)
    @Description("Check the possibility of deleting events through the calendar tab and check that the event has been deleted")
    public void deleteRunWorkoutTest(){
        log.info("deleteRunWorkoutTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        workoutTabRunPage = new WorkoutTabRunPage(driver);
        workoutTabRunPage.saveNewRunWorkoutForm(result = GetNewWorkoutRunModel.getRunFields());
        Assert.assertTrue(workoutTabRunPage.isWorkoutDeleted(result),"Workout Run data is not delete");
    }
}
