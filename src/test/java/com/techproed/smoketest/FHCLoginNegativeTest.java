package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class FHCLoginNegativeTest extends TestBase {

    @Test(groups = "group test1")
    public void gecersizUsername(){ // username yanlis!!
        driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager5");
        fhcLoginPage.password.sendKeys("man1ager2!");
        fhcLoginPage.loginButton.click();

        // Wait ihtiyac olusra kullanilacak
       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
       // Assert.assertTrue(tryAgain.isDisplayed());

         Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
        //Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please")); //Alternatif bu!

    }
    @Test
    public void gecersizPassword() { // pasword yanlis!!
        driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("man5ager5!");
        fhcLoginPage.loginButton.click();

        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }

    @Test(groups = "group test1")
    public void gecersizData() {// username and password yanlis!!
        driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager5");
        fhcLoginPage.password.sendKeys("man5ager5!");
        fhcLoginPage.loginButton.click();

        //Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please")); //Alternatif bu!
    }



}
