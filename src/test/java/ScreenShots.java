import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenShots {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

        //delete cookies
        driver.manage().deleteAllCookies();

        //delete one cookie
//        driver.manage().deleteCookieNamed("asdf");

        //Taking screenshots - cast method for screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(image, new File("src/Utilities/Screenshots/screenshot.png"));

        //how to handle broken links


    }

}
