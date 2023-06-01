import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

@Listeners (ITestListener.class)

public class DemoBlaze {

    public static WebDriver driver;
    static  String BaseURL = "https://www.demoblaze.com/index.html";
    static JavascriptExecutor js;
    private ExtentReports extent;

    @BeforeTest
    public void WebSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\web-automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get((BaseURL));
//        driver.manage().deleteAllCookies();
//        driver.navigate().refresh();
        //Thread.sleep(3000);
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getTitle().contains("STORE"));
        System.out.println("Application started......");
        ExtentTest test = this.extent.createTest("Application has been launched", "Will complete the three(03) different test scenarios");
        test.log(Status.INFO, "Successfully Navigated to the Read & Accept Screen");

    }

    @Test(priority = 0)
    public void DemoBlazeLogin() throws Exception {

        MyScreenRecorder.startRecording("");
        this.extent.createTest("");


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

    //@Test(priority = 1)
    public static void Dropdown() throws Exception {
        MyScreenRecorder.startRecording("");

        driver.findElement(By.xpath("//b[contains(text(),'GIP')]")).click();
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(450,0)", "");
        Thread.sleep(3000);
        //dropdown
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='empsearch_employee_status']")));
        dropdown.selectByValue("5");
        Thread.sleep(3000);


        MyScreenRecorder.stopRecording();


    }

    //@Test(priority = 2)
    public static void Mousehoover() throws InterruptedException {
        // Mouse Hover
        WebElement element = driver.findElement(By.xpath("//b[contains(text(),'Performance')]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(3000);

        element = driver.findElement(By.xpath("//b[contains(text(),'Performance')]"));
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(3000);

        element = driver.findElement(By.xpath(" //b[contains(text(),'Recrutement')]"));
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(3000);




    }

    //@Test(priority = 3)
    public static void DateTimePicker() throws InterruptedException {
        driver.findElement(By.xpath("//b[contains(text(),'Mes Infos')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='personal_txtLicExpDate']")).clear();
        WebElement dateBox = driver.findElement(By.xpath("//input[@id='personal_txtLicExpDate']"));
        dateBox.sendKeys("01011966");
        Thread.sleep(3000);



    }

    @Test(priority = 4)
    public static void FileUpload() throws InterruptedException, AWTException {

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,150)", "");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Upload Files')]")).click();
        StringSelection s = new StringSelection("C:\\Users\\Jihan SQA\\Desktop\\Agilibo\\GTM-1_Bugs\\Issue_ID_10.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Thread.sleep(1000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);





    }





    //@Test(priority = 2)
    public static void NewTab() throws InterruptedException {




    }

    @AfterTest
    public static void TestClosure(){

        driver.quit();

    }



}
