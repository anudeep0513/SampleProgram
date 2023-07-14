package com.jspiders.program1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class ChangePWOTPV 
{
	public static void main(String[] args) 
	{
	   String url="jdbc:mysql://localhost:3307?user=root&password=12345";
	   String query="select phone from test.userinfo where phone=?";
	   
	   try {
		Connection con=DriverManager.getConnection(url);
		
		PreparedStatement ps=con.prepareStatement(query);
		
		Scanner scan=new Scanner(System.in);
		System.out.println("enter phone num");
		String phone1=scan.next();
		ps.setString(1,phone1);
		
		ResultSet resultset=ps.executeQuery();
		
		if(resultset.next())
		{
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
			String query2="update test.userinfo set phone=? where phone="+phone1;
			PreparedStatement ps2=con.prepareStatement(query2);
			Scanner scan2=new Scanner(System.in);
			System.out.println("enter new phone num");
			String newphone=scan2.next();
			ps2.setString(1, newphone);
			ps2.executeUpdate();
			System.out.println("phone num is updated");
			
			}
			else
			{
				System.out.println("otp is not verified");
			}
		}
		
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
