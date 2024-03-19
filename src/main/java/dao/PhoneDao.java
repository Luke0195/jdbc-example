
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;
import entities.Phone;

public class PhoneDao {
	
	
	private Connection connection;
	
	
	
	public PhoneDao() {
		this.connection = SingleConnection.getConnection();
	}
	
	
	public void insert(Phone phone)  {
		String querySql = "INSERT INTO phones(phone_1, phone_2, user_id) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(querySql);
			preparedStatement.setString(1, phone.getPhone1());
			preparedStatement.setString(2, phone.getPhone2());
			preparedStatement.setLong(3, phone.getUserId());
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
			e.printStackTrace();
		}
		
	}
	
	private static void rollback(Connection connection){
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
