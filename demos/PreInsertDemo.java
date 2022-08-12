package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreInsertDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb";
		String username="root";
         String password="root";
         Connection connection=null;
         PreparedStatement PreparedStatement=null;
        
				try {
					connection =DriverManager.getConnection(url,username,password);
					String sql="insert into food values(?????)";
					PreparedStatement=connection.prepareStatement(sql);
					PreparedStatement.setString(1, "dosa");
					PreparedStatement.setInt(2, 10);
					PreparedStatement.setFloat(3,100);
					PreparedStatement.setString(4, "veg");
					PreparedStatement.execute();
					
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