package Google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {
	public WebDriver driver;

	By searchBar = By.xpath("//input[@title='Search']");

	// constructor
	public GoogleSearch(WebDriver driver) {
		this.driver = driver;

	}

	public void GooglePage() {
		// Visit or Navigate to a page
		driver.get("https://www.google.com");

		// Maximize the screen
		driver.manage().window().maximize();

		if (driver.getTitle().equals("Google")) {
			System.out.println("Success......Google page loaded");
		} else {
			System.out.println("Failed....." + driver.getTitle() + "is loaded not Google page");

		}

	}

	public void googleSearchBar()  {

		WebElement searchField = driver.findElement(searchBar);

		if (searchField.isDisplayed()) {
			System.out.println("Success....Search Field is Displayed");
		} else {
			System.out.println("Failed .....Search Field is not Displayed");

		}
		
		searchField.sendKeys("TestNg");// Types text into the input field
		searchField.sendKeys(Keys.RETURN);

		// Validate we get correct results
		String pageSource = driver.getPageSource();

		if (pageSource.contains("TestNg")) {
			System.out.println("Success.....Valid Search result is displayed");
		} else {
			System.out.println("Failed.....invalid search result is displayed ");

		}
	}

}
