package ProgressiveInsurancePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import seleniumUtility.GenderEnum;

public class DriverDetailsForm {

	public WebDriver driver;

	// Constructor
	public DriverDetailsForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating all the Elements that are going to be used
	@FindBy(xpath = "//input[@id='DriversAddPniDetails_embedded_questions_list_Gender_F']")
	WebElement genderFemale;

	@FindBy(xpath = "//input[@id='DriversAddPniDetails_embedded_questions_list_Gender_M']")
	WebElement genderMale;

	@FindBy(xpath = "//select[@id='DriversAddPniDetails_embedded_questions_list_MaritalStatus']")
	WebElement maritalStatus;

	@FindBy(xpath = "//select[@id='DriversAddPniDetails_embedded_questions_list_HighestLevelOfEducation']")
	WebElement levelOfEducation;

	@FindBy(xpath = "//select[@id='DriversAddPniDetails_embedded_questions_list_EmploymentStatus']")
	WebElement employmentStatus;

	@FindBy(xpath = "//input[@id='DriversAddPniDetails_embedded_questions_list_SocialSecurityNumber']")
	WebElement fillSSN;

	@FindBy(xpath = "//select[@id='DriversAddPniDetails_embedded_questions_list_PrimaryResidence']")
	WebElement primaryResidence;

	@FindBy(xpath = "//select[@id='DriversAddPniDetails_embedded_questions_list_HasPriorAddress']")
	WebElement lastMoved;

	@FindBy(xpath = "//select[@id='DriversAddPniDetails_embedded_questions_list_LicenseType']")
	WebElement licenseType;

	@FindBy(xpath = "//select[@id='DriversAddPniDetails_embedded_questions_list_LicenseStatus']")
	WebElement licenseStatus;

	@FindBy(xpath = "//select[@id='DriversAddPniDetails_embedded_questions_list_DriverYearsLicensed']")
	WebElement licenseYear;

	@FindBy(xpath = "//input[@id='DriversAddPniDetails_embedded_questions_list_HasAccidentsOrClaims_N']")
	WebElement accidentClaimOrNot;
	
	@FindBy(xpath = "//forward-navigation//button")
	WebElement continueToFinalDetailPage;
	
	@FindBy(xpath = "//input[@id='DriversAddPniDetails_embedded_questions_list_HasTicketsOrViolations_N']")
	WebElement ticketsOrViolation;

	@FindBy(xpath = "//forward-navigation//button")
	WebElement clickToContinue;
	
	//@FindBy(xpath = "//button[text()='Continue']")
	//WebElement continueToNextPage;
	
	

	
	
	public void generalInformation(GenderEnum genderType,String selectMaritalStatus,String educationLevel,String EmployStatus,String SSN) throws InterruptedException {
		
		Thread.sleep(3000);
		selectGender(genderType);
		
		Thread.sleep(3000);
		enterMaritalStatus(selectMaritalStatus);
		
		Thread.sleep(3000);
		enterLevelOfEducation(educationLevel);
		
		Thread.sleep(3000);
		enterEmploymentStatus(EmployStatus);
		
		Thread.sleep(3000);
		enterSSN(SSN);
	}
	
	public void residency(String driverPrimaryResidence,String movedStatus) throws InterruptedException {
		
		Thread.sleep(3000);
		enterPrimaryResidence(driverPrimaryResidence);
		
		Thread.sleep(2000);
		enterLastMoved(movedStatus);
		
		
	}
	
	public void drivingHistory(String driverLicenseType,String driverLicenseStatus,String driverLicenseYear) throws InterruptedException{
	
		Thread.sleep(2000);
		enterLicenseType(driverLicenseType);
		
		Thread.sleep(2000);
		enterLicenseStatus(driverLicenseStatus);
		
		Thread.sleep(2000);
		enterLicenseYear(driverLicenseYear);
	}
	
	public void accidentsOrViolations(String accidentClaim,String violationTickets) throws InterruptedException{
		
		Thread.sleep(2000);
		enterAccidentClaimsOrNot(accidentClaim);
		
		Thread.sleep(2000);
		enterTicketsOrViolation(violationTickets);
		
		Thread.sleep(2500);
		clickToNextPage();
		
		Thread.sleep(2500);
		continueToFinalPage();
		
	}

	public void selectGender(GenderEnum genderType) {
		if (genderType == GenderEnum.FEMALE) {

			// check female radio button

			genderFemale.click();

		} else {

			// check male radio button
			genderMale.click();

		}

	}

	public void enterMaritalStatus(String selectMaritalStatus) {
		Select chooseMaritalStatus = new Select(maritalStatus);
		chooseMaritalStatus.selectByValue(selectMaritalStatus);

	}

	public void enterLevelOfEducation(String educationLevel) {
		Select selectLevelOfEducation = new Select(levelOfEducation);
		selectLevelOfEducation.selectByValue(educationLevel);
	}

	public void enterEmploymentStatus(String EmployStatus) {
		Select selectEmploymentStatus = new Select(employmentStatus);
		selectEmploymentStatus.selectByValue(EmployStatus);
	}

	public void enterSSN(String SSN) {
		fillSSN.click();

	}

	public void enterPrimaryResidence(String driverPrimaryResidence) {
		Select selectPrimaryResidence = new Select(primaryResidence);
		selectPrimaryResidence.selectByValue(driverPrimaryResidence);
	}

	public void enterLastMoved(String movedStatus) {
		Select selectLastMoved = new Select(lastMoved);
		selectLastMoved.selectByValue(movedStatus);
	}

	
	public void enterLicenseType(String driverLicenseType) {
		Select selectLicenseType = new Select(licenseType);
		selectLicenseType.selectByValue(driverLicenseType);
	}
	
	public void enterLicenseStatus(String driverLicenseStatus) {
		Select selectLicenseStatus = new Select(licenseStatus);
		selectLicenseStatus.selectByValue(driverLicenseStatus);
	}
	
	public void enterLicenseYear(String driverLicenseYear) {
		Select selectLicenseYear = new Select(licenseYear);
		selectLicenseYear.selectByValue(driverLicenseYear);
	}
	
	public void enterAccidentClaimsOrNot(String accidentClaim) {
		accidentClaimOrNot.sendKeys(accidentClaim);
		accidentClaimOrNot.click();
		
	}
	
	public void enterTicketsOrViolation(String violationTickets) {
		ticketsOrViolation.sendKeys(violationTickets);
		ticketsOrViolation.click();
	}
	
	public void clickToNextPage() {
		clickToContinue.click();
		
	}
	
	public void continueToFinalPage() {

		continueToFinalDetailPage.click();

	}
	
	
}
