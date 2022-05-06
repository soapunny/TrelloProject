package app.logic;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumController {
	private static SeleniumController instance = null;
	private ChromeDriver conn;	
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "driver/chromedriver.exe";
	
	private SeleniumController() {}
	
	public static SeleniumController getInstance() {
		synchronized(SeleniumController.class) {
			if(instance == null) {
				instance = new SeleniumController();
			}
		}
		return instance;
	}
	
	public ChromeDriver getConnection(){
		if(conn == null) {
			try {
				System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
				options.addArguments("--disable-extensions");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				options.setExperimentalOption("prefs", prefs);
				conn = new ChromeDriver(options);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public void close() {
		if(conn != null) {
			//conn = 
			conn = null;	
		}
		
	}
}
