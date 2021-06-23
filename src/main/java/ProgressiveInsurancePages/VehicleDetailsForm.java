package ProgressiveInsurancePages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VehicleDetailsForm {
	public WebDriver driver;

	// Constructor
	public VehicleDetailsForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating all the Elements that are going to be used 

	@FindBy(xpath = "//list-input[@name='VehiclesNew_embedded_questions_list_Year']//li")
	List<WebElement> yearList;

	@FindBy(xpath = "//list-input[@name='VehiclesNew_embedded_questions_list_Make']//li")
	List<WebElement> vehicleMakeList;

	@FindBy(xpath = "//list-input[@id='VehiclesNew_embedded_questions_list_Model']//li")
	List<WebElement> vehicleModelList;

	@FindBy(xpath = "//select[@name='VehiclesNew_embedded_questions_list_BodyStyle']")
	WebElement bodyTypeList;

	@FindBy(xpath = "//select[@name='VehiclesNew_embedded_questions_list_VehicleUse']")
	WebElement primaryUseList;

	@FindBy(xpath = "//select[@name='VehiclesNew_embedded_questions_list_OwnOrLease']")
	WebElement ownOrLeaseList;

	@FindBy(xpath = "//select[@name='VehiclesNew_embedded_questions_list_LengthOfOwnership']")
	WebElement ownPeriodList;

	@FindBy(xpath = "//button[text()='Done']")
	WebElement clickOnDone;

	@FindBy(xpath = "//forward-navigation//button")
	WebElement clickOnContinue;

	
	
	
	
	public void vehicleDetails(String vehicleYear, String vehicleName, String modelNumber, String bodyType,
			String primaryUse, String ownORlease, String OwnPeriod) throws InterruptedException {

		Thread.sleep(2000);
		enterVehicleYear(vehicleYear);

		Thread.sleep(2000);
		entervehicleName(vehicleName);

		Thread.sleep(2000);
		vehicleModelNumber(modelNumber);

		Thread.sleep(2000);
		vehicleBodyType(bodyType);

		Thread.sleep(2000);
		vehiclePrimaryUse(primaryUse);

		Thread.sleep(2000);
		vehicleOwnOrLease(ownORlease);

		Thread.sleep(2000);
		vehicleOwnPeriod(OwnPeriod);

		Thread.sleep(2000);
		clickDoneButton();

		Thread.sleep(2000);
		continueToNextPage();

	}

	public void enterVehicleYear(String vehicleYear) {
		String yearToChoose = vehicleYear;
		for (int i = 0; i < yearList.size(); i++) {
			if (yearList.get(i).getText().equals(yearToChoose)) {
				yearList.get(i).click();
				break;

			}
		}

	}

	public void entervehicleName(String vehicleName) {
		String makeToChoose = vehicleName;
		for (int i = 0; i < vehicleMakeList.size(); i++) {
			if (vehicleMakeList.get(i).getText().equals(makeToChoose)) {
				vehicleMakeList.get(i).click();
				break;

			}
		}

	}

	public void vehicleModelNumber(String modelNumber) {
		String modelToChoose = modelNumber;
		for (int i = 0; i < vehicleModelList.size(); i++) {
			if (vehicleModelList.get(i).getText().equals(modelToChoose)) {
				vehicleModelList.get(i).click();
				break;

			}
		}

	}

	
	
	public void vehicleBodyType(String bodyType) {
		Select selectBodyType = new Select(bodyTypeList);
		selectBodyType.selectByVisibleText(bodyType);
	}

	
	
	public void vehiclePrimaryUse(String primaryUse) {
		Select selectPrimaryUse = new Select(primaryUseList);
		selectPrimaryUse.selectByValue(primaryUse);
	}
	
	

	public void vehicleOwnOrLease(String ownOrLease) {
		Select selectOwnOrLease = new Select(ownOrLeaseList);
		selectOwnOrLease.selectByValue(ownOrLease);
	}

	
	
	public void vehicleOwnPeriod(String ownPeriod) {
		Select selectOwnPeriod = new Select(ownPeriodList);
		selectOwnPeriod.selectByValue(ownPeriod);
	}
	
	

	public void clickDoneButton() {
		clickOnDone.click();
	}
	
	

	public void continueToNextPage() {
		clickOnContinue.click();
	}
}
