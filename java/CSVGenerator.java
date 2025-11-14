package de.zeroco.csv;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVGenerator {
	public static void main(String[] args) {
		try {
			toGenerateCSV(Constants.FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void toGenerateCSV(String filePath) throws IOException {
		FileWriter fw = new FileWriter(filePath);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Class,Name,Gender,DateOfBirth");
		bw.newLine();
		System.out.println("Class,Name,Gender,DateOfBirth");
		for (int i = 0; i < 10; i++) {
			int classNum = i + 1;
			int minAge = Constants.CLASS_AGE_RANGE[i][0];
			int maxAge = Constants.CLASS_AGE_RANGE[i][1];
			int totalStudents = ZCUtil.getRandomNumber(Constants.MIN_STRENGTH, Constants.MAX_STRENGTH);
			System.out.println("class " + classNum + " : " + totalStudents + " Students");
			for (int j = 0; j < totalStudents; j++) {
				String gender = ZCUtil.getRandomGender();
				String name = ZCUtil.getRandomName(gender);
				String dateOfBirth = ZCUtil.getRandomDOB(minAge, maxAge);
				// Map<String, Object> student = ZCMap.createStudentMap(classNum, gender, name,
				// dateOfBirth);
				ZCMap student = new ZCMap();
				student.put("Class", classNum);
				student.put("Name", name);
				student.put("Gender", gender);
				student.put("DateOfBirth", dateOfBirth);
				System.out.println(student.get("Class") + "," + student.get("Name") + "," + student.get("Gender") + ","
						+ student.get("DateOfBirth"));
				bw.write(student.get("Class") + "," + student.get("Name") + "," + student.get("Gender") + ","
						+ student.get("DateOfBirth"));
				bw.newLine();
			}
		}
		bw.close();
		System.out.println("written data into CSV");
	}
}