package com.learnJdbc2;
import java.sql.*;
import java.util.Scanner;

public class EmployeeJdbc2 {
	public static void  insert(Connection con) throws Exception
	{
		String query = "INSERT INTO EMPLOYEE VALUES(?,?,?)";//where value is inserted use'?' called placeholder
	System.out.println("enter id name and salary");
	Scanner sc=new Scanner(System.in);
	int id=sc.nextInt();
	String name=sc.next();
	int salary=sc.nextInt();
	//preparing the connection ststement
	PreparedStatement psmt=con.prepareStatement(query);
	//completing the query to be executed
	psmt.setInt(1,id);//psmt.setInt(placeholder index,value) mtlb pahle ? me  id pass hoga
	psmt.setString(2,name);//psmt.setInt(placeholder index,value)mtlb dusra ? me  name pass hoga
	psmt.setInt(3,salary);//psmt.setInt(placeholder index,value)mtlb third ? me  salary pass hoga
	
	psmt.executeUpdate();
	System.out.println("row is inserted");
	}
	public static void  update(Connection con) throws Exception
	{
		String query = "UPDATE  EMPLOYEE SET SALARY=? WHERE ID=?";//where value is inserted use'?' called placeholder
	System.out.println("enter salary and id to be updated");
	Scanner sc=new Scanner(System.in);
	
	int salary=sc.nextInt();
	int id=sc.nextInt();
	//preparing the connection ststement
	PreparedStatement psmt=con.prepareStatement(query);
	//completing the query to be executed
	psmt.setInt(1,salary);//psmt.setInt(placeholder index,value) mtlb pahle ? me  salary pass hoga
	
	psmt.setInt(2,id);//psmt.setInt(placeholder index,value)mtlb third ? me  id pass hoga
	
	psmt.executeUpdate();
	System.out.println("row is updated");
	}
	public static void  delete(Connection con) throws Exception
	{
		String query = "DELETE FROM EMPLOYEE WHERE ID=?";//where value is inserted use'?' called placeholder
	System.out.println("enter id TO BE deleted");
	Scanner sc=new Scanner(System.in);
	int id=sc.nextInt();
	
	//preparing the connection ststement
	PreparedStatement psmt=con.prepareStatement(query);
	//completing the query to be executed
	psmt.setInt(1,id);//psmt.setInt(placeholder index,value) mtlb pahle ? me  id pass hoga
	
	
	psmt.executeUpdate();
	System.out.println("row is deleted");
	}

	public static void  select(Connection con) throws Exception
	{
		String query = "SELECT * FROM EMPLOYEE WHERE ID=?";//where value is inserted use'?' called placeholder
	System.out.println("enter id TO BE SELECTED");
	Scanner sc=new Scanner(System.in);
	int id=sc.nextInt();
	
	//preparing the connection ststement
	PreparedStatement psmt=con.prepareStatement(query);
	//completing the query to be executed
	psmt.setInt(1,id);//psmt.setInt(placeholder index,value) mtlb pahle ? me  id pass hoga
	
		ResultSet rs=psmt.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
	}
	
	}
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			String url = "jdbc:mysql://localhost:3306/kodnest";
			String username = "root";
			String password = "Raju@12345";// username and password can also be taken from input bu using next()

			// Establishing the connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection is establish at" + con);

						
			while(true) {
				System.out.println("1 for insert ,2 for update, 3 for delete, 4 for select any other input to terminate");
				int choice=sc.nextInt();
				if(choice==1) {
					insert(con);
				} else if(choice==2){
					update(con);
				}else if(choice==3) {
					delete(con);
					
				}else if(choice==4) {
					select(con);
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

