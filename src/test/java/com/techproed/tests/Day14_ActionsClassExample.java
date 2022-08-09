package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;


public class Day14_ActionsClassExample extends TestBase {
    //Create  class: ActionsClassExample
    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
    //Dikdörtgen kutu icinde sağa tıklayın.
    //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
    //Alert’te OK ye basin

    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    @Test
    public void contextClickMethod(){

        //https://the-internet.herokuapp.com/context_menu web sitesine gidin.

     driver.get("https://the-internet.herokuapp.com/context_menu");

      //Dikdörtgen kutu icinde sağa tıklayın.

        WebElement dikdortgen = driver.findElement(By.id("hot-spot"));
       // Actions actions = new Actions(driver);===> Bunu TestBase'e aldik
        actions.contextClick(dikdortgen).perform();

        //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
        String actualText = driver.switchTo().alert().getText(); //=====>> Alert'e girmek icin switchTo()
        String expectedText = "You selected a context menu";
        Assert.assertEquals(actualText,expectedText);

        //Alert’te OK ye basin  ====> alert'den cikmak icin switchTo() !!!!!
        driver.switchTo().alert().accept();

        }
    @Test
    public void hoverOver(){
        //https://www.amazon.com/  web sitesine gidin.
        driver.get("https://www.amazon.com/");
        //“Your Account” linkine tıklayın.
        WebElement helloSignIn = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        actions.moveToElement(helloSignIn).perform();
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();

        //Sayfa basliginin(page title) “Your Account) icerdigini(contains) dogrulayin.
        }

    @Test
    public void keysUpDown(){
        //https://www.google.com/ adresine gidin.
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        //searchBox.sendKeys("iphone");
        //( input(giris) => iphone , output => IPHONE
        //BUYUK HARF ICIN
        //1.YOL:
        // searchBox.sendKeys(Keys.SHIFT+"iphone");
        //2.yol: ACTIONS CLASS
//        actions.
//                moveToElement(searchBox).
//                click().
//                keyDown(Keys.SHIFT).
//                sendKeys("iphone").
//                perform();
        actions.
                keyDown(searchBox,Keys.SHIFT).
                sendKeys("iphone").
                keyUp(searchBox, Keys.SHIFT).
                perform();
        //Text box’ta cift tiklayin(double click).
        actions.doubleClick(searchBox).perform();
    }

    @Test
    public void scrollUpDown() throws InterruptedException {
        //https://www.google.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        // sayfayi asagidogru kaydirma
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        // bir sayfada birden fazla page_down ve page_up kullanabiliriz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        // ARROW_DOWN kullanirsak sayfa asagi bi tik iner
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        // ARROW_UP kullanirsak sayfa yukari bi tik iner
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);
        // sayfayi yukaridogru kaydirma
        actions.sendKeys(Keys.PAGE_UP).perform();

    }


}

