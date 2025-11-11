package com.zerocode.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MySQLToExcel {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/reverselocations";
	private static final String USER = "root";
	private static final String PASS = "gellu@hima24";

	public static void main(String[] args) {
		String filePath = "C:\\Users\\GELLU HIMAJA YADAV\\Desktop\\importExcel.xlsx";
		try {
			exportToExcel(filePath);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void exportToExcel(String filePath) throws SQLException, IOException {
		String query = """
				 select city_name,city_code,district_name,district_code,state_name,
				 state_code,country_name,country_code from city c
				 inner join district d on c.city_id = d.city_id
				 inner join state s on s.district_id = d.district_id
				 inner join country co on co.state_id = s.state_id;
				""";
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("importExcel");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("city_name");
		row.createCell(1).setCellValue("city_code");
		row.createCell(2).setCellValue("district_name");
		row.createCell(3).setCellValue("district_code");
		row.createCell(4).setCellValue("state_name");
		row.createCell(5).setCellValue("state_code");
		row.createCell(6).setCellValue("country_name");
		row.createCell(7).setCellValue("country_code");
		int count = 1;
		while (resultSet.next()) {
			Row rowData = sheet.createRow(count++);
			rowData.createCell(0).setCellValue(resultSet.getString("city_name"));
			rowData.createCell(1).setCellValue(resultSet.getString("city_code"));
			rowData.createCell(2).setCellValue(resultSet.getString("district_name"));
			rowData.createCell(3).setCellValue(resultSet.getString("district_code"));
			rowData.createCell(4).setCellValue(resultSet.getString("state_name"));
			rowData.createCell(5).setCellValue(resultSet.getString("state_code"));
			rowData.createCell(6).setCellValue(resultSet.getString("country_name"));
			rowData.createCell(7).setCellValue(resultSet.getString("country_code"));
		}
		FileOutputStream out = new FileOutputStream(new File(filePath));
		wb.write(out);
		System.out.println("data written");
		out.close();
		resultSet.close();
		stmt.close();
		conn.close();
		wb.close();
	}
}
