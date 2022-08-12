package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreInsertScanDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb";
		String username="root";
         String password="root";
         Connection connection=null;
         PreparedStatement PreparedStatement=null;
        Scanner scanner=new  Scanner(System.in);
	
				try {
					connection =DriverManager.getConnection(url,username,password);
					String sql="insert into food values(?,?,?,?)";
					PreparedStatement=connection.prepareStatement(sql);
					
					 for(int i=0;i<2;i++) {
						 System.out.println("Enter food name");
						 String name=scanner.next();
						 System.out.println("Enter food id");
						 int food_id=scanner.nextInt();
						 System.out.println("Enter food  type  ");
						 String type =scanner.next();
						 System.out.println("Enter cost");
						 float cost=scanner.nextFloat();
						 
						 PreparedStatement.setString(1, name);
						 PreparedStatement.setInt(2, food_id);
						 PreparedStatement.setString(4, type);
						 PreparedStatement.setFloat(3,cost);
						 PreparedStatement.execute();
					 }
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(connection!=null)
							connection.close();
						if(PreparedStatement!=null)
							PreparedStatement.close();
					}catch(SQLException e) {
				}
	}

	}
}

	
