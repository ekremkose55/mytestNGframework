package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDriverTest {

    @Test
    public void gecersizPassword(){
        //driver yerine ==> Driver.getDriver()
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));//driver ile Driver.getDriver() degistik!!
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());//driver ile Driver.getDriver() degistik!!
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }


}
