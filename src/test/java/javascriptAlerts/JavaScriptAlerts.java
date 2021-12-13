package javascriptAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlerts {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        String text = "rahul";

        //Webdriver methods only
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();


        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();


        //how to handle JS alerts? - switch context to alert! We can use then accept method
        //how to handle alert text?
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //how to handle alerts with choice?  -> click on cancel -> dismiss(); click ok -> accept()
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //alerts, where you have to provide user & pass are idalerts and wll be handled later
        driver.close();

    }
}
