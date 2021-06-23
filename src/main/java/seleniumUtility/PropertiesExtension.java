package seleniumUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesExtension {
	
	
		Properties config;
		FileInputStream inputStream;
		
		
		public PropertiesExtension() {
			
			readProperties();
		}
		
		
		public void readProperties() {
			config = new Properties();
			 try {
				
				 inputStream = new FileInputStream("/Users/manishaneupane/eclipse-workspace/ProgressiveAutomation/src/main/java/Config/config.properties");
				 
				 config.load(inputStream);
				 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}


		public boolean isChrome() {
			
			String browserType = config.getProperty("Browser");
			
			if(browserType != null && browserType.equals("Chrome")) {
				return true;
			}
			
			
			return false;
		}
		

}
