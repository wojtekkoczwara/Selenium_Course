import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarComplex {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();

        //how to handle complex date picker for e.g. august 23
        driver.findElement(By.xpath("//*[@id='travel_date']")).click();

        //1. create a lsit of webelements for chosing day - grab common attribute, put into list, iterate
        //2. How to identify month & year? - through while loop with datepicker

        //point 2. iterate and click on next button as many times as possible to find correct month
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }


        //point 1
        List<WebElement> days = driver.findElements(By.className("day"));
        int count = days.size();


        for(int i=0; i< count; i++){
            String text = driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("23")){
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }

    }
}
