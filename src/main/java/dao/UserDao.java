package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;
import entities.User;

public class UserDao {
	
	private Connection connection = null;
	
	public UserDao() {
		this.connection = SingleConnection.getConnection();
	}
	
	public void createUser(User user) throws SQLException {
	 String querySql = "INSERT INTO users(id,name, email) VALUES(?,?,?)";
	 PreparedStatement preparedStatement = connection.prepareStatement(querySql);
	 preparedStatement.setLong(1, user.getId());
	 preparedStatement.setString(2, user.getName());
	 preparedStatement.setString(3, user.getEmail());
	 preparedStatement.execute();
	 connection.commit();
	}
	

}
