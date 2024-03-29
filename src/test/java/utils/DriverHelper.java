package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {
    //singleton Pattern Design


    public static WebDriver driver;

    //private constructor

    private DriverHelper(){} //I make my constructor private because i do not want anyone to create an object from this class.

    public static WebDriver getDriver(){
        if(driver == null || ((RemoteWebDriver) driver).getSessionId()==null){
            String browser = "chrome";
            switch (browser){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jose\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                    ChromeOptions opt = new ChromeOptions();
                    opt.setBinary("C:\\Users\\Jose\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
                    driver = new ChromeDriver(opt);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    break;

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}
