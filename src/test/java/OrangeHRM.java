import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrangeHRM {

    public static WebDriver driver;
    static  String BaseURL = "https://opensource-demo.orangehrmlive.com/";

    @BeforeTest
    public  static void WebSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jihan SQA\\Desktop\\BSTA\\Selenium_Java_TestNG\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get((BaseURL));
        //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));



    }

    @Test
    public static void OrangeHRMLandingPage(){


    }


    @AfterTest
    public static void TestClosure(){

        driver.quit();

    }



}
