import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCookies {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        //delete cookies
        driver.manage().deleteAllCookies();

        //delete one cookie
        driver.manage().deleteCookieNamed("asdf");


        //adding cookie to runtime
        //driver.manage().addCookie(coooke);


    }
}
