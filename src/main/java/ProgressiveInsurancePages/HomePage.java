package ProgressiveInsurancePages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumUtility.ScreenShot;

public class HomePage {

	//Creating an object of webdriver
	public WebDriver driver;
	
	
	//Constructor to create an object of this call
	public HomePage(WebDriver driver) {
		this.driver= driver;
		
		//Initializing the webelements for this class
		PageFactory.initElements(driver, this);
		
	}
	
	//Locating all the Elemnets that are going to be used from the HomePage
	
	@FindBy(xpath = "//a[@data-tracking-label='auto_section']")
	WebElement selectAutoInsurance;
	
	//Methods created to utilize the WebElements from this page
	
	
	public void navigateToHomePage() {
	
			ScreenShot screen = new ScreenShot();

			// Utilize the driver and invoke the chrome browser
			driver.get(" https://www.progressive.com/");
			driver.manage().window().maximize();

			// Wait for page to be loaded
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Take a Screenshot
			screen.takeSnapShot(driver, "Progressive Insurance HomePage");
			
			clickAutoInsurance();	
		
		}
		
	//Start a Auto Insurance
	public void clickAutoInsurance() {
		selectAutoInsurance.click();
	}
	
	
}
