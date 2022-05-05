package tests.gearandroutestests;


import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import models.AddShoeModel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.gearandroutespages.ShoesPage;
import pages.loginpages.LoginPage;
import testdata.GetNewShoesAccountModel;
import tests.BaseTest;
import utilites.TestListeners;

@Listeners(TestListeners.class)
@Log4j
public class AddNewShoeTest extends BaseTest {

    LoginPage loginPage;
    ShoesPage shoesPage;
    AddShoeModel actualResult;

    @Test(priority = 3)
    @Description("Checking that new shoe was added and check that added data is correct")
    public void addNewShoeTest() {
        log.info("addNewShoeTest started ");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        shoesPage = new ShoesPage(driver);
        shoesPage.saveNewShoesForm( actualResult = GetNewShoesAccountModel.getShoeFields());
        Assert.assertEquals(shoesPage.getShoesDetails(),actualResult,"Added Shoe data incorrect");
    }
}
