package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Day15_WaitTest extends TestBase {
    //1.	Bir class olusturun : WaitTest
    //2.	Iki tane metod olusturun :  implicitWait() , explicitWait()
    //      iki metod icin de asagidaki adimlari test edin.
    //3.	https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.	Remove butonuna basin.
    //5.	“It’s gone!” mesajinin goruntulendigini dogrulayin.


    @Test
    public void implicitWait(){
       // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.	Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();


        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //5.	“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement goneMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(goneMessage.getText(), "It's gone!");

    }

    @Test
    public void explicitWait(){
        //Create WebDriverWait object.
        WebDriverWait wait = new WebDriverWait(driver,20);
        //3.    https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4.    Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();
        WebElement goneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //5.    “It's gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertEquals(goneMessage.getText(), "It's gone!");
    }

}