package day14_ExcelRead_Write;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "/src/test/java/resources/Capitals";

        // FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim  WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);//

        //  Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("sayfa1");  //createsheet de denebilir.ama dosyamiz zaten var o yuzden creat etmeyecegiz

        //  Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(1);

        //  Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(2);

        System.out.println(cell);
    }
}
