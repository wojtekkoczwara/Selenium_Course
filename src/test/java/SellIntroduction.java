import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SellIntroduction {

    public static void main(String[] args) {
        //Invoke browser

        //Chrome browser - ChromeDriver -> Methods
        //Firefox browser - ChromeDriver -> Methods
//        ChromeDriver driver = new ChromeDriver();

        //chrome driver - default path: webdriver.chrome.driver
//        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");
//
//        //Webdriver methods only
//        WebDriver driver = new ChromeDriver();

        //firefox driver - geckodriver
        System.setProperty("webdriver.gecko.driver", "src/Utilities/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //go to page
        driver.get("https://rahulshettyacademy.com/");

        //get page title
        driver.getTitle();

        //log title
        System.out.println(driver.getTitle());

        //read current URL
        System.out.println(driver.getCurrentUrl());

        //close browser - close only current tab
        //driver.close();

        //another method to close - close all tabs, quit from browser
        driver.quit();



    }
}
