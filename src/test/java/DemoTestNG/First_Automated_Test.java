package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class First_Automated_Test {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testTableSortAndSearch(){
        driver.findElement(By.linkText("Table Sort & Search")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Ayse");
    }
}
