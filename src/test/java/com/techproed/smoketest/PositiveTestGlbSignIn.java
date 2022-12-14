package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class PositiveTestGlbSignIn {
    @Test
    public void positiveTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_signin_url"));
        GlbSignInPage glbSignInPage = new GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignInPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignInPage.loginButton.click();

    }



}
