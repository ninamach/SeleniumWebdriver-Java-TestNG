package automation.demo.Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(automation.demo.Listener.ListenerDemo.class)

public class ListenerTestCases {

    static WebDriver driver;

    @Test
    public void TestPass() {
        //System.setProperty("webdriver.chrome.driver",
         //       "C:\\Users\\Vibha\\Desktop\\SeleniumKT\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver= new ChromeDriver();
        /*
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        //driver.findElement(By.id("btnLogin")).submit();
        driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")).submit();
        String dashboardTitle = driver.findElement(By.id("welcome")).getText();
        Assert.assertTrue(dashboardTitle.contains("Welcome"));
        */
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
        driver.quit();
    }

    @Test
    public void TestFail() {

        WebDriver driver = new ChromeDriver();
        //driver= new ChromeDriver();
        /*driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).submit();
        String dashboardTitle = driver.findElement(By.id("welcome")).getText();
        Assert.assertTrue(dashboardTitle.contains("Hello"));
*/
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("Hello"));
        driver.quit();

    }
}

