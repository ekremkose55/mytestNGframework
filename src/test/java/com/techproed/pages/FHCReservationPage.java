package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FHCReservationPage {

    WebDriver driver;

    public FHCReservationPage(WebDriver driver) {
        this.driver = driver;
        // page object'lerini baslatmak icin PageFactory.initElements() kullaniyoruz
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="IDUser")
    public WebElement idUser;

    @FindBy(id="IDHotelRoom")
    public WebElement idHotelRoom;

    @FindBy(id="Price")
    public WebElement price;

    @FindBy(id="DateStart")
    public WebElement dateStart;

    @FindBy(id="DateEnd")
    public WebElement dateEnd;

    @FindBy(id="AdultAmount")
    public WebElement adultAmount;

    @FindBy(id="ChildrenAmount")
    public WebElement childrenAmount;

    @FindBy(id="ContactNameSurname")
    public WebElement surname;

    @FindBy(id="ContactPhone")
    public WebElement phone;

    @FindBy(id="ContactEmail")
    public WebElement email;

    @FindBy(id="Notes")
    public WebElement notes;

    @FindBy(id="Approved")
    public WebElement isApproved;

    @FindBy(id="IsPaid")
    public WebElement isPaid;

    @FindBy(id="btnSubmit")
    public WebElement saveButton;

    @FindBy(className = "bootbox-body")
    public WebElement succes_mesaj;
















}


