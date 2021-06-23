package seleniumUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public String takeSnapShot(WebDriver driver,String screenShotName) {
		
			//Creating a file object to screenshots
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath =System.getProperty("user.dir")+".//Screenshots//"+ screenShotName
			+".jpeg" ;
			//Storing source file in new file name "Screenshots"
			//FileUtils.copyFile(src, new File(".//Screenshots//" + screenShotName + ".jpeg"));
			try{
				FileUtils.copyFile(src,new File(screenshotPath));
			
			System.out.println("Screenshot was taken!!!!!!!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception while taking screenshot" + e.getMessage());
			e.printStackTrace();
		}
			return screenshotPath;
		
		
	}

}
