package com.jspiders.program1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangePBEMail {

	public static void main(String[] args) 
	{
		 String url="jdbc:mysql://localhost:3307?user=root&password=12345";
		   String query="select password from test.userinfo where mail=?";
		   
		   try {
			Connection con=DriverManager.getConnection(url);
			
			PreparedStatement ps=con.prepareStatement(query);
			
			Scanner scan=new Scanner(System.in);
			System.out.println("enter mail id");
			String mail=scan.next();
			ps.setString(1,mail);
			
			ResultSet resultset=ps.executeQuery();
			
			if(resultset.next())
			{
				
				String query2="update test.userinfo set password=? where mail="+mail;
				PreparedStatement ps2=con.prepareStatement(query2);
				Scanner scan2=new Scanner(System.in);
				System.out.println("enter new password");
				String newpassword=scan2.next();
				ps2.setString(1, newpassword);
				ps2.executeUpdate();
				System.out.println("password is updated");
			}
			else
			{
				System.out.println("Given mail id was wrong");
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}

}
}
