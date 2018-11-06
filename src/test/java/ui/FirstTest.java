package ui;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class FirstTest extends TestBase {

    @Test
    public void GOOGLE1() throws Exception {
        System.out.println("Google1 Test Started! " + Thread.currentThread().getId());
        //getDriver().navigate().to("http://www.google.com");
        //getDriver();
        WebDriverRunner.setWebDriver(getDriver());
        open("http://www.google.com");
        sleep(3000);
        System.out.println("Google1 Test's Page title is: " + getDriver().getTitle() +" "+ Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Google");
        System.out.println("Google1 Test Ended! " + Thread.currentThread().getId());
    }

    @Test
    public void GOOGLE2() throws Exception {
        System.out.println("Google2 Test Started! " + Thread.currentThread().getId());
        //getDriver().navigate().to("http://www.google.com");
        //getDriver();
        WebDriverRunner.setWebDriver(getDriver());
        open("http://www.google.com");
        sleep(2000);
        System.out.println("Google2 Test's Page title is: " + getDriver().getTitle() +" "+ Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Google");
        System.out.println("Google2 Test Ended! " + Thread.currentThread().getId());
    }

    @Test
    public void GOOGLE3() throws Exception {
        System.out.println("Google3 Test Started! " + Thread.currentThread().getId());
        WebDriverRunner.setWebDriver(getDriver());
        open("http://www.google.com");
        sleep(2000);
        System.out.println("Google3 Test's Page title is: " + getDriver().getTitle() +" "+ Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Google");
        System.out.println("Google3 Test Ended! " + Thread.currentThread().getId());
    }
}
