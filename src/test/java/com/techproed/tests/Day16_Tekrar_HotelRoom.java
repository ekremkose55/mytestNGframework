package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day16_Tekrar_HotelRoom extends TestBase {
    //Tests packagenin altina class olusturun: HotelRoomCreation
    //Bir method olusturun:  RoomCreateTest()
    @Test
    public void roomCreateTest(){
    //http://www.fhctrip.com/admin/HotelRoomAdmin adresine gidin.
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
    //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //Login butonuna basin.
        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
        textBox.sendKeys("manager2");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        password.sendKeys("Man1ager2!");
        WebElement loginBox = driver.findElement(By.xpath("//*[@id=\"add-form\"]/div[3]/button"));
        loginBox.submit();

    //Add Hotel room butonuna tiklayin
    WebElement addRoom = driver.findElement(By.xpath("//span[@class='hidden-480']"));
    addRoom.click();

    //Acilan sayfadaki butun textboxlara istediginiz verileri girin
        WebElement IDHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(IDHotel);
        select.selectByValue("757");

        driver.findElement(By.id("Code")).sendKeys("King");
        driver.findElement(By.id("Name")).sendKeys("Adam White");
        driver.findElement(By.id("Location")).sendKeys("in Plano");
        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/textarea")).sendKeys("Gokyuzu manzarali");

        // price
        WebElement kaynak = driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement hedef = driver.findElement(By.id("Price"));
        actions.dragAndDrop(kaynak,hedef).perform();



    //Save butonuna basin.
    //“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin.
    //Hotel rooms linkine tiklayin.
    //"LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.

    }
}
