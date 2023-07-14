package com.jspiders.program1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;


public class LoginProg {

	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3307?";
		String user="root";
		String password="12345";
		
		String query="select name from test.userinfo where phone=? && password=?";
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(query);
			Scanner scan= new Scanner(System.in);
			System.out.println("enter phone");
			String phone=scan.next();
			ps.setString(1, phone);
			
			Random ran=new Random();
			int otp=ran.nextInt(10000);
			if(otp<1000)
			{
				otp=otp+1000;
			}
			System.out.println("otp is "+ otp);
			Scanner scan1=new Scanner(System.in);
			System.out.println("enter otp to verify");
			int userotp=scan1.nextInt();
			if(userotp==otp)
			{
				System.out.println("otp is verified and conti----");
			System.out.println("enter password");
			String userpassword=scan.next();
			ps.setString(2,userpassword);
			ResultSet resultset=ps.executeQuery();
			
			if(resultset.next())
			{
				System.out.println("login success");
				String name=resultset.getString("name");
				System.out.println("welcome "+ name);
			}
			else
			{
				System.out.println("login unsuccess");
			}
			}
			else
			{
				System.out.println("otp is not verified so unable to proceed");
			}
			con.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
