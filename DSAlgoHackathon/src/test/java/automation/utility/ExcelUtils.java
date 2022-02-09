package automation.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	// Constructor - same as class name
	public ExcelUtils(String excelpath, String sheetname) {
		try {

			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetname);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getRowCount() {
		int rowCount = 0;
		rowCount = sheet.getPhysicalNumberOfRows();
		// System.out.println("Number of rows : " + rowCount);
		return rowCount;

	}

	public static int getColumnCount() {
		int colCount = 0;
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		// System.out.println("Number of rows : " + colCount);
		return colCount;
	}

	public String getCellDataString(int rownum, int colnum) {
		String cellData1 = "";
		cellData1 = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		System.out.println("CellValue1 : " + cellData1);
		return cellData1;
	}

	public static double getCellDataNumeric(int rownum, int colnum) {
		double cellData2 = 0;
		cellData2 = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		// System.out.println("CellValue2 : " + cellData2);
		return cellData2;
	}

}
