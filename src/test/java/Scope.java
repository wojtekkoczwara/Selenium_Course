import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        //1. Give me the count of links in the page
        //2 count of footer section
        //3 links only for 1st column

        System.out.println(driver.findElements(By.tagName("a")).size());

        //creating minidriver for small section, kinda wrapping, kinda within function in Cypress- links only for footer
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println( footer.findElements(By.tagName("a")).size());

        //same with wrapping column inside
        WebElement columnDriver = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

        int columnSize = columnDriver.findElements(By.tagName("a")).size();
        System.out.println(columnSize);



        //4 click on each link in the column and check if the page is opened
        for(int i=1; i<columnSize; i++){

            //clicking with control with enter - syntax as keyboardevent
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

        }

        //grab the title of every tab and print it with window handler

        Thread.sleep(5000);

        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();

        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }



    }
}
