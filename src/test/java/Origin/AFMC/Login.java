package Origin.AFMC;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//public class Login extends Base {
//    
//	@Test(dataProvider = "logindata", dataProviderClass = Exceldatasupplier.class)
//	public void launch(String code, String product, String Pack, String BatchNo, String MfgDate, String ExpDate) throws IOException {
//	    browserconfig();
//	    Base.init();
//	    String s1 = code;
//	    
//	    String u = prop.getProperty("url");
//	    
//	    launchbrowser(u + s1);
//	    maxiwindow();
//	    
//	    
//	    WebElement  a = driver.findElement(By.xpath("//h1[@class='prod-heading']"));
//	    String text = a.getText();
//	    System.out.println(text);
//	    String a2 ="UID : "+s1;
//	    System.out.println(a2);
//	   Assert.assertTrue(a2.contains(text),"code match");
//	    
//	    // Now the driver object should be initialized and usable
//	    WebElement productElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")); 
//	    String actualProduct = productElement.getText();
//	    System.out.println("Actual Product: " + actualProduct);
//	    System.out.println("Expected Product: " + product);
//
//	    // Convert both actual and expected product strings to uppercase and lowercase
//	    String actualProductUpperCase = actualProduct.toUpperCase();
//	    String actualProductLowerCase = actualProduct.toLowerCase();
//	    String expectedProductUpperCase = product.toUpperCase();
//	    String expectedProductLowerCase = product.toLowerCase();
//
//	    // Assert that the actual product contains the expected product, ignoring case
//	    Assert.assertTrue(actualProductUpperCase.contains(expectedProductUpperCase) ||
//	                      actualProductLowerCase.contains(expectedProductLowerCase),
//	                      "Product mismatch");
//
//	    
//	    WebElement packElement = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
//	    String actualPack = packElement.getText();
//	    System.out.println("Actual Pack: " + actualPack);
//	    System.out.println("Expected Pack: " + Pack);
//
//	    // Convert both actual and expected pack strings to uppercase and lowercase
//	    String actualPackUpperCase = actualPack.toUpperCase();
//	    String actualPackLowerCase = actualPack.toLowerCase();
//	    String expectedPackUpperCase = Pack.toUpperCase();
//	    String expectedPackLowerCase = Pack.toLowerCase();
//
//	    // Assert that the actual pack contains the expected pack, ignoring case
//	    Assert.assertTrue(actualPackUpperCase.contains(expectedPackUpperCase) ||
//	                      actualPackLowerCase.contains(expectedPackLowerCase),
//	                      "Pack mismatch");
//
//	    
//	    WebElement batchElement = driver.findElement(By.xpath("//tbody/tr[3]/td[2]"));
//	    String actualBatch = batchElement.getText();
//	    System.out.println("Actual Batch No: " + actualBatch);
//	    System.out.println("Expected Batch No: " + BatchNo);
//	    Assert.assertTrue(actualBatch.contains(BatchNo), "Batch No mismatch");
//	    
//	    WebElement mfgDateElement = driver.findElement(By.xpath("//tbody/tr[4]/td[2]"));
//	    String actualMfgDate = mfgDateElement.getText();
//	    System.out.println("Actual Manufacturing Date: " + actualMfgDate);
//	    System.out.println("Expected Manufacturing Date: " + MfgDate);
//	    Assert.assertTrue(actualMfgDate.contains(MfgDate), "Manufacturing Date mismatch");
//	    
//	    WebElement expDateElement = driver.findElement(By.xpath("//tbody/tr[5]/td[2]"));
//	    String actualExpDate = expDateElement.getText();
//	    System.out.println("Actual Expiry Date: " + actualExpDate);
//	    System.out.println("Expected Expiry Date: " + ExpDate);
//	    Assert.assertTrue(actualExpDate.contains(ExpDate), "Expiry Date mismatch"); 
//	   
//    		driver.quit();
//    		
//    		
//    		
//    } 
public class Login extends Base {
	@Test(dataProvider = "logindata", dataProviderClass = Exceldatasupplier.class)
	public void launch(String code, String product, String Pack, String BatchNo, String MfgDate, String ExpDate,
			String mfgLocation) throws IOException {
		browserconfig();
		Base.init();
		String s1 = code;

		String u = prop.getProperty("url");

		launchbrowser(u + s1);
		maxiwindow();

		WebElement a = driver.findElement(By.xpath("//h1[@class='prod-heading']"));
		String text = a.getText();
		System.out.println(text);
		String a2 = "UID : " + s1;
		System.out.println(a2);
		Assert.assertTrue(a2.contains(text), "code match");

		// Now the driver object should be initialized and usable
		WebElement productElement = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
		String actualProduct = productElement.getText();
		System.out.println("Actual Product: " + actualProduct);
		System.out.println("Expected Product: " + product);

		// Convert both actual and expected product strings to uppercase and lowercase
		String actualProductUpperCase = actualProduct.toUpperCase();
		String actualProductLowerCase = actualProduct.toLowerCase();
		String expectedProductUpperCase = product.toUpperCase();
		String expectedProductLowerCase = product.toLowerCase();

		// Assert that the actual product contains the expected product, ignoring case
		Assert.assertTrue(actualProductUpperCase.contains(expectedProductUpperCase)
				|| actualProductLowerCase.contains(expectedProductLowerCase), "Product mismatch");

		WebElement packElement = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
		String actualPack = packElement.getText();
		System.out.println("Actual Pack: " + actualPack);
		System.out.println("Expected Pack: " + Pack);

		// Convert both actual and expected pack strings to uppercase and lowercase
		String actualPackUpperCase = actualPack.toUpperCase();
		String actualPackLowerCase = actualPack.toLowerCase();
		String expectedPackUpperCase = Pack.toUpperCase();
		String expectedPackLowerCase = Pack.toLowerCase();

		// Assert that the actual pack contains the expected pack, ignoring case
		Assert.assertTrue(actualPackUpperCase.contains(expectedPackUpperCase)
				|| actualPackLowerCase.contains(expectedPackLowerCase), "Pack mismatch");

		WebElement batchElement = driver.findElement(By.xpath("//tbody/tr[3]/td[2]"));
		String actualBatch = batchElement.getText();
		System.out.println("Actual Batch No: " + actualBatch);
		System.out.println("Expected Batch No: " + BatchNo);
		Assert.assertTrue(actualBatch.contains(BatchNo), "Batch No mismatch");
		
		
		WebElement btchElement = driver.findElement(By.xpath("//tbody/tr[3]/td[2]"));
		String atualBatch = btchElement.getText();
		System.out.println("Actual Batch No: " + atualBatch);
		System.out.println("Expected Batch No: " + BatchNo);
		Assert.assertTrue(actualBatch.contains(BatchNo), "Batch No mismatch");

		String expectedManufacturingLocation = ""; // Initialize a variable to store the expected manufacturing location

		// Determine the expected manufacturing location based on the batch code abbreviation
		if (BatchNo.contains("VC")) {
		    expectedManufacturingLocation = "Vantech Chemicals Limited";
		} else if (BatchNo.contains("PS")) {
		    expectedManufacturingLocation = "Prasad Seeds Pvt Ltd";
		} else if (BatchNo.contains("IB")) {
		    expectedManufacturingLocation = "Saraswati Agro Chemicals India Pvt Ltd";
		} else if (BatchNo.contains("BT")) {
		    expectedManufacturingLocation = "Baroda Agro Chemicals Limited";
		} else if (BatchNo.matches("\\d{6}")) {
		    // If it's a 6-digit number, consider it's from Savli unless it's a batch code from FMC India Pvt Ltd
		    if (atualBatch.equals("FMC India Pvt Ltd") || atualBatch.equals("FMC India Pvt Ltd Savli")) {
		        expectedManufacturingLocation = atualBatch;
		    } else {
		        expectedManufacturingLocation = "FMC India Pvt Ltd Savli";
		    }
		}

		System.out.println("Expected Manufacturing Location: " + expectedManufacturingLocation);
		System.out.println("actual Manufacturing Location: " + mfgLocation);

		// Assertion for batch number
		Assert.assertTrue(actualBatch.contains(BatchNo), "Batch No mismatch");

		// Assertion for manufacturing location
		if (BatchNo.matches("\\d{6}")) {
		    Assert.assertTrue(mfgLocation.equals("FMC India Pvt Ltd") || mfgLocation.equals("FMC India Pvt Ltd Savli"), "Manufacturing location mismatch");
		} else {
		    Assert.assertTrue(mfgLocation.equals(expectedManufacturingLocation), "Manufacturing location mismatch");
		}

		// Assertion for manufacturing location
		//Assert.assertTrue(mfgLocation.equals("FMC India Pvt Ltd") || mfgLocation.equals("FMC India Pvt Ltd Savli"), "Manufacturing location mismatch");


		WebElement mfgDateElement = driver.findElement(By.xpath("//tbody/tr[4]/td[2]"));
		String actualMfgDate = mfgDateElement.getText();
		System.out.println("Actual Manufacturing Date: " + actualMfgDate);
		System.out.println("Expected Manufacturing Date: " + MfgDate);
		Assert.assertTrue(actualMfgDate.contains(MfgDate), "Manufacturing Date mismatch");

		WebElement expDateElement = driver.findElement(By.xpath("//tbody/tr[5]/td[2]"));
		String actualExpDate = expDateElement.getText();
		System.out.println("Actual Expiry Date: " + actualExpDate);
		System.out.println("Expected Expiry Date: " + ExpDate);
		Assert.assertTrue(actualExpDate.contains(ExpDate), "Expiry Date mismatch");

		driver.quit();
	}
//	@AfterMethod
//	public void captureScreenshot(ITestResult result) {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			try {
//				// Capture screenshot
//				File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//				// Get the current URL
//				String currentURL = driver.getCurrentUrl();
//				// Define a unique file name for the screenshot including the URL
//				String screenshotName = result.getName() + "_" + currentURL.replaceAll("[^a-zA-Z0-9.-]", "_") + "_"
//						+ System.currentTimeMillis() + ".png";
//				// Save the screenshot
//				Files.copy(screenshotFile.toPath(), Paths
//						.get("C:\\Users\\Acviss\\git\\repository8\\2AFMC\\src\\test\\java\\screen" + screenshotName));
//				System.out.println("Screenshot captured: " + screenshotName);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	driver.quit();
//	}
@AfterMethod
public void close()
{
	driver.quit(); 
	}
}
//	@AfterMethod
//    public void captureScreenshot(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            try {
//                // Capture screenshot
//                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                // Define a unique file name for the screenshot
//                String screenshotName = result.getName() + "_" + System.currentTimeMillis() + ".png";
//                // Save the screenshot
//                Files.copy(screenshotFile.toPath(), Paths.get("C:\\Users\\Acviss\\git\\repository8\\2AFMC\\src\\test\\java\\screen" + screenshotName));
//                System.out.println("Screenshot captured: " + screenshotName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        driver.quit(); 
//    }
//
//}

//	 @AfterMethod
//    public void captureScreenshotOnFailure(ITestResult result) {
//	        if (result.getStatus() == ITestResult.FAILURE) {
//	            System.out.println("Test case failed! Capturing screenshot...");
//	            TakesScreenshot ts = (TakesScreenshot) driver;
//	            File screenshot = ts.getScreenshotAs(OutputType.FILE);
//	            File destination = new File("C:\\Users\\Acviss\\git\\repository8\\2AFMC\\src\\test\\java\\screenpng");
//	            try {
//	                FileUtils.copyFile(screenshot, destination);
//               System.out.println("Screenshot captured: " + destination.getAbsolutePath());
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        driver.quit();  
//	    }
//}
