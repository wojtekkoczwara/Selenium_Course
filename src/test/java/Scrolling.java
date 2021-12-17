import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Scrolling {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        //Scrolling - important case for f.e. headless mode - focus directly on element, where we want to scroll
        //Initialize JavaScriptExecutor

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Execute script
        //executor executes commands directly inside console (inside browser)
        //window.scroll - simple scroll by pixels absolute value
        js.executeScript("window.scroll(0,500)");
        Thread.sleep(3000);
        //Scrolling inside an element for absolute value
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        //how to identify all rows in table? e.g. for sum
        //summing all element at iteration
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;

        for (int i=0; i < values.size(); i++){
            sum += Integer.parseInt(values.get(i).getText());
        }

        //validating total amount
        int amount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum, amount);

    }
}
