package DemoTestNG;

import org.testng.annotations.*;
@Test(groups = "smoke")
public class ConfigurationAnnotations_2_ListBox {

    public  void test3_BootstrapDatePicker(){
        System.out.println("     (5)Test Method 3: Bootstrap List Box");
    }

    public  void test4_JQueryDatePicker(){
        System.out.println("     (5)Test Method 4: JQuery List Box");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("    (4)Excecute Before Each Test Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("    (4)Excecute After Each Test Method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("   (3)Excecute Before Class: List Box");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("   (3)Excecute After Class: List Box");
    }
    @BeforeTest
    public void  beforeTest(){
        System.out.println("  (2)Excecute Before  Each Test");
    }
    @AfterTest
    public void  afterTest(){
        System.out.println("  (2)Excecute After  Each Test");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println(" (1)Excecute Before  Each Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println(" (1)Excecute After  Each Suite");
    }
    @BeforeGroups(groups = {"regresion","smoke"})
    public  void beforeGroup(){
        System.out.println("Excecute Before  Each Group");
    }
    @AfterGroups(groups = {"regresion","smoke"})
    public  void afterGroup(){
        System.out.println("Excecute After  Each Group");
    }


}
