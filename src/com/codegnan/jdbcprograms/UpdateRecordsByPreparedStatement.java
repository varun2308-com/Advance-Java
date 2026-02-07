package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdateRecordsByPreparedStatement {
	
	static final String url = "jdbc:mysql://localhost:3306/varun_advjava";
    static final String username = "root";
    static final String password = "123456";

	public static void main(String[] args) {
		String sqlQuery = "update employee set eno = ? where eno = ?";
		try(Connection connection =
				DriverManager.getConnection(url, username, password);
				PreparedStatement pst = connection.prepareStatement(sqlQuery)) {
			
			pst.setInt(1, 7);   
			pst.setInt(2, 100);  
			
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1) {
				System.out.println(rowsAffected + " row(s) updated successfully");
			} else {
				System.out.println("updation failure");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

/*package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdateRecordsByPreparedStatement {
	
	static final String url = "jdbc:mysql://localhost:3306/varun_advjava";
    static final String username = "root";
    static final String password = "123456";

	public static void main(String[] args) {
		String sqlQuery = "update employee set ename = ?, esal = ?, eaddr = ? where eno = ?";
		try(Connection connection =
				DriverManager.getConnection(url, username, password);
				PreparedStatement pst = connection.prepareStatement(sqlQuery)) {
			pst.setString(1,  "vijaykumar");
			pst.setDouble(2, 5000);
			pst.setString(3, "hyderabad");
			pst.setInt(4, 100);            
			 
			
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1) {
			System.out.println(rowsAffected + " row(s) updated successfully");
			} else {
				System.out.println("updation failure");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}*/

