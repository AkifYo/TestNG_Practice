package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @DataProvider
    public Object [][] ajaxData(){
        Object [][] data = new Object[2][2];
        data[0][0]="Akif Yorulmaz";  data[0][1]="Akif was here";
        data[1][0]="Joe Doe";  data[1][1]="He was here";
        return data;
    }
    @Test(dataProvider = "ajaxData")
    public void testAjaxForm(String name, String message){
        System.out.println("Name : "+name);
        System.out.println("Message : "+message);
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.findElement(By.id("title")).sendKeys(name);
        driver.findElement(By.id("description")).sendKeys(message);
        driver.findElement(By.id("btn-submit")).click();
    }

}
