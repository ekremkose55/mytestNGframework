package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignInPage {

    //Test Case-Homework
    //Global Trader Sign In Test.
    //Kullanici https://www.glbtrader.com/login.html sayfasina gitsin.
    //Sayfaya dogru ve yanlis veriler girerek sign in ozelligini test etsin.
    //1. pages paketinin altina bir page class olusturun : GlbHomePage
    //a. Page objelerini(webelement) bulun.
    //2. smoketest paketinin altina iki tane test classi olusturun :
    //● PositiveTestGlbSignIn
    //● NegativeTestGlbSignIn
    //=====Page Object Model kullanin======
    public GlbSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@value='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//strong")
    public  WebElement mesaj;



}
