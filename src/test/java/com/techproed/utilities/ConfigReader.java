package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //Bu class'in amaci, configuration.properties dosyasindaki verileri(test data) okumaktir.

    //create Properties instance
    private static Properties properties; // Java.util'den import ettik!!!
    //FileInputStream objesini create edip kullanarak,bir dosya aciyoruz
    //Properties'i bu dosyaya yukluyoruz //   // Java.util'den import edecegiz Config dosyasini indirmek icin
    //Daha sonra properties dosyasini okuyacagiz.

    //baslatmak icin static blok olusturduk.

    static {                    // path'i configuration.properties file saga tikla copy+absolute path'den!!!
        String path = "configuration.properties";  // path'ini aldik kisalttik normalde alttaki gibiydi:
        try {                      //C:\Users\ekrem\IdeaProjects\mytestNGframework\configuration.properties
            FileInputStream file = new FileInputStream(path);  // bu dosya yuklemek icin!
            properties = new Properties(); // (dosyayi yuklemek icin!!)
            properties.load(file);  // (dosyayi yuklemek icin!!)
        } catch (Exception e) {
            //System.out.println("Dosya bulunamadi!"); // eklenebilir
            e.printStackTrace();
        }
    }
    //Okumak icin static bir metod olusturalim.
    //Bu metod kullanici anahtar kelimeyi girdiginde(key) , value return eder.
    public static String getProperty(String key){
        return properties.getProperty(key);
    } // bu methodla data okunur!


      // Bu bir ornektir!
     // public static void main(String[] args){
    //     System.out.println(properties.getProperty("test_email")); //koseqq@gmail.com okuyor!!!
    //        }

   }

