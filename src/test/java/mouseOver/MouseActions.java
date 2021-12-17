package mouseOver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement move = driver.findElement(By.cssSelector("[id='nav-link-accountList']"));
        //Actions - to handle iteractions
        Actions actions = new Actions(driver);

        //uppercase-  enter something with SHIFT - heydown method & how to double click it?
        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).
                sendKeys("hello").doubleClick().build().perform();


        //hover over element
        //context click() - click on element and deselect everything else
        //click and hold - click and hold something
        actions.moveToElement(move).contextClick().build().perform();

        driver.findElement(By.id("nav-link-accountList"));

    }
}
