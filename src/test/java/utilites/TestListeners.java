package utilites;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Retry retry = new Retry();
        retry.retry(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Retry retry = new Retry();
        retry.retry(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
