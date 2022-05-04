package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutRunName {
    WebDriver driver;
    String label;
    String inputXpath = "//div[@class='fc-event-activity-title' and contains(text(), '%s')]";

    public WorkoutRunName(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickToNewAddedWorkoutRun(){
        inputXpath = String.format(inputXpath,label);
        driver.findElement(By.xpath(inputXpath)).click();
    }

    public boolean workoutRunDeleteState(){
        inputXpath = String.format(inputXpath,label);
        boolean deleteState = driver.findElement(By.xpath(inputXpath)).isEnabled();
        return deleteState;
    }
}
