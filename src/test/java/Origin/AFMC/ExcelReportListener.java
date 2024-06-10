package Origin.AFMC;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExcelReportListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
        // Logic to initialize or start reporting
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
        // Logic to finish reporting and generate Excel report
        generateExcelReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        // Logic to log test start event
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        // Logic to log test success event
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        // Logic to log test failure event
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        // Logic to log test skip event
    }

    // Method to generate Excel report
    private void generateExcelReport() {
        // Logic to generate Excel report
        System.out.println("Generating Excel report...");
        // Implement your logic to create an Excel report here
    }
}
