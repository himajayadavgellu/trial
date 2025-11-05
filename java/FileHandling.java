package com.zerocode.files;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandling {

	public static void main(String[] args) {

		try {
			System.out.println(checkAndReadFile("C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\sample2.txt"));
			System.out.println(
					replacedWordInFile("C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\essay.txt", "Hyderabad", "Vijayawada"));
			String path = "C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\sample.txt";
			String text = "Hi, Hello, Iam from Hyderabad. How are you?";
			checkAndWriteFile(path, text);
			String filePath = "C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\excel2.xlsx";
			readExcelFile(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

	public static String checkAndReadFile(String fileName) throws IOException {
		File file = new File(fileName);
		String result = "";
		if (!file.exists()) {
			throw new FileNotFoundException("File does not exist!");
		}
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			;
			String line;
			System.out.println("File contents:");
			while ((line = br.readLine()) != null) {
				result += line + "\n";
			}
			br.close();
		}
		return result;
	}

	public static void checkAndWriteFile(String filePath, String data) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		} else {
			System.out.println("File already exists: " + file.getName());
		}
		FileWriter writer = new FileWriter(file);
		try (BufferedWriter buffWriter = new BufferedWriter(writer)) {
			;
			buffWriter.write(data);
//		writer.write(data);
		}
		writer.close();
		// buffWriter.close();
		System.out.println("Data written successfully to file.");
	}

	public static String replacedWordInFile(String filePath, String actualWord, String replacedWord)
			throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("file doesnot exist");
		}
		BufferedReader bufferReader = new BufferedReader(new FileReader(file));
		String line;
		StringBuffer result = new StringBuffer();
//		String result = "";
		while ((line = bufferReader.readLine()) != null) {
			result.append(line.replace(actualWord, replacedWord)).append("\n");
//			result += line.replaceAll(actualWord, replacedWord) +"\n";
		}
		bufferReader.close();
		BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file));
		bufferWriter.write(result.toString());
		bufferWriter.close();
		return result.toString();
	}

	public static void readExcelFile(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
	}
}
