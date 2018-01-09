package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_001_Lensway_InvalidLoginVerification {

    public WebDriver driver;

    @BeforeTest

    public void setuUp()
    {

        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Driver1\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.get("https://uat-lw-se.lenslogistics.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test

    public void userRegistration()
    {
        WebElement xyz=driver.findElement(By.xpath("//span[text()='Logga in']"));
        Actions action= new Actions(driver);
        action.moveToElement(xyz).build().perform();


        // User Login
        driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("Test5@gmail.com");
        driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("Test1234");
        driver.findElement(By.xpath("//input[@value='Logga in']")).click();
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='form-1515491462275']/div[1]/div/div[4]")).getText(), "Inloggningen misslyckades, var vänlig och försök igen.");

            }

    @AfterClass

    public void endTest()
    {
driver.close();

    }

}
