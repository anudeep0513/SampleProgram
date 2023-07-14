package com.jspiders.program2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3307?user=root&password=12345";
		
		String query="insert into test.studentinfo values(?,?,?)";
		
		try 
		{
			Connection con=DriverManager.getConnection(url);
			System.out.println("step 1");
			
			PreparedStatement ps=con.prepareStatement(query);
			System.out.println("step 2");
			
			Scanner scan=new Scanner(System.in);
			System.out.println("enter rollnum");
			String rollnum=scan.next();
			ps.setString(1,rollnum);
			
			System.out.println("enter name");
			String name=scan.next();
			ps.setString(2, name);
			
			System.out.println("enter marks");
			double marks=scan.nextDouble();
			ps.setDouble(3, marks);
			
			ps.executeUpdate();
			System.out.println("step 3");
			
			con.close();
			System.out.println("step 5");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
