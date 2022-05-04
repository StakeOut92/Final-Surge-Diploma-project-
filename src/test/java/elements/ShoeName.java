package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoeName {
    WebDriver driver;
    String label;
    String inputXpath = "//table[@class='table']//tr//a[contains(text(), '%s')]";

    public ShoeName(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickToNewAddedShoe(){
        inputXpath = String.format(inputXpath,label);
        driver.findElement(By.xpath(inputXpath)).click();
    }
}
