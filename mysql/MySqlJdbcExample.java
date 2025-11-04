package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlJdbcExample {
	// private static final String URL =
	// "jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC&useSSL=false";
	// private static final String USER = "root";
	// private static final String PASS = "gellu@hima24";
	private static Connection connection = null;

	public static void main(String[] args) throws Exception {
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			// step-1 class loader
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 connection establishment
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "gellu@hima24");
			// step-3 create statement
			statement = connection.createStatement();
			// step-4 Execute query
			resultSet = statement.executeQuery("SELECT * FROM designation");
			// step-5 process results
			while (resultSet.next()) {
				int code = resultSet.getInt("code");
				String title = resultSet.getString("title").trim();
				System.out.println("code:" + code + "| title:" + title);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("error message" + e.getMessage());
		} catch (SQLException s) {
			System.out.println("error message" + s.getMessage());
		} finally {
			resultSet.close();
			statement.close();
			connection.close();

		}
	}
}