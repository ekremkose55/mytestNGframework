package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//Yeni bir class oluşturun: FaceLogin
//Bir test methodu oluşturun: faceLoginTest ()
//Kullanıcı geçersiz kimlik bilgileri girdiğinde,
// kullanıcı “The email or phone number you’ve entered doesn’t match any account.” mesajini görmelidir.
//https://www.facebook.com/
//Username: fakeusername
//Password: fakepassword

public class FaceLoginPage {
    //create driver
    WebDriver driver;

    //Constructor kullanarak driver'i baslatalim
    public FaceLoginPage(WebDriver driver){
        this.driver = driver;
        // page object'lerini baslatmak icin PageFactory.initElements() kullaniyoruz
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="email")
   public WebElement email;

    @FindBy(id="pass")
    public WebElement password;

    @FindBy(id ="u_0_b")
   public WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement error_mesaj;










}
