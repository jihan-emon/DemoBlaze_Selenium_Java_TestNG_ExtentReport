import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners (ITestListener.class)

public class OrangeHRM {

    public static WebDriver driver;
    static  String BaseURL = "https://opensource-demo.orangehrmlive.com/";
    static JavascriptExecutor js;

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

    @Test(priority = 0)
    public static void OrangeHRMLogin() throws Exception {

        MyScreenRecorder.startRecording("");


        driver.findElement(By.xpath("//input[@id='txtUsername']")).click();
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).click();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"));

        MyScreenRecorder.stopRecording();



    }

    @Test(priority = 1)
    public static void Dashboard() throws Exception {
        MyScreenRecorder.startRecording("");

        //driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
        driver.findElement(By.xpath("//b[contains(text(),'Dashboaghjghjgh]")).click();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(450,0)", "");
        Thread.sleep(3000);

        MyScreenRecorder.stopRecording();


    }


    @AfterTest
    public static void TestClosure(){

        driver.quit();

    }



}
