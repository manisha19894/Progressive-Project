package progressiveInsuranceTest;

import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ProgressiveInsurancePages.DriverDetailsForm;
import ProgressiveInsurancePages.EnterYourZipCode;
import ProgressiveInsurancePages.FinalDetailsForm;
import ProgressiveInsurancePages.HomePage;
import ProgressiveInsurancePages.NameAndAddress;
import ProgressiveInsurancePages.VehicleDetailsForm;
import seleniumUtility.GenderEnum;
import seleniumUtility.PropertiesExtension;
import seleniumUtility.ScreenShot;

public class ProgressiveInsuranceAutoQuote {
	WebDriver driver;
	ScreenShot screen;
	ExtentReports extent;
	ExtentTest autoQuoteTest;
	PropertiesExtension properties;
	
	
	
	
	@BeforeTest
	public void setUpTest() {
		
		// Create extenthtmlreporter object and create a new extent report html file
				ExtentHtmlReporter sparkle = new ExtentHtmlReporter(
						new File(System.getProperty("user.dir") + "/Reports/ProgressiveInsurance" + ".html"));
				extent = new ExtentReports();
				screen = new ScreenShot();

				sparkle.config().setTheme(Theme.DARK);
				sparkle.config().setDocumentTitle("ProgressiveReport");
				extent.attachReporter(sparkle);
				properties = new PropertiesExtension();
		
		if (properties.isChrome()) {
			System.setProperty("webdriver.chrome.driver", ".//webdriver//chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		} else {

			System.setProperty("webdriver.gecko.driver", ".//webdriver//geckodriver");
			driver = new FirefoxDriver();
		} 
		

	}
	
	

	@Test
	public void startAutoInsurance() {
		autoQuoteTest = extent.createTest("Progressive Auto Quote Test");

		try {
			autoQuoteTest.info("Insurance Homepage");
			HomePage homePage = new HomePage(driver);
			homePage.navigateToHomePage();
			Thread.sleep(3000);
			screen.takeSnapShot(driver, "Auto Insurane Mode");
			autoQuoteTest.log(Status.PASS, "HomePage Test Passes");

		} catch (Exception e) {
			autoQuoteTest.log(Status.FAIL, "HomePage Test Fails");
		}

		try {
			autoQuoteTest.info("EnterYourZipCode Test");
			EnterYourZipCode zipCode = new EnterYourZipCode(driver);
			zipCode.enterZipField("75062");
			Thread.sleep(3000);
			zipCode.clickGetAQuote();
			Thread.sleep(3000);
			screen.takeSnapShot(driver, "Customer Details Empty Form");
			autoQuoteTest.log(Status.PASS, "ZipCode Test Passes");

		} catch (Exception e) {
			autoQuoteTest.log(Status.FAIL, "ZipCode Test Fails");
		}

		try {
			autoQuoteTest.info("NameAndAddress Test");
			NameAndAddress nameAddress = new NameAndAddress(driver);
			nameAddress.enterFirstName("Manisha");
			nameAddress.enterMiddleName("");
			nameAddress.enterLastName("Poudel");
			nameAddress.selectSuffix("JR");
			nameAddress.enterDateOfBirth("07/04/1989");

			Thread.sleep(3000);
			nameAddress.mailingAddress("3733 WEST PIONEER DRIVE");
			Thread.sleep(2000);
			nameAddress.enterApartmentUnit("apart 3307");
			Thread.sleep(2000);

			screen.takeSnapShot(driver, "Customer mailing address filled form");
			nameAddress.clickStartQuoteBtn();
			autoQuoteTest.log(Status.PASS, "NameAndAddress Test Passes");

		} catch (Exception e) {
			autoQuoteTest.log(Status.FAIL, "NameAndAddress Test Fails");
		}

		try {
			autoQuoteTest.info("VehicleDetailsForm Test");
			VehicleDetailsForm vehicle = new VehicleDetailsForm(driver);
			vehicle.vehicleDetails("2019", "Acura", "RDX", "SUV (4CYL 4X2)", "2TNC", "1", "B");
			autoQuoteTest.log(Status.PASS, "VehicleDetailsForm Test Passes");

		} catch (Exception e) {
			autoQuoteTest.log(Status.FAIL, "VehicleDetailsForm Test Fails");
		}

		try {
			autoQuoteTest.info("DriverDetailsForm Test");
			DriverDetailsForm driverDetails = new DriverDetailsForm(driver);

			driverDetails.generalInformation(GenderEnum.FEMALE, "S", "6", "03", "");
			driverDetails.residency("H", "N");
			driverDetails.drivingHistory("O", "V", "3");
			driverDetails.accidentsOrViolations("No", "N0");
			autoQuoteTest.log(Status.PASS, "DriverDetailsForm Test Passes");

		} catch (Exception e) {
			autoQuoteTest.log(Status.FAIL, "DriverDetailsForm Test Fails");
		}

		try {
			autoQuoteTest.info("FinalDetailsForm Test");
			FinalDetailsForm finalForm = new FinalDetailsForm(driver);
			finalForm.autoInsuranceHistory("B", "3");
			finalForm.progressiveInsuranceHistory("No", "No");
			finalForm.additionalInformation("07/05/2021", " manisha19894@gmail.com", "3", "0");
			finalForm.snapshot("Y", "M");
			screen.takeSnapShot(driver, "AutoQuote Final Page");
			autoQuoteTest.log(Status.PASS, "FinalDetailsForm Test Passes");

		} catch (Exception e) {
			autoQuoteTest.log(Status.FAIL, "FinalDetailsForm Test Fails");
		}

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			autoQuoteTest.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screen.takeSnapShot(driver, "Failed")).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			autoQuoteTest.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(screen.takeSnapShot(driver, "Passed")).build());

		} else if (result.getStatus() == ITestResult.SKIP) {
			autoQuoteTest.skip("Test ",
					MediaEntityBuilder.createScreenCaptureFromPath(screen.takeSnapShot(driver, "Skipped")).build());

		}

	}

	@AfterTest
	public void afterTest() {
		driver.close();
		extent.flush();

	}

}
