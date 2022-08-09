package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_HandlingAlerts extends TestBase {
    //Bir class olusturun: HandlingAlerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    // OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.

    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert


    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        buton1.click();
         // Alert uzerindeki mesaji konsolde yazdir
        // System.out.println("Alert mesaji: " + driver.switchTo().alert().getText());

        // uyaridaki (alert) OK butonuna tiklayiniz
        driver.switchTo().alert().accept();// accept()==> click OK demektir

        // result mesajının görüntülendiğini doğrulayın. ==> idDisplayed() ile...
        // locate result message
        WebElement resultMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMessage.isDisplayed()); // Hard assert

    }
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        buton2.click();
        //uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        // result mesajının görüntülendiğini doğrulayın. ==> idDisplayed() ile...
        // locate result message
        WebElement resultMessage2 = driver.findElement(By.xpath("//p[@id='result']"));
        //Assert.assertTrue(resultMessage2.isDisplayed()); // Hard Assert

        // veya

        // result mesajin "You clicked: Cancel" oldugunu Assert ile dogrulayabiliriz
        String actualMesaj = resultMessage2.getText();
        String expectedMesaj = "You clicked: Cancel";
        Assert.assertEquals(actualMesaj, expectedMesaj);


    }
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    // OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton3.click();
        driver.switchTo().alert().sendKeys("Ekrem Kose");
        driver.switchTo().alert().accept();
       WebElement resultMesaj3 = driver.findElement(By.xpath("//p[@id='result']"));
       Assert.assertTrue(resultMesaj3.isDisplayed());
    }

}
