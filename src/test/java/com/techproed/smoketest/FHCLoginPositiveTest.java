package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FHCLoginPositiveTest extends TestBase {

    @Test(groups = "group test1")
    public void positiveTestLogin(){
       driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("man1ager2!");
        fhcLoginPage.loginButton.click();

    }





}
