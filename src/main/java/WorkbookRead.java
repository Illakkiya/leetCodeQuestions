import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkbookRead {
    public static void main(String[] args) {
        try {
            //            InputStream input = new FileInputStream(System.getProperty("user.dir")+"/patient_records.xlsx");
            InputStream input = WorkbookRead.class.getResourceAsStream("/patient_records.xlsx");
            Workbook workbook = new XSSFWorkbook(input);
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            // Find the specific patient (for example, by ID)
            int targetRow = findPatientRow(sheet, "patient_id");

            if (targetRow != -1) {
                Row row = sheet.getRow(targetRow);

                if (row != null) {
                    // Alter the table details (for example, update a cell value)
                    Cell cell = row.getCell(2); // Assuming the detail to be updated is in the third cell
                    if (cell != null) {
                        cell.setCellValue("New value");

                        // Save changes
                        FileOutputStream outFile = new FileOutputStream("patient_records_updated.xlsx");
                        workbook.write(outFile);
                        outFile.close();
                    } else {
                        System.out.println("Cell not found in the row.");
                    }
                } else {
                    System.out.println("Row is null.");
                }
            } else {
                System.out.println("Patient not found.");
            }

            workbook.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findPatientRow(Sheet sheet, String targetId) {
        for (Row row : sheet) {
            int rowSize = row.getLastCellNum();
            for (int i = 0; i < rowSize; i++) { // Assuming ID is in the first cell
                Cell cell = row.getCell(i);
                if (cell != null && cell.getStringCellValue().equals(targetId)) {
                    return row.getRowNum();
                }
            }
        }
        return -1; // Patient not found
    }
}
