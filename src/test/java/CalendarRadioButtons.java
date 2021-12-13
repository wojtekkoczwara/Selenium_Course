import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class CalendarRadioButtons {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        //Webdriver methods only
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        //calendar
        //

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
       // ui-datepicker-trigger



        //check enability of element
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        //select round-trip (radio buttons)
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        
        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        
        //how to handle this if selenium cannot perform enability validation? 
        //something may be visible disabled, but it's enabled under the shell (e.g. becomes enabled after click)

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
       if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
           System.out.println("it's enabled");
           Assert.assertTrue(true);
       } else {
           System.out.println("it's disabled");
           Assert.assertFalse(true);
       }
       driver.close();

    }
}
