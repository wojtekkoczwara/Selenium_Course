import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SslCert {

    public static void main(String[] args) {


        //using chrome options - to handle SSL certification (for insecure alerts)
        DesiredCapabilities ch = new DesiredCapabilities();
        ch.acceptInsecureCerts();

        ChromeOptions c = new ChromeOptions();
        //capability to handle ssl cert
        c.merge(ch);

        //when script see alert window, automatically proceed to page

        //also we can accept all insecure certs
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        //accept all ssl certs
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        //capabilities are for settings general script profile, chrome options are for handling browser options

        //rest of code

        System.setProperty("webdriver.chrome.driver", "src/Utilities/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();


    }
}
