package com.tka.utilities.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
		public static XSSFWorkbook workbook;
		public static XSSFSheet sheet;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static FileInputStream fis;
		
	public static String getcellvalue(String sheetname, int row, int col){
			
			try {
				fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Book1.xlsx");
				workbook = new XSSFWorkbook(fis);
				sheet= workbook.getSheet(sheetname);
				cell= sheet.getRow(row).getCell(col);
				
				String cellValue ="";
				
				switch (cell.getCellType()) {
	            case STRING:
	                cellValue = cell.getStringCellValue();
	                break;
	            case NUMERIC:
	                // Convert numeric value to String
	                cellValue = String.valueOf((long) cell.getNumericCellValue());
	                break;
	            case BOOLEAN:
	                cellValue = String.valueOf(cell.getBooleanCellValue());
	                break;
	            case BLANK:
	                cellValue = "";
	                break;
	            default:
	                throw new IllegalStateException("Unexpected cell type: " + cell.getCellType());
	        }
				
				workbook.close();
				
				return cellValue;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return " ";
			}
		}
		
	
	public static int getRowCount(String sheetname) {
		try {
			fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Book1.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet= workbook.getSheet(sheetname);
			
			int row = sheet.getLastRowNum()+1;
			
			workbook.close();
			
			return row;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
		
	}
	public static int getColCount(String sheetname) {
		try {
			fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Book1.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet= workbook.getSheet(sheetname);
			
			int col =sheet.getRow(3).getLastCellNum();
			
			workbook.close();
			
			return col;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
		
	}
	
	public static String getStringData(int sheetIndex, int row, int col) {
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public static double getNumericdata(String sheetName, int row, int col) {
		return workbook.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public static void main(String[] args) {
		
		int row = ExcelReader.getRowCount("Sheet1");
		int col = ExcelReader.getColCount("Sheet1");
		System.out.println(row+" "+col);
		String[][] data = new String [row-3] [col];
		
		for(int i=3;i<row; i++) {
			for(int j=0;j<col;j++) {
				String text=ExcelReader.getcellvalue("Sheet1", i, j);
				data[i-3][j] =text;
				//System.out.println(text);
			}
		}
		
		
	}

}
