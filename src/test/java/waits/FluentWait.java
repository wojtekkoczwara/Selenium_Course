package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        //Webdriver methods only
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id = 'start'] button")).click();

        Wait<WebDriver> fluentWait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class).
                pollingEvery(Duration.ofSeconds(3));

        WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if( driver.findElement(By.cssSelector("[id='finish] h4")).isDisplayed()){
                    return driver.findElement(By.cssSelector("[id='finish] h4"));
                } else
                    return null;
            }
        });
    }
}
