package progressiveInsuranceTest;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ProgressiveInsurancePages.VehicleDetailsForm;
import ProgressiveInsurancePages.EnterYourZipCode;
import ProgressiveInsurancePages.FinalDetailsForm;
import ProgressiveInsurancePages.DriverDetailsForm;
import ProgressiveInsurancePages.HomePage;
import ProgressiveInsurancePages.NameAndAddress;
import seleniumUtility.GenderEnum;
import seleniumUtility.ScreenShot;

public class GetAutoInsuranceQuote {

	WebDriver driver;
	ScreenShot screen;

	@BeforeTest
	public void setUpTest() {

		
		
		// Setting the system Path
		System.setProperty("webdriver.chrome.driver", ".//webdriver//chromedriver");

		// Creating an object of webdriver and morphing it to chrome
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void startAutoInsurance() {

		try {
			HomePage homePage = new HomePage(driver);
			screen = new ScreenShot();

			homePage.navigateToHomePage();
			Thread.sleep(3000);

			// Screenshot
			screen.takeSnapShot(driver, "Auto Insurane Mode");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void startAutoQuote() {
		try {
			EnterYourZipCode zipCode = new EnterYourZipCode(driver);
			NameAndAddress nameAddress = new NameAndAddress(driver);
			VehicleDetailsForm vehicle = new VehicleDetailsForm(driver);
			DriverDetailsForm driverDetails = new DriverDetailsForm(driver);
			FinalDetailsForm finalForm = new FinalDetailsForm(driver);
			ScreenShot screen = new ScreenShot();

			// Test
			// ZipField
			zipCode.enterZipField("75061");
			Thread.sleep(3000);

			// Get A Quote
			zipCode.clickGetAQuote();
			Thread.sleep(3000);

			// Screenshot
			screen.takeSnapShot(driver, "Customer Details Empty Form");

			nameAddress.enterFirstName("Manisha");
			nameAddress.enterMiddleName("");
			nameAddress.enterLastName("Poudel");
			nameAddress.selectSuffix("JR");
			nameAddress.enterDateOfBirth("07/04/1989");

			Thread.sleep(3000);
			nameAddress.mailingAddress("3707 west pioneer");
			Thread.sleep(2000);
			nameAddress.enterApartmentUnit("apart 401");
			Thread.sleep(2000);

			screen.takeSnapShot(driver, "Customer mailing address filled form");
			nameAddress.clickStartQuoteBtn();

			vehicle.vehicleDetails("2019", "Acura", "RDX", "SUV (4CYL 4X2)", "2TNC", "1", "B");

			driverDetails.generalInformation(GenderEnum.FEMALE, "S", "6", "03", "123456789");
			driverDetails.residency("H", "N");
			driverDetails.drivingHistory("O", "V", "3");
			driverDetails.accidentsOrViolations("No", "N0");

			finalForm.autoInsuranceHistory("B", "3");
			finalForm.progressiveInsuranceHistory("No", "No");
			finalForm.additionalInformation("06/05/2021", " manisha19894@gmail.com", "2", "0");
			finalForm.snapshot("Y", "M");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() {

		// driver.close();
		// driver.quit();
	}

}
