package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_Tekrar_EnableTest extends TestBase {

    // Enable == etkinlestirme
    //1.	Bir class olusturun : EnableTest





    @Test
        //2.	Bir metod olusturun :  isEnabled()
    public void isEnabled() throws InterruptedException {
        //3.	https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4.	Enable butonuna basin.
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();


        //6.	“It’s enabled!” mesajinin goruntulendigini dogrulayin.
        // Once explicit wait gerekli cunku yukleme icin zaman gerekiyor ve belli bir kosulu var!!!
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Ardindan message bekleyip locate edilecek...
        WebElement enableMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
        Assert.assertEquals(enableMessage.getText(),"It's enabled!");
        System.out.println(enableMessage.getText());

        //5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Thread.sleep(5000);
        Assert.assertTrue(textBox.isEnabled());



    }







}
