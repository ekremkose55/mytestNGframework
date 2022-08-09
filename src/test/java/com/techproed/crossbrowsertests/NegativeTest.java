package com.techproed.crossbrowsertests;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class NegativeTest extends TestBaseCross {
    @Test()
    public void gecersizPass() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("http://www.fhctrip.com/Account/Logon");
        WebElement userNameBox=driver.findElement(By.id("UserName"));
        WebElement passwordBox=driver.findElement(By.id("Password"));
        WebElement loginButton=driver.findElement(By.id("btnSubmit"));
        userNameBox.sendKeys("manager2");
        passwordBox.sendKeys("Man1ag");
        loginButton.click();
    }
    @Test()
    public void gecersizID(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("http://www.fhctrip.com/Account/Logon");
        WebElement userNameBox=driver.findElement(By.id("UserName"));
        WebElement passwordBox=driver.findElement(By.id("Password"));
        WebElement loginButton=driver.findElement(By.id("btnSubmit"));
        userNameBox.sendKeys("manag");
        passwordBox.sendKeys("Man1ager2!");
        loginButton.click();
    }
    @Test()
    public void gecersizIDvePass(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("http://www.fhctrip.com/Account/Logon");
        WebElement userNameBox=driver.findElement(By.id("UserName"));
        WebElement passwordBox=driver.findElement(By.id("Password"));
        WebElement loginButton=driver.findElement(By.id("btnSubmit"));
        userNameBox.sendKeys("manag");
        passwordBox.sendKeys("Man1ag");
        loginButton.click();
    }
}

//CROSS BROWSER TEST
//xml file -> TestBaseCross -> DriverCross
//xml file:  Selenium xml file'sa parameter olup olmadigini kontrol eder.
//           Eger bir parameter varsa onu olur(parameter="browser" value="firefox")
//TestBaseCross: Eger xml'de parameter="browser" varsa TestBaseCross patameter olarak browser value kullanir. Baglantiyi @Parameters("browser") annotation'i ile saglar.
//DriverCross: Driver'i kontrol eder ve arkasindan create eder.
//browser = browser == null ? ConfigReader.getProperty("browser") : browser;
//    Eger browser null ise onu configuration.properties'den al.
//    Eger browser null degil ise browser'i xml file'den al