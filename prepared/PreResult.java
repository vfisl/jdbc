package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxSession.Reset;

public class PreResult {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb";
		String username="root";
         String password="root";
         Connection connection=null;
         PreparedStatement PreparedStatement=null;
        
         ResultSet resultSet=null;
				try {
					connection =DriverManager.getConnection(url,username,password);
					String sql="select* from food whre type='veg'";
					PreparedStatement=connection.prepareStatement(sql);
					PreparedStatement.setString(1, "veg");
					while(resultSet.next());
					String name =resultSet.getString("name");
					int foodId=resultSet.getInt("food_id");
					String type=resultSet.getString("type");
					float cost=resultSet.getFloat("coat");
					System.out.println(name+"\t"+foodId+"\t"+type+"\t"+cost);
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(connection!=null)
							connection.close();
						if(PreparedStatement!=null)
							PreparedStatement.close();
					}catch(SQLException e) {
						e.printStackTrace();
				}
	}
	}

}
