package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_ActionsClassTekrar extends TestBase {

    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
    //Dikdörtgen kutu icinde sağa tıklayın.
    //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
    //Alert’te OK ye basin

    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:

    @Test
    public void contextClickMethod() {

        //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
        // driver'in internet adresine gitmesi icin TestBase de method ve driver objesi olusturmustuk!

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Dikdörtgen kutu icinde sağa tıklayın.
        // Dikdortgen uzerinde hareket olacagi icin dikdortgeni lacate ediyoruz
        WebElement dikdortgen = driver.findElement(By.id("hot-spot"));

        // Actions actions = new Actions(driver);//===> Bunu TestBase'e aldik cunku her hareket icin ayri bir obje
                                                      // olusturmak zorunda kalmamak icin
        actions.contextClick(dikdortgen).perform(); //contextClick() ==> saga tiklama komutuydu!

        //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
        String actualText = driver.switchTo().alert().getText(); //=====>> Alert'e girmek icin switchTo()
        String expectedText = "You selected a context menu";
        Assert.assertEquals(actualText, expectedText);

        //Alert’te OK ye basin  ====> alert'den cikmak icin switchTo() !!!!!
          driver.switchTo().alert().accept();  // Alert'e driver gecmesi icin switchTo() ve Ok tusuna sabmit
                                               // etmesi icin accept() kullaniyoruz
    }

    @Test
    public void moveToElement() { //moveToElement() mouse imgesini hedef uzerine getirir
        //https://www.amazon.com/  web sitesine gidin.
        driver.get("https://www.amazon.com/");
        //“Hello, Sign in , Account” linkine tıklayın.
        WebElement helloSignIn = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        actions.moveToElement(helloSignIn).perform();
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.submit();
    }

    @Test
    public void keysUpDown() {//keyDown() ile Sifht ustune basip girilen yazi buyutulecek
        //https://www.google.com/ adresine gidin.
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        // Daha sonra searcbox ustunde shift tusuna basili bir sekilde iphone yazildi
        actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("iphone").perform();

        //Text box’ta cift tiklayin(double click).
        actions.doubleClick(searchBox).perform();
    }

    @Test
    public void scrollUpDown() throws InterruptedException {//Sayfada asagi yukari gitme
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
