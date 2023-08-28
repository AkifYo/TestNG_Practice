package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting {
    WebDriver driver;

    @BeforeMethod
    public void setup (){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1_JQueryDatePicker(){
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-date-picker-demo");
        System.out.println(Thread.currentThread().getName()+ " :  Jquery Date Picker Page");
    }
    @Test
    public void test2_DataListFilter(){
        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");

        System.out.println(Thread.currentThread().getName()+ " :  Data List Filter Page");
    }

}
