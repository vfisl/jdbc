package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreUpdate {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb";
		String username="root";
         String password="root";
         Connection connection=null;
         PreparedStatement ps=null;
        
         ResultSet resultSet=null;
				try {
					connection =DriverManager.getConnection(url,username,password);
					String sql="update policy set type=? where policy_id=? ";
					ps=connection.prepareStatement(sql);
				ps.setString(1, "health");
				ps.setInt(2,10);
				ps.execute();
					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(connection!=null)
							connection.close();
						if(ps!=null)
							ps.close();
					}catch(SQLException e) {
						e.printStackTrace();
				}
	}
	}

}
