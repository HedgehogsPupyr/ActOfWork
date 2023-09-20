package ActOfWork.ActOfWork.Service;


import ActOfWork.ActOfWork.models.Act;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.ArrayList;




public class ReWriteTemplateService {

    public byte[]  rewRiteFile (ArrayList<Act> templ) throws IOException {

        File file = new File("/Users/igogor/Desktop/Java/PDF/Template.xlsx");
        // Read XSL file
    FileInputStream inputStream = new FileInputStream(file);

        // Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        inputStream.close();

        // Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);


        for (Act i : templ) {

            XSSFCell cell = sheet.getRow(0).getCell(0);
            cell.setCellValue("Объект капитального строительства:" + i.getObject());

            XSSFCell cell2 = sheet.getRow(2).getCell(0);
            cell2.setCellValue("Застройщик (технический заказчик, эксплуатирующая организация или региональный оператор:" +
                    i.getCustomer());

            XSSFCell cell3 = sheet.getRow(4).getCell(0);
            cell3.setCellValue("Лицо, осуществляющее строительство:" + i.getBuilder());

            XSSFCell cell4 = sheet.getRow(6).getCell(0);
            cell4.setCellValue("Лицо, осуществляющее подготовку проектной документации" + i.getArchitect());

            XSSFCell cell5 = sheet.getRow(12).getCell(1);
            cell5.setCellValue(i.getNumber_of_act());

            XSSFCell cell6 = sheet.getRow(12).getCell(9);
            cell6.setCellValue(i.getDate());

            XSSFCell cell7 = sheet.getRow(14).getCell(0);
            cell7.setCellValue(i.getTechnical_supervision());

            XSSFCell cell8 = sheet.getRow(17).getCell(0);
            cell8.setCellValue(i.getBuilder_face());

            XSSFCell cell9 = sheet.getRow(20).getCell(0);
            cell9.setCellValue(i.getBuilder_supervision());

            XSSFCell cell10 = sheet.getRow(23).getCell(0);
            cell10.setCellValue(i.getArchitect_face());

            XSSFCell cell11 = sheet.getRow(26).getCell(0);
            cell11.setCellValue(i.getBuilder_stroy());

            XSSFCell cell12 = sheet.getRow(29).getCell(0);
            cell12.setCellValue(i.getAnother_face());

            XSSFCell cell13 = sheet.getRow(31).getCell(8);
            cell13.setCellValue(i.getBuilder_short());

            XSSFCell cell14 = sheet.getRow(35).getCell(0);
            cell14.setCellValue(i.getJob());

            XSSFCell cell16 = sheet.getRow(38).getCell(0);
            cell16.setCellValue(i.getProject());

            XSSFCell cell17 = sheet.getRow(41).getCell(0);
            cell17.setCellValue(i.getMaterial());

            XSSFCell cell18 = sheet.getRow(44).getCell(0);
            cell18.setCellValue(i.getDocks());

            XSSFCell cell19 = sheet.getRow(46).getCell(4);
            cell19.setCellValue(i.getDate_start());

            XSSFCell cell20 = sheet.getRow(47).getCell(4);
            cell20.setCellValue(i.getDate_end());

            XSSFCell cell21 = sheet.getRow(49).getCell(0);
            cell21.setCellValue(i.getDocks_project());

            XSSFCell cell22 = sheet.getRow(52).getCell(0);
            cell22.setCellValue(i.getNext_work());

            XSSFCell cell23 = sheet.getRow(59).getCell(0);
            cell23.setCellValue(i.getTechnical_supervision_name());

            XSSFCell cell24 = sheet.getRow(62).getCell(0);
            cell24.setCellValue(i.getBuilder_face_name());

            XSSFCell cell25 = sheet.getRow(65).getCell(0);
            cell25.setCellValue(i.getBuilder_supervision_name());

            XSSFCell cell26 = sheet.getRow(68).getCell(0);
            cell26.setCellValue(i.getArchitect_face_name());

            XSSFCell cell27 = sheet.getRow(71).getCell(0);
            cell27.setCellValue(i.getBuilder_stroy_name());

            XSSFCell cell28 = sheet.getRow(73).getCell(0);
            cell28.setCellValue(i.getAnother_face_name1());


            }


        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
        } finally {
            bos.close();
        }
        byte[] bytes = bos.toByteArray();


        return bytes;

    }

}

