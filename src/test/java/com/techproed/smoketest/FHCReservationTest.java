package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.pages.FHCReservationPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCReservationTest extends TestBase {

    @Test
    public void fhcRezervasyonTest() throws InterruptedException {
        driver.get("http://www.fhctrip-qa.com/admin/RoomReservationAdmin/Create");
        // FHCLoginPage de bulunan login2() method'unu cagirmak icin obje olusturuyoruz
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);

        //fhcReservationPage objesini olustur
        FHCReservationPage fhcReservationPage = new FHCReservationPage(driver);

        //olusturdugumuz fhcLoginPage objesi ile login2() methodunu cagir
        fhcLoginPage.login2();

        //fhcReservationPage objesini kullanarak class'daki elementleri cagir
        Select idUserSelect = new Select(fhcReservationPage.idUser);//dropdown (IDUser)
        idUserSelect.selectByIndex(1); // manager2

        Select idHotelRoomSelect = new Select(fhcReservationPage.idHotelRoom);//dropdown (IDHotelRoom)
        idHotelRoomSelect.selectByIndex(5); //zaman

        fhcReservationPage.price.sendKeys("500");
        fhcReservationPage.dateStart.sendKeys("08/15/2020");
        fhcReservationPage.dateEnd.sendKeys("08/25/2020");
        fhcReservationPage.adultAmount.sendKeys("2");
        fhcReservationPage.childrenAmount.sendKeys("3");
        fhcReservationPage.surname.sendKeys("Kose");
        fhcReservationPage.phone.sendKeys("2144040000");
        fhcReservationPage.email.sendKeys("ekose@gmail.com");
        fhcReservationPage.notes.sendKeys("Gol manzarali");
        fhcReservationPage.isApproved.click();
        fhcReservationPage.isPaid.click();
        fhcReservationPage.saveButton.click();
        fhcReservationPage.succes_mesaj.isDisplayed();


        //"RoomReservation was inserted successfully" mesajinin gorulup gorulmedigini test edein
        Thread.sleep(3000); // mesaj gec acildigi icin

        Assert.assertTrue(fhcReservationPage.succes_mesaj.isDisplayed());

//        String mesaj = fhcReservationPage.succes_mesaj.getText();  // mesajin gorulmesi icin alternatif
//        Assert.assertTrue(mesaj.equals("RoomReservation was inserted successfully"));

        //ok butonuna tiklayin.








    }
}