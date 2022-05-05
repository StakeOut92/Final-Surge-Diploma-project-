package tests.gearandroutestests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import models.AddBikeModel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.gearandroutespages.BikePage;
import pages.loginpages.LoginPage;
import testdata.GetNewBikeAccountModel;
import tests.BaseTest;
import utilites.TestListeners;

@Listeners(TestListeners.class)
@Log4j
public class AddNewBikeTest extends BaseTest {
    LoginPage loginPage;
    BikePage bikePage;
    AddBikeModel actualResult;

    @Test(priority = 3)
    @Description("Checking that new bike was added and check that added data is correct")
    public void addNewBikeTest() {
        log.info("addNewBikeTest started");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        bikePage = new BikePage(driver);
        bikePage.saveNewBikeForm(actualResult = GetNewBikeAccountModel.getBikeFields());
        Assert.assertEquals(bikePage.getBikeDetails(), actualResult, "Added Bike data incorrect");
    }
}
