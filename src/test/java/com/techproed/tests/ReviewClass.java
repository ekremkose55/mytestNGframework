package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReviewClass {
    //https://www.airbnb.co.in/ adresine git
    //Sayfa basligini(title) al ve konsolda yazdir.
    //Sayfanin mevcut url’ ini (current url) al
    //Sayfanin source(page source) ‘u al.

    @Test
    public void reviewClass(){
        Driver.getDriver().get("https://www.airbnb.co.in/ ");
        String getTitle = Driver.getDriver().getTitle();
        System.out.println("Page TITLE: "+ getTitle);
        //System.out.println(Driver.getDriver().getTitle()); //veya boyle
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("current URL: "+currentUrl);
        String pagesource = Driver.getDriver().getPageSource();
        System.out.println("Page SOURCE: "+ pagesource);
    }
    @Test
    //http://ebay.com adresine git
    //Search box’a “Selenium” yaz
    //Search butonuna tikla
    //Selenium icin kac sonuc var kontrol et ve konsolda yazdir.
    //Sayfa basligini(title) al ve konsolda yazdir.
    //Sayfanin mevcut url’ini (current url) al
    //Sayfanin source(page source) ‘u al.
    public void ebayTest() {
        //http://ebay.com adresine git
        Driver.getDriver().get("http://ebay.com");

        //Search box’a “Selenium” yaz
        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        searchBox.sendKeys("Selenium");

        //Search butonuna tikla
        WebElement searchButon = Driver.getDriver().findElement(By.id("gh-btn"));
        searchButon.click();

        //Selenium icin kac sonuc var kontrol et ve konsolda yazdir.
        WebElement results = Driver.getDriver().findElement(By.className("srp-controls__count-heading"));
        System.out.println(results.getText());

        //Sayfa basligini(title) al ve konsolda yazdir.
        String title = Driver.getDriver().getTitle();
        System.out.println(title);

        //Sayfanin mevcut url’ini (current url) al
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);

        //Sayfanin source(page source) ‘u al.
        String pageSource = Driver.getDriver().getPageSource();
        System.out.println(pageSource);

    }
}
