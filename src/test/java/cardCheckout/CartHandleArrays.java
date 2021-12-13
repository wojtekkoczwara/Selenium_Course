package cardCheckout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class CartHandleArrays {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");


        //Webdriver methods only
        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        //how to handle add to cart in case buttons have no special attributes?
        //take every element with product--name class into one array
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        
        int j = 0;
        for (int i=0; i<products.size(); i++){
            //Brocolli - 1 kg - to compare we have to split string

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();



            //check whether name you extracted is present in array or not
            //convert array to array list for easy search
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)){
                //how to stop looping, when we use all items from itemsList? - use separate variable j, which store iterations value
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j == itemsNeeded.length) {
                    System.out.println(j);
                    break;
                }



            }

        }
        driver.quit();
    }

}

/*
situation to handle: When we rely on text, text may change (e.g. from "add to cart" => added)> How to handle that?
example of xpath:

 */
