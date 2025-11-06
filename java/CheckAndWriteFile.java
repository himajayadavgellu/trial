package com.zerocode.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CheckAndWriteFile {

	public static void checkAndWriteFile(String filePath, String data) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		} else {
			System.out.println("File already exists: " + file.getName());
		}
		FileWriter writer = new FileWriter(file);
		writer.write(data);
		writer.close();
		System.out.println("Data written successfully to file.");
	}

	public static void main(String[] args) {
		try {
			String Path = "C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\sample.txt";
			String text = "Hi, Hello, Iam from Hyderabad. How are you?";
			checkAndWriteFile(path, text);
		} catch (IOException e) {
			System.out.println("Error:" + getMessage());
		}
	}
}
