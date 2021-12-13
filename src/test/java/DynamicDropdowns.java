import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class DynamicDropdowns {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        //Webdriver methods only
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

       //dynamic dropdowns - depend on provided text and properties of other elements
        //selenium scans page from left, so if we want to select second xpath we have to do something like this - wrap whole xpath and tell to take second index

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        sleep(2000);

        //if we do it w/o ()[2] - element won't be clicked. First will be found in "From" section, but not visible, because it's hidden.
        //It is found (if not - no such element found would be thrown), but not visible because it's in hidden dropdown

        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();


        //dropdowns with indexes - it can come in handy when w want to remove indexes from xPath
        //it can be done by traversing from parent to child (also traversing not one by one, but traverse through all
        //e.g. //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

        driver.close();


    }
}
