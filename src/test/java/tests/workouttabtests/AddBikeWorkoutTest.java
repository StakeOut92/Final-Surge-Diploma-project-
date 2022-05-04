package tests.workouttabtests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.loginpages.LoginPage;
import pages.workouttabpages.WorkoutTabBikePage;
import utilites.TestListeners;

@Listeners(TestListeners.class)
@Log4j
public class AddBikeWorkoutTest extends BaseTest{
    LoginPage loginPage;
    WorkoutTabBikePage workoutTabBikePage;

    @Test(priority = 2)
    @Description("Checking that new bike workout was created and check that he successfully created")
    public void addNewBikeWorkoutTest(){
        log.info("addNewBikeWorkoutTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        workoutTabBikePage = new WorkoutTabBikePage(driver);
        workoutTabBikePage.saveNewBikeWorkoutForm();
        Assert.assertTrue(workoutTabBikePage.isWorkoutCreated(),"Bike Workout is not created, ot message is not appear");
    }
}
