package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class DynamicWaits {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
       // driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
    @Test
    public  void testExlicitWait() throws InterruptedException {
        driver.findElement(By.linkText("Dynamic Data Loading")).click();
        driver.findElement(By.cssSelector("#save")).click();
        Thread.sleep(3000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement image=driver.findElement(By.xpath("//div[@id='loading']//img"));
       // wait.until(ExpectedConditions.visibilityOfElementLocated((By) image));
        Boolean isImageDisplayed=image.isDisplayed();

        Assert.assertTrue(isImageDisplayed,"\nImage is not displayed\n");
    }
    @Test
    public void testFluentWait(){
        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.id("downloadButton")).click();

        Wait <WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);
        WebElement element= wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
              WebElement progress= driver.findElement(By.xpath("//div[@id='dialog']//div[@class='progress-label']"));
            String progressBarText=progress.getText();
            if (progressBarText.equals("Complete")){
                System.out.println("Progress Is Complete");
                return progress;
            } else {
                return null;
            }

            }
        });
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testImplicitlyWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.cssSelector("div#start > button")).click();
        String textActual=driver.findElement(By.xpath("//div[@id='finish']//h4")).getText();
        Assert.assertEquals(textActual, "Hello World!");
    }
}
