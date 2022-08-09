package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Day17_WebTables extends TestBase {
    //Bir class oluşturun : WebTables
    //login() metodun oluşturun ve oturum açın.
    //http://www.fhctrip.com/admin/HotelRoomAdmin
    //Username : manager2
    //Password : Man1ager2!

    //table() metodu oluşturun
    //Tüm table body’sinin boyutunu(size) bulun.
    //Table’daki başlıkları(headers) konsolda yazdırın.

    //printRows() metodu oluşturun
    //table body’sinde bulunan toplam satir(row) sayısını bulun.
    //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
    //4.satirdaki(row) elementleri konsolda yazdırın.

    //printCells() metodu oluşturun
    //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    //Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.

    //printColumns() metodu oluşturun
    //table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
    //5.column daki elementleri  konsolda yazdırın.



    //login() metodun oluşturun ve oturum açın.
    public void login(){
        //http://www.fhctrip.com/admin/HotelRoomAdmin
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin ");
        //Username : manager2
        //Password : Man1ager2!
        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("manager2");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//*[@id=\"add-form\"]/div[3]/button")).submit();

    }
    @Test
    //table() metodu oluşturun
    public void table() throws InterruptedException {
        login();

        // ONCE tbody'deki data'lari konsolda yazdirdik
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        //Thread.sleep(5000);
        //System.out.println(tbody.getText());Gordukten sonra kapatabiliriz

        //Tüm table body’sinin boyutunu(size) bulun. Kac tane hucre var (cell)
        List<WebElement>table = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("table dody size==> " + table.size());
        //Table’daki başlıkları(headers) konsolda yazdırın.
        List<WebElement> allHeaders = driver.findElements(By.tagName("th"));
        for (WebElement header:allHeaders) {
            System.out.print(header.getText()+" || ");
        }

    }

    @Test
    //printRows() metodu oluşturun
    public void printRows(){
        login(); /// login() methodundaki bilgileri tekrar yazmamak icin login() call ediliyor!!!
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("TABLE BODY'DE TOPLAM  " + driver.findElements(By.xpath("//tbody//tr")).size()+" TANE SATIR (ROW) VARDIR!");

        //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row:allRows) {
            System.out.println(row.getText());
        }
        //4.satirdaki(row) elementleri konsolda yazdırın.
       // WebElement row4 = driver.findElement(By.xpath("(//tbody//tr)[4]")); //Bu sekilde de oluyor!!!
       // System.out.println(row4.getText());

        List<WebElement> elementRow4 = driver.findElements(By.xpath("//tr[4]//td"));
        for(WebElement element : elementRow4){
            System.out.print(element.getText()+" || ");
        }


    }

    @Test
    //printCells() metodu oluşturun
    public void printCells(){
       login();
        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println("Tabloda toplam " + driver.findElements(By.xpath("//tbody//td")).size()+" tane hucre(cell) vardir");

        //Table body'sinde bulunan hücreleri(cells)  konsolda yazdırın.
        List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement cell : allCells) {
            System.out.println(cell.getText());
        }

    }


    @Test
    //printColumns() metodu oluşturun
    public void printColumns(){
        login();
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        System.out.println("Tabloda toplam: "+driver.findElements(By.xpath("//tr[3]//td")).size()+" tane sutun (column) vardir");

        //Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.  // sadece xpath("//th") yazabiliriz de!!!!
        List<WebElement> allColumns = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement column:allColumns){
            System.out.println(column.getText());
        }
        //5.column daki elementleri  konsolda yazdırın.
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5]"));
        for(WebElement element:column5){
            System.out.println(element.getText());
        }

    }

    //Bir metod oluşturun : printData(int row, int column);
    //Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
    //Baska bir metod daha oluşturun: printDataTest();
    //Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır

    @Test
    //Bir metod oluşturun : printData(int row, int column);
    public void printData(int row, int column){
        //Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
        //code'lari bu method'un icine yazacagiz
        // //tbody//tr[8]//td[3] seklindeydi...
        //dinamik bir xpath yazalim
        String xpath = "//tbody//tr[" +row+ "]//td[" +column+ "]";
        //elementleri xpath'i kullanarak bulalim
        WebElement data = driver.findElement(By.xpath(xpath));
        //data lari yazdiralim
        System.out.println(data.getText());

    }

    @Test
    //Baska bir metod daha oluşturun: printDataTest();
    public void printDataTest(){
        login();
        printData(3,3);
        printData(7,5);
        printData(8,3);
        printData(5,2);
        printData(9,5);

    }


}
