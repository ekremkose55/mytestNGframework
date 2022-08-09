package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;

import java.nio.file.Paths;

public class Day15_FileDownload extends TestBase {
    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()
    //downloadTest () metodunun icinde aşağıdaki testi yapın:
    //https://the-internet.herokuapp.com/download adresine gidin.
    //image1.jpg dosyasını indir
    //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.

    @Test
    public  void isExist(){
        String mevcutKlasor = System.getProperty("user.dir");//System.getProperty("user.dir"); ile dosyanin yolunu
                                                             // bulup bir String adi ile o yolu o isme assign ediyoruz
        System.out.println("MEVCUT KLASOR==> "+mevcutKlasor);

        String userKlasor = System.getProperty("user.home"); //System.getProperty("user.home"); ile dosyanin yolunu
                                            // Users/PC/     // bulup bir String adi ile o yolu o isme assign ediyoruz
        System.out.println("USER KLASOR==> "+userKlasor);

       // String filePath = "C:\\Users\\ekrem\\Desktop\\medıa\\photo\\candil.jpg"; bu farkli bir dosyanin yolu
        String filePath = userKlasor+  "/Downloads/13.GUN.pdf"; //  daha dinamik

        boolean isFileExist = Files.exists(Paths.get(filePath)); // Dosya bu yolun sonunda mi degil mi?
        Assert.assertTrue(isFileExist); // Eger dogru ise pass degilse fail olur!!!!

    }

    @Test
    public  void downloadTest(){
        //downloadTest () metodunun icinde aşağıdaki testi yapın:
        //https://the-internet.herokuapp.com/download adresine gidin.
        driver.get("https://the-internet.herokuapp.com/download");
        //image1.jpg dosyasını indir
        WebElement image1 = driver.findElement(By.linkText("image1.jpg"));
        image1.click();
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
        //Kullanici klasoru
        String userKlasor = System.getProperty("user.home");
        // indirilen dosyanin konumunu(path) buluyoruz.
        String filePath = userKlasor + "/Downloads/image1.jpg";

       //String filePath = "C://Users//ekrem//Downloads//image1.jpg"; //bu da kullanilabilir.

        //dosya var mi yok mu kontrol ediyoruz.
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);  // dosya yuklendi ise PASS, Degilse FAIL


    }


}
