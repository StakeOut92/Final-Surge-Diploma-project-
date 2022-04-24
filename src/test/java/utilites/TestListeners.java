//package utilites;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import tests.BaseTest;
//
//public class TestListeners implements ITestListener {
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        Object currentClass = iTestResult.getInstance();
//        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
//        AllureService allureService = new AllureService();
//        allureService.takeScreenshot(webDriver);
//    }
//}
