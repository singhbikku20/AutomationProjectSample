package gmail_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverClass {
	
	static String path = "E:/Browser Drivers/chromedriver_win32/";
	static WebDriver driver =  null;
	
	
	public static WebDriver driver()
	{
		System.setProperty("webdriver.chrome.driver", path+"chromedriver.exe");
		
		driver = new ChromeDriver();
		
		return driver;
	}
	
	

}
