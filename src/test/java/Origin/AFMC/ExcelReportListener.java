package Origin.AFMC;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReportListener implements ITestListener {

    private Workbook workbook;
    private Sheet sheet;
    private int rowNum;

    @Override
    public void onStart(ITestContext context) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Test Results");
        rowNum = 0;
        createHeaderRow();
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            // Write the workbook content to an Excel file
            FileOutputStream outputStream = new FileOutputStream("TestNG_Excel_Report.xlsx");
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Retrieve actual and expected values from attributes
        String actualProduct = result.getAttribute("actualProduct") != null ? result.getAttribute("actualProduct").toString() : "N/A";
        String expectedProduct = result.getAttribute("expectedProduct") != null ? result.getAttribute("expectedProduct").toString() : "N/A";
        writeResultToExcel(result, "Pass", null, actualProduct, expectedProduct);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Retrieve assertion result, actual, and expected values from attributes
        String assertionResult = result.getThrowable() != null ? result.getThrowable().getMessage() : "N/A";
        String actualProduct = result.getAttribute("actualProduct") != null ? result.getAttribute("actualProduct").toString() : "N/A";
        String expectedProduct = result.getAttribute("expectedProduct") != null ? result.getAttribute("expectedProduct").toString() : "N/A";
        writeResultToExcel(result, "Fail", assertionResult, actualProduct, expectedProduct);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Write skipped test results
        writeResultToExcel(result, "Skip", null, null, null);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }

    private void createHeaderRow() {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("Test Method");
        row.createCell(1).setCellValue("Status");
        row.createCell(2).setCellValue("Assertion Result");
        row.createCell(3).setCellValue("Actual Product");
        row.createCell(4).setCellValue("Expected Product");
    }

    private void writeResultToExcel(ITestResult result, String status, String assertionResult, String actualProduct, String expectedProduct) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(result.getMethod().getMethodName());
        row.createCell(1).setCellValue(status);
        row.createCell(2).setCellValue(assertionResult != null ? assertionResult : "N/A");
        row.createCell(3).setCellValue(actualProduct != null ? actualProduct : "N/A");
        row.createCell(4).setCellValue(expectedProduct != null ? expectedProduct : "N/A");
    }
}
