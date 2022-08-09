package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day11_Soft_Hard_Assertion {
    //Class name : Soft_Hard_Assertion
    //http://a.testaddressbook.com/sign_in adresine gidin.
    //email textbox,password textbox, ve signin button elementlerini locate edin.
    //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
    //Username :  testtechproed@gmail.com
    //Password :   Test1234!
    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    //Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com
    // beklenen kullanıcı  kimliğinin(userID) doğrulayın

    WebDriver driver;

    @BeforeClass
    //http://a.testaddressbook.com/sign_in adresine gidin.
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }
    @Test
    //email textbox,password textbox, ve signin button elementlerini locate edin.
    //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
    public void login(){
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");
        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");
        WebElement signInBotton = driver.findElement(By.name("commit"));
        signInBotton.click();
        //driver.manage().window().maximize();
    }
    @Test(dependsOnMethods = "login")
    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    public void homePage(){
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
        System.out.println(welcomeMessage.getText());
       // Assert.assertTrue(welcomeMessage.isDisplayed());// HARD ASSERT
        System.out.println("Hard Assert fail olursa bu satir calismayacak!");


        //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.

        // SOFT ASSERT
        //1. adim: create object
        SoftAssert softAssert = new SoftAssert();
        // 2. adim: assertion icin olusturdugumuz object'i kullanacagiz
        softAssert.assertTrue(welcomeMessage.isDisplayed());
        //softAssert.assertTrue(!welcomeMessage.isDisplayed());// ornek olsun diye verdik
        // softAssert.assertEquals(3,5);//fail ==> ornek bu! code ile ilgisi yok!
        //3. adim: assertAll(); ile asagida zaten var!!!!




        //Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com
        // beklenen kullanıcı  kimliğinin(userID) doğrulayın

        WebElement userID = driver.findElement(By.className("navbar-text"));
        String actualID = userID.getText();
        String expectedID = "testtechproed@gmail.com";

       // Assert.assertEquals(actualID,expectedID);// HARD ASSERT  pass

        //SOFT ASSERT

        //1. adim: create object yapmistik
        // 2. adim: assertion icin olusturdugumuz object'i kullanacagiz
        softAssert.assertEquals(actualID,expectedID);
        //3. adim: assertAll(); ile
        softAssert.assertAll();// bu satir COK ONEMLI assertAll(); gercek assertion'u yapar
                               // assertAll(); yazilmazsa test pass olur hatayi vermez!

    }

    }
