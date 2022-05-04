package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BikeName {
    WebDriver driver;
    String label;
    String inputXpath = "//table[@class='table']//tr//a[contains(text(), '%s')]";

    public BikeName(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickToNewAddedBike(){
        inputXpath = String.format(inputXpath,label);
        driver.findElement(By.xpath(inputXpath)).click();
    }
}
