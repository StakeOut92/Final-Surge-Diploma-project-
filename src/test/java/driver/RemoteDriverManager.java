package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager{

    @Override
    public void createDriver() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("platformName", "Windows 11");
        browserOptions.setCapability("browserVersion", "98");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver( new URL("https://oauth-inozemtcew-d5002:a7a7ede5-5593-42ed-ae24-6fbf7103d9c3@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),browserOptions );
    }
}
