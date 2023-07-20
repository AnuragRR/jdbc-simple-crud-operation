package com.jspider.jdbc_crud_operation_customer.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayCustomerController {
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
			String displayCustomerQuery="select * from customer";
			
			ResultSet resultSet = statement.executeQuery(displayCustomerQuery);
			
			while (resultSet.next()) {
			int id= resultSet.getInt("id");
			String name = resultSet.getString("name");
			String phone= resultSet.getString("phone");
			Date dob = resultSet.getDate("dob");
			
			System.out.println(id);
			System.out.println(name);
			System.out.println(phone);
			System.out.println(dob);
			}
			
			System.out.println(" Data Fetched Successfull!!!!!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
