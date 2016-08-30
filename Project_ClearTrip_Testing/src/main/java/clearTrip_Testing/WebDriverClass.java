package clearTrip_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverClass {

    static WebDriver driver = null;
    static String path = "E:/Browser Drivers/chromedriver_win32/";

    static WebDriver driver() {
//		System.setProperty("webdriver.chrome.driver",path+"chromedriver.exe");
//		driver = new ChromeDriver();
        driver = new FirefoxDriver();
        return driver;
    }


}
