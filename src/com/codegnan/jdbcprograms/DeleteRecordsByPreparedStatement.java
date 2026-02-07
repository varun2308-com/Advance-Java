package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DeleteRecordsByPreparedStatement {
	
	static final String url = "jdbc:mysql://localhost:3306/varun_advjava";
    static final String username = "root";
    static final String password = "123456";

	public static void main(String[] args) {
		String sqlQuery = "delete from employee where eno = ?";
		try(Connection connection =
				DriverManager.getConnection(url, username, password);
				PreparedStatement pst = connection.prepareStatement(sqlQuery)) {
			
			pst.setInt(1, 444);            
			 
			
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1) {
			System.out.println(rowsAffected + " row(s) deleted successfully");
			} else {
				System.out.println("delition failure");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}