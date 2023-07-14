package com.jspiders.program1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 
{

	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3307?user=root&password=12345";
		String query="insert into test.studentinfo values('nari','yyyy',45)";
		try {
			Connection connection=DriverManager.getConnection(url);
			System.out.println("step 1");
			
			connection.close();
			System.out.println("step 5");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		

	}

}
