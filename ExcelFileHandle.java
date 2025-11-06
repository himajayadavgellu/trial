package com.zerocode.files;

import java.io.*;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileHandle {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\excel2.xlsx";
		String filePathNew = "C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\Studentdata.xlsx";
		try {
			System.out.println(readExcelFile(filePath));
			System.out.println(writeExcelFile(filePathNew));
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static String readExcelFile(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		String result = "";
		for (Row row : sheet) {
			for (Cell cell : row) {
				result += cell.toString() + "\t";
			}
			result += "\n";
		}
		workbook.close();
		fis.close();
		return result;
	}

//	createSheet(String name) | getSheet(String name) | createRow(int rownum) | getRow(int rownum) | 
//	createCell(int column) | getCell(int column) | setCellValue(...) | autoSizeColumn(int column) | 
//	workbook.write(OutputStream) | workbook.close()
	public static String writeExcelFile(String filePathNew) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("StudentData");
		Row rowA = sheet.createRow(0);
		rowA.createCell(0).setCellValue("id");
		rowA.createCell(1).setCellValue("name");
		rowA.createCell(2).setCellValue("marks");
		Row rowB = sheet.createRow(1);
		rowB.createCell(0).setCellValue(1);
		rowB.createCell(1).setCellValue("talha");
		rowB.createCell(2).setCellValue(78);
		Row rowC = sheet.createRow(2);
		rowC.createCell(0).setCellValue(2);
		rowC.createCell(1).setCellValue("roshi");
		rowC.createCell(2).setCellValue(98);
		for (int i = 0; i <= 3; i++) {
			sheet.autoSizeColumn(i);
		}
		FileOutputStream out = new FileOutputStream(new File(filePathNew));
		workbook.write(out);
		out.close();
		workbook.close();
		return "data witten into excel";
	}
}
