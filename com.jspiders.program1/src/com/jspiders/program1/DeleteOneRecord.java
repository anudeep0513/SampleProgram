package com.jspiders.program1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteOneRecord {

	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3307?user=root&password=12345";
		   String query="delete from test.userinfo where name=?";
		   
		   try {
			Connection con=DriverManager.getConnection(url);
			
			PreparedStatement ps=con.prepareStatement(query);
			
			Scanner scan=new Scanner(System.in);
			System.out.println("enter name to delete record");
			String name=scan.next();
			ps.setString(1,name);
			ps.executeUpdate();
			System.out.println("deactivated that account");
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }

	}

}
