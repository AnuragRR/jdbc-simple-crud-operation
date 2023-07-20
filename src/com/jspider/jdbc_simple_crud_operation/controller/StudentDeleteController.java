package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDeleteController {
	public static void main(String[] args) {
		Connection connection = null;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter student id to delete record");
		int id = scanner.nextInt();

		try {
			// step-1 load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-10am";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			// step-3 create statement
			Statement statement = connection.createStatement();

			// step-4 insert query
			String deleteStudentEmailQuery = "delete from student where id ="+id;
			
			int a= statement.executeUpdate(deleteStudentEmailQuery);
			if (a==1) {
				System.out.println("data deleted succesfully!!");
			} else {
				System.out.println("Id not found");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
 * execute => For insert
 * executeUpdate => for detele and update
 * executeQuery => for display
 */
 