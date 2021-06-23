package ProgressiveInsurancePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FinalDetailsForm {

	public WebDriver driver;

	public FinalDetailsForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='FinalDetailsEdit_embedded_questions_list_InsuranceToday_Y']")
	WebElement haveAutoInsurance;

	@FindBy(xpath = "//select[@id='FinalDetailsEdit_embedded_questions_list_RecentAutoInsuranceCompanyPeriod']")
	WebElement timePeriod;

	@FindBy(xpath = "//select[@id='FinalDetailsEdit_embedded_questions_list_BodilyInjuryLimits']")
	WebElement injuryLimits;

	@FindBy(xpath = "//input[@id='FinalDetailsEdit_embedded_questions_list_OtherPolicies_N']")
	WebElement nonAutoPolicyWithProgressive;

	@FindBy(xpath = "//input[@id='FinalDetailsEdit_embedded_questions_list_PriorProgressive_N']")
	WebElement previousAutoPolicyWithProgressive;

	@FindBy(xpath = "//input[@name='FinalDetailsEdit_embedded_questions_list_AdvancedShopperPolicyEffectiveDate']")
	WebElement policyStartDate;

	@FindBy(xpath = "//input[@name='FinalDetailsEdit_embedded_questions_list_PrimaryEmailAddress']")
	WebElement policyHolderEmailAddress;

	@FindBy(xpath = "//select[@name='FinalDetailsEdit_embedded_questions_list_TotalResidents']")
	WebElement totalResidents;

	@FindBy(xpath = "//select[@name='FinalDetailsEdit_embedded_questions_list_TotalPipClaimsCount']")
	WebElement numberOfInjury;
	
	@FindBy(xpath = "//forward-navigation//button")
	WebElement clickOnContinue;
	
	@FindBy(xpath = "//input[@id='SnapshotEnrollment40Edit_embedded_questions_list_SnapshotPolicyEnrollment_Y']")
	WebElement yesPlease ;
	
	@FindBy(xpath = "//input[@id='SnapshotEnrollment40Edit_embedded_questions_list_SnapshotEnrollmentExperience_M']")
	WebElement enrollmentOption;
	
	@FindBy(xpath = "//forward-navigation//button")
	WebElement clickToContinue;
	
	//div[text()='We found these vehicles at your address']
	
	public void autoInsuranceHistory(String autoInsuredTime, String bodyInjuryLimits) throws InterruptedException {
		
		Thread.sleep(2500);
		haveAutoInsurance.click();
		
		Thread.sleep(2000);
		Select insuranceTimePeriod = new Select(timePeriod);
		insuranceTimePeriod.selectByValue(autoInsuredTime);

		Thread.sleep(2000);
		Select insuranceInjuryLimits = new Select(injuryLimits);
		insuranceInjuryLimits.selectByValue(bodyInjuryLimits);
	}

	public void progressiveInsuranceHistory(String nonAutoPolicy, String previousAutoPolicy)
			throws InterruptedException {
		
		Thread.sleep(2000);
		nonAutoPolicyWithProgressive.sendKeys(nonAutoPolicy);
		nonAutoPolicyWithProgressive.click();

		Thread.sleep(2000);
		previousAutoPolicyWithProgressive.sendKeys(previousAutoPolicy);
		previousAutoPolicyWithProgressive.click();
		
		

	}
	
	public void additionalInformation(String startDate,String emailAddress,String familySize, String injuryClaims) throws InterruptedException {
		
		Thread.sleep(2000);
		policyStartDate.sendKeys(startDate);
		
		Thread.sleep(3000);
		policyHolderEmailAddress.click();
		policyHolderEmailAddress.sendKeys(emailAddress);
		
		//Thread.sleep(2000);
		sizeOfFamily(familySize);
		
		Thread.sleep(2000);
		numberOfInjuryClaims(injuryClaims);
		
	}
	public void sizeOfFamily(String familySize) {
		Select policyHolderFamilySize = new Select(totalResidents);
		policyHolderFamilySize.selectByValue(familySize);
		
	}
	
	public void numberOfInjuryClaims(String injuryClaims) {
		Select totalInjuryClaims = new Select(numberOfInjury);
		totalInjuryClaims.selectByValue(injuryClaims);
		
	}
	
	
	public void snapshot(String enrollSnap,String enrollOption) throws InterruptedException {
		
		Thread.sleep(2500);
		chooseToContinue();
		
		Thread.sleep(2000);
		snapshotEnrollment(enrollSnap);
		
		Thread.sleep(2000);
		snapshotEnrollmentOption(enrollOption);
		
		Thread.sleep(2500);
		chooseToContinue();
		
		Thread.sleep(2500);
		continueToNextPage();
		
		Thread.sleep(9000);
	}
	public void snapshotEnrollment(String enrollSnap) {
		
		yesPlease.sendKeys(enrollSnap);
		yesPlease.click();
			
	}
	
	public void snapshotEnrollmentOption(String enrollOption) {
		enrollmentOption.sendKeys(enrollOption);
		enrollmentOption.click();
	}
	
	
	public void chooseToContinue() {
		
		clickOnContinue.click();
		
	}
	
	public void continueToNextPage() {
		clickToContinue.click();
	}
	
	

}
