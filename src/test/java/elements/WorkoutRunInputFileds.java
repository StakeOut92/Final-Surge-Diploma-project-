package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutRunInputFileds {
    WebDriver driver;
    String label;
    String inputId = "%s";

    public WorkoutRunInputFileds(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void inputText(String text) {
        inputId = String.format(inputId, label);
        driver.findElement(By.id(inputId)).sendKeys(text);
    }

}
