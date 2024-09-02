package com.learnJdbc2;

import java.sql.*;
import java.util.Scanner;

public class EmployeeJdvc {

	// insertation
	public static void insert(Statement smt)throws Exception
	{
		String insertQuery = "INSERT INTO EMPLOYEE VALUES(1,'AJAY',30000),(2,'ANKIT',45000),(3,'AMIT',45000)";
		// CALLING THE INSERT QUERY
					smt.executeUpdate(insertQuery);
					System.out.println("row is inserted");
	}

	// update
	public static void update(Statement smt) throws Exception
	{
		String updateQuery = "UPDATE EMPLOYEE SET SALARY=65000 WHERE ID=3";
		smt.executeUpdate(updateQuery);
		System.out.println("update in table completed");
	}

	// DELETING
	public static void delete(Statement smt)throws Exception
	{
		String deleteQuery = "DELETE FROM EMPLOYEE WHERE ID=2";
		smt.executeUpdate(deleteQuery);
		System.out.println("delete in table completed");
		
	}

	public static void select(Statement smt)throws Exception
	{
		String selectQuery = "SELECT * FROM EMPLOYEE";
		ResultSet rs=smt.executeQuery(selectQuery);
		System.out.println("data in table");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
	}

	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			String url = "jdbc:mysql://localhost:3306/kodnest";
			String username = "root";
			String password = "Raju@12345";

			// Establishing the connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection is establish at" + con);

			// creating the statement using connection
			Statement smt = con.createStatement();
			
			while(true) {
				System.out.println("1 for insert ,2 for update, 3 for delete, 4 for select any other input to terminate");
				int choice=sc.nextInt();
				if(choice==1) {
					insert(smt);
				} else if(choice==2){
					update(smt);
				}else if(choice==3) {
					delete(smt);
					
				}else if(choice==4) {
					select(smt);
				}
				else {
					System.out.println("incorrect input");
		        	 System.exit(0);
				}
}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
				
	       
        	  
			