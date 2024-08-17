package com.student.manage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import com.mysql.cj.xdevapi.Statement;

public class Repository {
	
	
	public static Connection con;

	public static Connection CreateConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");		
			
			String user= "root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/student_manage";
			
			con = DriverManager.getConnection(url,user,password);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	
	public boolean InsertStudent(Student obj)
	{
		
		try {
			con = CreateConnection();
			String query= "insert into students values(?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, obj.getId());
			statement.setString(2, obj.getName());
			statement.setString(3, obj.getPhone());
			statement.setString(4, obj.getCity());
			
			if(statement.executeUpdate()>0)
				return true;
			else 
				return false;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean DeleteStudent(int sid)
	{
		
		try {
		con = CreateConnection();
		
		String query= "delete from students where id=?";
		PreparedStatement statement=con.prepareStatement(query);
		statement.setInt(1, sid);
		
		if(statement.executeUpdate()>0)
			return true;
		else
			return false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void DisplayAll()
	{
		
		try {
			con = CreateConnection();
			
			String query = "Select * from students";			
			Statement statement = con.createStatement();			
			ResultSet set = statement.executeQuery(query);
			
			System.out.println("\n-------------------------------------------------");
			System.out.println("Id\tName\tPhone  City");
			System.out.println("-------------------------------------------------\n");
			while(set.next())
			{
				System.out.printf("%d\t%s\t%s\t%s\n", set.getInt(1),set.getString(2),set.getString(3),set.getString(4));							
			}
			
			System.out.println("-------------------------------------------------\n");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean UpdateStudent(Student obj)
	{
		
		try {
		con = CreateConnection();
		String query="update students set name=?,phone=?,city=? where id=?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, obj.getName());
		statement.setString(2, obj.getPhone());
		statement.setString(3, obj.getCity());
		statement.setInt(4, obj.getId());
		
		if(statement.executeUpdate()>0)
			return true;
		else 
			return false;
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
