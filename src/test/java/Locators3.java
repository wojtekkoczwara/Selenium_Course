import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators3 {

    public static void main(String[] args) {

        ////header/div/button[1]/following-sibling::button[1]  - find element by following Sibling

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        //Webdriver methods only
        WebDriver driver = new ChromeDriver();


        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();

        //child to parent traverse:
        //  //header/div/button[1]/parent::div
        //  //header/div/button[1]/parent::div/parent::header
        driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();



    }
}
