package ProgressiveInsurancePages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NameAndAddress {
	
 public WebDriver driver;
 
 //Constructor
 public NameAndAddress(WebDriver driver) {
	 this.driver= driver;
	 PageFactory.initElements(driver,this);
 }
 
@FindBy(xpath = "//input[@id='NameAndAddressEdit_embedded_questions_list_FirstName']")
    WebElement selectFirstName;

@FindBy(xpath = "//input[@id='NameAndAddressEdit_embedded_questions_list_MiddleInitial']")
	WebElement selectMiddleName;

@FindBy(xpath = "//input[@id='NameAndAddressEdit_embedded_questions_list_LastName']")
    WebElement selectLastName;

@FindBy(xpath = "//input[@id='NameAndAddressEdit_embedded_questions_list_DateOfBirth']")
    WebElement selectDateOfBirth;

@FindBy(xpath = "//select[@id='NameAndAddressEdit_embedded_questions_list_Suffix']")
	WebElement suffix;

@FindBy(xpath = "//input[@id='NameAndAddressEdit_embedded_questions_list_MailingAddress']")
	WebElement streetNumberAndName;

@FindBy(xpath = "//input[@id='NameAndAddressEdit_embedded_questions_list_ApartmentUnit']")
	WebElement apartmentUnit;


@FindBy(xpath = "//button[text()='Okay, start my quote.']")
	WebElement startQuoteBtn;

@FindBy(xpath = "//input[@name='NameAndAddressEdit_embedded_questions_list_City']")
	WebElement city;
@FindBy(xpath = "//input[@name='NameAndAddressEdit_embedded_questions_list_ZipCode']")
	WebElement zipCode;




public void enterFirstName(String firstName) {
	selectFirstName.click();
	selectFirstName.sendKeys(firstName);
}

public void enterMiddleName(String middleName) {
	selectMiddleName.click();
	selectMiddleName.sendKeys(middleName);
}

public void enterLastName(String lastName) {
	selectLastName.click();
	selectLastName.sendKeys(lastName);
}

public void enterDateOfBirth(String dateOfBirth){
	selectDateOfBirth.click();
	selectDateOfBirth.sendKeys(dateOfBirth);
}

public void selectSuffix(String value) {
	Select chooseSuffix = new Select(suffix);
	chooseSuffix.selectByValue(value);
}

public void mailingAddress(String address) {
	streetNumberAndName.click();
	streetNumberAndName.click();
	streetNumberAndName.sendKeys(address);
	
}

public void enterApartmentUnit(String apartNumber) {
	apartmentUnit.click();
	apartmentUnit.sendKeys(apartNumber);
}

public void clickStartQuoteBtn() {
	startQuoteBtn.click();
}

public void enterCity(String cityName) {
	city.clear();
	city.sendKeys(cityName);
}

public void enterZipCode(String zip) {
	zipCode.clear();
	zipCode.sendKeys(zip);
}


 
}
