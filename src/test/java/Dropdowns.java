import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        //Webdriver methods only
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        //dropdown with select tag - use select class
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropDown);

        //selecting object by index
        dropdown.selectByIndex(3);

        //selecting object by visible text
        dropdown.selectByVisibleText("AED");

        //select by value - there has to be value defined
        dropdown.selectByValue("INR");

        //get first element selected & return text. Element is returned as webelement, so we can use webelement methods on it
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        System.out.println(selectedOption);

        //-------------------------------
        //Dropdown looping - select passengers - 2 adults
        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2500);

        int i = 1;
        while (i < 5)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.close();


    }
}
