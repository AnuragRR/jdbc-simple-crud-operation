package com.jspider.jdbc_simple_crud_operation.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsertController {
	public static void main(String[] args) {
		Connection connection = null;

		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-10am";
			String user = "root";
			String pass = "root";

			// getConnection Method
			connection = DriverManager.getConnection(url, user, pass);
			
			// Step3- Create Statement
			Statement statement = connection.createStatement();
			
			//Step4- ExecuteQuery
			String insertStudentQuery="insert into student values(2,'Rahul','abc@gmail.com',8766291986)";
			statement.execute(insertStudentQuery);
			System.out.println("Successfull");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//ctrl+shift+f