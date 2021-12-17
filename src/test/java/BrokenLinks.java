import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

//        href="https://rahulshettyacademy.com/brokenlink";
        //broken URLs -  use java method to call URLS and check status code

        //Step 1 get all urls tied up to the links using Selenium
        //if status codes >400 - URL broke
        //mix of selenium & jva methods

        //start with simple link & get attribute of it
        String url = driver.findElement(By.linkText("SoapUI")).getAttribute("href");

        //open connection method to identify status codes of links
        //create ovject of URL class
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        //make a call using HEAD http request method type - invoke URL using java method
        connection.setRequestMethod("HEAD");
        connection.connect();

        //take response status code
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);

        //----second link---------------------------------------------------------------

        url = driver.findElement(By.linkText("Broken Link")).getAttribute("href");

        connection = (HttpURLConnection) new URL(url).openConnection();


        connection.setRequestMethod("HEAD");
        connection.connect();


        responseCode = connection.getResponseCode();
        System.out.println(responseCode);


        //----------------------Iterating all over the links
        //in the page every link has a parent gf-li

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

//        for (WebElement link : links){
//            url = link.getAttribute("href");
//            connection = (HttpURLConnection) new URL(url).openConnection();
//            connection.setRequestMethod("HEAD");
//            connection.connect();
//            responseCode = connection.getResponseCode();
//            System.out.println(responseCode);
//            if(responseCode >= 400){
//
//                Assert.assertTrue(false);
//                System.out.println("The link with text: " + link.getText() + " with code " + responseCode);
//
//            }
//        }

        //in case above, when script finds broken link - it stop. So links after broken link are not checked. To check another ones we have to implement soft assertions

        //soft assertions
        SoftAssert softAssert = new SoftAssert();

        for (WebElement link : links){
            url = link.getAttribute("href");
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            //Assert.assertTrue(responseCode<400, "The link with text: " + link.getText() + " with code " + responseCode);
            //replace with soft assertion
            softAssert.assertTrue(responseCode<400, "The link with text: " + link.getText() + " with code " + responseCode);

        }

        //to validate and print false at the end of the script, we have oto add assertAll at the end to verify all assertions (that's the function of assert all :) )
        softAssert.assertAll();

    }
}
