package com.jspiders.program1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsageOfCallStatm {

	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3307?user=root&password=12345";
		
		String callStoredProcedure="{call test.newPro1 (?,?)}";
		
		try {
			Connection con=DriverManager.getConnection(url);
			
			CallableStatement cs=con.prepareCall(callStoredProcedure);
			
			Scanner scan=new Scanner(System.in);
			System.out.println("enter empid");
			cs.setInt(1,scan.nextInt());
			
			System.out.println("enter empid");
			cs.setString(2, scan.next());
			
		//	System.out.println("enter empdept");
		//	cs.setString(3,scan.next());
			
			ResultSet rs=cs.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("empname");
				System.out.println(name);
			}
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		

	}

}
