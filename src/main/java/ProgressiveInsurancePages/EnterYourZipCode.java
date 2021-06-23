package ProgressiveInsurancePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterYourZipCode {

		//Creating an object of webdriver
	public WebDriver driver;
	
	//Constructor
	public EnterYourZipCode(WebDriver driver) {
		this.driver = driver;
		
		//Initializing the webelements for this class
		PageFactory.initElements(driver, this);
		
	}
	
	//Locating all the Elemnets that are going to be used from the BundlePage
	@FindBy(xpath = "//input[@id='zipCode_overlay']")
	WebElement zipField;
	
	@FindBy(xpath = "//input[@id='qsButton_overlay']")
	WebElement getAQuote;
	
	
	
	public void enterZipField(String zip) {
		zipField.sendKeys(zip);
	}
	
	public void clickGetAQuote() {
		getAQuote.click();
	}
	
}
