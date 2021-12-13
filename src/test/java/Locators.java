import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

       // chrome driver - default path: webdriver.chrome.driver
        //implicit wait - wait some seconds and check if element is sshown
        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        //Webdriver methods only
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.findElement(By.id("inputUsername")).sendKeys(("rahul"));
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();

        //css selector: tagname.classname
        //or tagname#id
        //or tagName[tagAttribute='value']

        System.out.println(driver.findElement(By.cssSelector(".error")).getText());

        //if there's not possibility to check selector tools like ranorex, we can type in console $(p.error) - $(selector)

        //Forgot password function - find element by linkText
        driver.findElement(By.linkText("Forgot your password?")).click();

        //xPath
        //validation in console of xpath: $x('//input[@placeholder='Name']')
        // //Tagname[@attribute='value']
        driver.findElement(By.xpath("//input[@placeholder='Name']"));

        //identify locator                                            make action
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@rsa.com");

        //clear field, select second element, when there are more than one
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        //select second element if there are more than one with css selector -> nth:child(2)
        driver.findElement(By.cssSelector("input[type=text]:nth-child(3)")).sendKeys("john@gma.com");


        //traverse through tags
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("324324234234");

        //wait 1 sec to handle ElementClickInterception
        Thread.sleep(1000);

        //select login button
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        //grab text & print output - use cssSelector with tag traversing - just write with space
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        //wait 1 sec to handle ElementClickInterception
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(("rahul"));

        //regex in selectors:
        //*='pass' - very element matching result
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        //next steps in process
        driver.findElement(By.className("signInBtn")).click();
        driver.findElement(By.id("chkboxOne")).click();
//        driver.findElement(By.id('#chkboxTwo')).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();




    }
}
