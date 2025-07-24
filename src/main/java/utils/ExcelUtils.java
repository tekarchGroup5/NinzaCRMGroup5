package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static List<Map<String, String>> getTestData(String filePath, String sheetName) {
		List<Map<String, String>> allData = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = headerRow.getPhysicalNumberOfCells();

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				Map<String, String> rowData = new LinkedHashMap<>();
				for (int j = 0; j < colCount; j++) {
					Cell headerCell = headerRow.getCell(j);
					Cell valueCell = row.getCell(j);

					String key = headerCell.getStringCellValue();
					String value = getCellValueAsString(valueCell);
					rowData.put(key, value);
				}
				allData.add(rowData);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return allData;
	}

	private static String getCellValueAsString(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString(); // Customize date format if needed
			} else {
				double value = cell.getNumericCellValue();
				return String.valueOf(value % 1 == 0 ? (int) value : value);
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}
	}
}
