package com.zerocode.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class WordCSVFile {

	public static void main(String[] args) {
		try {
			String data = readCSV("C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\samplecsv.csv");
			System.out.println(data);
			System.out.println(writeCSV("C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\output.csv"));
			System.out.println(readWordFile("C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\sample.docx"));
			System.out.println(writeWordFile("C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\sample2.docx"));
		} catch (IOException | CsvValidationException e) {
			System.out.println("Error reading CSV: " + e.getMessage());
		}
	}

	public static String readCSV(String filePath) throws IOException, CsvValidationException {
		StringBuilder content = new StringBuilder();
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				for (String cell : nextLine) {
					content.append(cell).append("\t"); // tab-separated
				}
				content.append("\n");
			}
		}
		return content.toString();
	}

	public static String writeCSV(String filePath) throws IOException {
		try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
			String[] header = { "ID", "Name", "Marks" };
			String[] row1 = { "1", "roshi", "95" };
			String[] row2 = { "2", "ahad", "89" };
			writer.writeNext(header);
			writer.writeNext(row1);
			writer.writeNext(row2);
		}
		return "Data successfully written to CSV file: " + filePath;
	}

	public static String readWordFile(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		try (XWPFDocument document = new XWPFDocument(fis)) {
			StringBuilder str = new StringBuilder();
			for (XWPFParagraph para : document.getParagraphs()) {
				str.append(para.getText()).append("\n");
			}
			fis.close();
			document.close();
			return str.toString();
		}
	}

	public static String writeWordFile(String filePath) throws IOException {
		try (XWPFDocument document = new XWPFDocument()) {
			XWPFParagraph para = document.createParagraph();
			XWPFRun run = para.createRun();
			run.setText("Hyderabad located in Telangana State");
			run.addBreak();
			run.setText("Telangana is a state in India");
			FileOutputStream fos = new FileOutputStream(filePath);
			document.write(fos);
			fos.close();
			document.close();
		}
		return "data written " + filePath;
	}
}
