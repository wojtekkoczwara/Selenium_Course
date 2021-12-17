package windowConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class windowHandle {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();

        //get all tabs (parent id, child id) traverse through them with iterator
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);

        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
       String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0].trim();
       driver.switchTo().window(parentId);
       driver.findElement(By.id("username")).sendKeys(emailId);





    }
}
