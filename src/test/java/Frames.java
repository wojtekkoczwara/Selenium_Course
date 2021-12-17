import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

       //driver.findElement(By.id("draggable")).isDisplayed();
        //test will fail due to draggable element in frame. Selenium don't identify frames. Frame are attached as #docment and next body inside. Frames are independent to page, that they are displayed in. They are only set in the object
        //how to handle it? - Switch context! We have to take id first

        //three frame methods
        //if frameid is defined -> cake walk, just provide it to method, if not - we can provide webelement

        WebElement frameEl = driver.findElement(By.cssSelector("iframe.demo-frame"));

        driver.switchTo().frame(frameEl);

        System.out.println(driver.findElement(By.id("draggable")).isDisplayed());

        //Drag and drop - provide source and target
        Actions a = new Actions(driver);

        a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();

        //if we have nothing - we can try with indexes with blindly gessing wchich frame has which index. We can check frames amount:
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        //how to escape frame?
        driver.switchTo().defaultContent();

//        driver.get("https://the-internet.herokuapp.com/nested_frames");
//        driver.manage().window().maximize();
//
//        WebElement frameTop = driver.findElement(By.name("frame-top"));
//        driver.switchTo().frame(frameTop);
//        WebElement frameMid = driver.findElement(By.name("frame-middle"));
//        driver.switchTo().frame(frameMid);
//        System.out.println(driver.findElement(By.id("content")).getText());
//        driver.switchTo().defaultContent();
//        driver.switchTo().defaultContent();

    }

}
