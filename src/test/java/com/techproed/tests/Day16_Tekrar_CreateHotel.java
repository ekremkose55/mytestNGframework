package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_Tekrar_CreateHotel extends TestBase {
    //Tests packagenin altina class olusturun: CreateHotel
    //Bir method olusturun: createHotel
    @Test
    public  void createHotel(){
        //http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
        driver.get("http://www.fhctrip.com/admin/HotelAdmin/Create");

        //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
        //Username : manager2
        //Password : Man1ager2!
        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
        textBox.sendKeys("manager2");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        password.sendKeys("Man1ager2!");
        WebElement loginBox = driver.findElement(By.xpath("//*[@id=\"add-form\"]/div[3]/button"));
        loginBox.submit();

        //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
        driver.findElement(By.id("Code")).sendKeys("QUEEN");
        driver.findElement(By.id("Name")).sendKeys("DALLAS HOTEL");
        driver.findElement(By.id("Address")).sendKeys("in Dallas");
        driver.findElement(By.id("Phone")).sendKeys("214 444 4444");
        driver.findElement(By.id("Email")).sendKeys("dallashotel@gmail.com");

        WebElement IDGroup = driver.findElement(By.id("IDGroup"));
        Select select = new Select(IDGroup);
        select.selectByIndex(1);

        //Save butonuna basin.
        driver.findElement(By.id("btnSubmit")).submit();

        //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,10);
        boolean message = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"Hotel was inserted successfully"));
        Assert.assertTrue(message);


        //OK butonuna tiklayin.
        driver.findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
    }




}
