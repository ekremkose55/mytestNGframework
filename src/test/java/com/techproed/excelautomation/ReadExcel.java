package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {  //Poor Obfuscation Implementation / Kötü Gizleme Uygulaması
    @Test
    public void readExcelFile() throws IOException {
        //Data okuyacagimiz dosyanin path'ini yazdik
        String path = "C:\\Users\\ekrem\\Desktop\\ulkeler.xlsx";

        //Dosyayi(file) acalim
        FileInputStream fileInputStream = new FileInputStream(path);// parametremiz de path'i yaziyoruz

        //fileInputStream kullanarak workbook'u (excel file) acalim
        // dependency eklemek zorundayiz! API (APACHE POI'den-mvnrepository.com dependency yukluyoruz
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //1. worksheet'e gidelim
        Sheet sheet = workbook.getSheetAt(0); //Excel'deki ilk sayfadir(sheet) index 0'dir

        //1. satira (row) gidelim
        Row row = sheet.getRow(0); // 1. satira gider
        Row row1 = sheet.getRow(1); // 1. satira gider

        // artik test data'larini(cell) okuyabiliriz
        Cell cell = row.getCell(0);

        System.out.println("1. Cell'deki data : "+cell);
        System.out.println("2. Cell'deki data: "+row.getCell(1));
        System.out.println("2. Satirdaki 2. data: "+row1.getCell(2));

        //Son row(satir) numarasini alalim
        int rowSayisi = sheet.getLastRowNum();  // son satiri belirledik

        int ulke = 0;
        for (int rowNum = 1 ; rowNum<= rowSayisi; rowNum++){
            String ulkeColomn = sheet.getRow(rowNum).getCell(ulke).toString();
            System.out.println(ulkeColomn);
        }

       // Path icin;
       // String path1 = "C:\\Users\\ekrem\\Desktop\\ulkeler.xlsx";
       // Dosyayi acmak icin
       // FileInputStream fileInputStream1 = new FileInputStream(path);
       // Workbook acmak icin
      //  Workbook workbook1 = WorkbookFactory.create(fileInputStream);
      //  Sheet yuklemek icin;
      //  Sheet sheet1 = workbook.getSheetAt(2);
     //   Row'a gitmak icin'
     //   Row row1 = sheet.getRow(3);
       // Cell'i almak icin'
      //  Cell cell1 = row1.getCell(8);
      //  System.out.println(cell);

        Row row2 = sheet.getRow(9);
        Cell cell2 = row2.getCell(2);
        System.out.println("Abd: " + cell2);  // kovboy

        // chain methodu
        System.out.println("ABD: " +workbook.getSheetAt(0).getRow(9).getCell(2)); // kovboy

        // chain methodu
        String kovboy = workbook.getSheetAt(0).getRow(9).getCell(2).toString(); // toString() ile string'e cevirdik
        System.out.println(kovboy);  // kovboy

        //Son row(satir) numarasini alalim
        int rowCount = sheet.getLastRowNum();
        System.out.println("Toplam row sayisi: " + rowCount);

        // Kullanilan satirlarin sayisisni nasil aliriz
        int physicalNumberOfRows =sheet.getPhysicalNumberOfRows();
        System.out.println("Toplam kullanilan row sayisi: " + physicalNumberOfRows);

        Map<String,String> ulkeler = new HashMap<>();
        int ulkeColumn = 0;
        int baskentColumn  = 1;
        for (int rowNum = 1 ; rowNum<= rowCount; rowNum++){
            String allUlke = sheet.getRow(rowNum).getCell(ulkeColumn).toString();
          //  System.out.print("ULKELER: " + allUlke+ " ");
            String  allBaskent = sheet.getRow(rowNum).getCell(baskentColumn).toString();
           // System.out.println("BASKENTLER: " + allBaskent);

            // hashmap olarak yazdiralim
        //     ulkeler.put(allUlke,allBaskent);

        }
         //  System.out.println(ulkeler);


    }
}
