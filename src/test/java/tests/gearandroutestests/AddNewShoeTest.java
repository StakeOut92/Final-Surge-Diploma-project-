package tests.gearandroutestests;


import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gearandroutespages.ShoesPage;
import pages.loginpages.LoginPage;
import testdata.GetNewShoesAccountModel;

@Log4j
public class AddNewShoeTest extends BaseTest {

    LoginPage loginPage;
    ShoesPage shoesPage;

    @Test
    @Description("Checking that new shoe was added and check that it successful")
    public void addNewShoeTest() {
        log.info("addNewShoeTest started ");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin();
        shoesPage = new ShoesPage(driver);
        shoesPage.saveNewShoesForm(GetNewShoesAccountModel.getShoeFields());
        Assert.assertEquals(shoesPage.getShoesDetails(),GetNewShoesAccountModel.getShoeFields());
    }
}
