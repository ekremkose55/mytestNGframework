package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void writeExcel() throws IOException {
        //Data okuyacagimiz dosyanin path'ini yazdik
        String path =  ".\\src\\test\\resources\\ulkeler1.xlsx"; // \\src oncesini siliyor ve nokta koyuyoruz
        // workbook'u test package'ti icinde olusturdugumuz (test+saga tik+new+director) resources file'sine tasidik
        // daha sonra workbook'un path'ini(workbook+saga tik + copy + absolute path) eski path ile degistirdik

        //Dosyayi(file) acalim
        FileInputStream fileInput = new FileInputStream(path);   //file'i acalim
        Workbook workbook = WorkbookFactory.create(fileInput);   //workbook'u acalim
        Sheet sheet = workbook.getSheetAt(0);  //1.sheet'e git
        Row row = sheet.getRow(0);  //1.row'a git  (basliklar)
        Cell cell = row.getCell(1);
        System.out.println(cell);
        System.out.println(row.getCell(2));


        FileOutputStream fileOutput = new FileOutputStream(path);

        Cell cell4 = row.createCell(3);  // create cell
        cell4.setCellValue("NUFUS");

        Cell cell5 = row.createCell(4);
        cell5.setCellValue("YUZOLCUMU");

//        row.removeCell(cell5);
//        row.removeCell(cell4);


        workbook.getSheetAt(0).getRow(1).createCell(2).setCellValue("82.000.000");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("11.000.000");
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("83.000.000");

        workbook.write(fileOutput);  //cell'e veri yazar ve kaydeder.
        fileOutput.close();
        fileInput.close();
        workbook.close();

    }
}
