package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class TestBase {

    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    //protected  RemoteWebDriver driver;

    @BeforeMethod
    //@Parameters(value = "chrome")
    public void setupTest () throws MalformedURLException {

        String browser = "chrome";
        //Set DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Firefox Profile Settings
        /*if (browser=="firefox") {
            FirefoxProfile profile = new FirefoxProfile();
            //Accept Untrusted Certificates
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            //Use No Proxy Settings
            profile.setPreference("network.proxy.type", 0);
            //Set Firefox profile to capabilities
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        }*/

        //Set BrowserName

        capabilities.setBrowserName("chrome");
        capabilities.setVersion("69.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments(Arrays.asList("--window-position=0,0"));
        options.addArguments(Arrays.asList("--window-size=1920,1080"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        Configuration.browser = "chrome";

        //Set Browser to ThreadLocalMap
        //driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
    }

    public RemoteWebDriver getDriver() {
        //Get driver from ThreadLocalMap
        //return driver;
        return driver.get();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.get().quit();
    }

    @AfterClass
    void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
}
