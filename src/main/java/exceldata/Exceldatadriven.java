package exceldata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatadriven {

	public static void main(String args[]) throws IOException {

		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/config.properties");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int n = workbook.getNumberOfSheets();
			for (int i = 0; i < n; i++) {
				if (workbook.getSheetName(i).equals("New")) {
					XSSFSheet sheet = workbook.getSheetAt(i);
					
					Iterator<Row> rows = sheet.iterator();
					while (rows.hasNext()) {
						Row r = rows.next();
						if (r.equals(4)) {
							Iterator<Cell> c = r.cellIterator();
							while (c.hasNext()) {
								Cell cell = c.next();
								if(cell.getCellTypeEnum()==CellType.STRING) {
								

									System.out.println(cell.getStringCellValue());
									
								}
								else if(cell.getCellTypeEnum()==CellType.NUMERIC)
								{
									cell.getNumericCellValue();
								}
								else
								{
									cell.getDateCellValue();
								}
							}

						}
					}

				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
