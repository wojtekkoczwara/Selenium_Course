package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartHandle {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");


        //Webdriver methods only
        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //implicit wait - when there's general time gap to identify next element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //explicit wait declaration
        //Explicit wait - about element that only applies to one case
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();


        addItems(itemsNeeded, driver);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//*[@class='cart']//button")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Enter promo code']")));
        driver.findElement(By.cssSelector("[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();

        //get text about applied promotion

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));



        String promoText = driver.findElement(By.cssSelector("span.promoInfo")).getText();
        System.out.println(promoText);

        //driver.quit();
    }


    public static void addItems(String[] itemsNeeded, WebDriver driver){

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int j = 0;
        for (int i=0; i<products.size(); i++){


            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();


            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)){

                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j == itemsNeeded.length) {
                    System.out.println(j);
                    break;
                }

            }

        }
    }
}

//Explicit wait - performance issues are caught, applied only in targeted elements, no preformance issues
