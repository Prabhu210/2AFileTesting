package Origin.AFMC;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomTestNGListener extends TestListenerAdapter {
    private Map<String, Map<String, String>> testResults = new HashMap<>();

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        testResults.put(methodName, new HashMap<>());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        String methodName = tr.getMethod().getMethodName();
        updateTestStatus(methodName, "Pass");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        String methodName = tr.getMethod().getMethodName();
        updateTestStatus(methodName, "Fail");
    }

    private void updateTestStatus(String methodName, String status) {
        Map<String, String> testDetails = testResults.get(methodName);
        if (testDetails != null) {
            testDetails.put("Status", status);
        }
    }

    public void updateTestDetails(String methodName, String key, String value) {
        Map<String, String> testDetails = testResults.get(methodName);
        if (testDetails != null) {
            testDetails.put(key, value);
        }
    }

    @Override
    public void onFinish(ITestContext testContext) {
        generateReport();
    }

    private void generateReport() {
        // Create report content
        StringBuilder reportContent = new StringBuilder();
        reportContent.append("Test Method,Status,Expected Product,Actual Product,Expected Pack,Actual Pack,Expected Batch No,Actual Batch No,Expected Mfg Date,Actual Mfg Date,Expected Exp Date,Actual Exp Date\n");

        // Populate report content with test results
        for (Map.Entry<String, Map<String, String>> entry : testResults.entrySet()) {
            String methodName = entry.getKey();
            Map<String, String> testDetails = entry.getValue();
            String status = testDetails.get("Status");

            // Fetch test data
            String expectedProduct = testDetails.getOrDefault("Expected Product", "");
            String actualProduct = testDetails.getOrDefault("Actual Product", "");
            String expectedPack = testDetails.getOrDefault("Expected Pack", "");
            String actualPack = testDetails.getOrDefault("Actual Pack", "");
            String expectedBatchNo = testDetails.getOrDefault("Expected Batch No", "");
            String actualBatchNo = testDetails.getOrDefault("Actual Batch No", "");
            String expectedMfgDate = testDetails.getOrDefault("Expected Mfg Date", "");
            String actualMfgDate = testDetails.getOrDefault("Actual Mfg Date", "");
            String expectedExpDate = testDetails.getOrDefault("Expected Exp Date", "");
            String actualExpDate = testDetails.getOrDefault("Actual Exp Date", "");

            // Append test data to report content
            reportContent.append(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                    methodName, status, expectedProduct, actualProduct, expectedPack, actualPack,
                    expectedBatchNo, actualBatchNo, expectedMfgDate, actualMfgDate, expectedExpDate, actualExpDate));
        }

        // Write report content to file
        try (FileOutputStream fileOut = new FileOutputStream("testng1_report.csv")) {
            fileOut.write(reportContent.toString().getBytes());
            System.out.println("TestNG report created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
