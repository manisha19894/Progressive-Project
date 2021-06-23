package GoogleTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Google.GoogleSearch;
import seleniumUtility.ScreenShot;

public class GoogleSearchTest {
	WebDriver driver;
	ScreenShot screen;
	
	@BeforeTest
	public void googlePageSetUp() {
		System.setProperty("webdriver.chrome.driver",".//webdriver//chromedriver");
		driver= new ChromeDriver();
		
	}
	
	@Test
	public void googleSearchBarTest() {
		screen= new ScreenShot();
		GoogleSearch searchBar = new GoogleSearch(driver);
		searchBar.GooglePage();
		screen.takeSnapShot(driver, "Google HomePage");
		searchBar.googleSearchBar();
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
